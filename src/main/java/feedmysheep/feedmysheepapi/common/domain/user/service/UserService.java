package feedmysheep.feedmysheepapi.common.domain.user.service;

import feedmysheep.feedmysheepapi.common.domain.user.dto.JoinUserDto;
import feedmysheep.feedmysheepapi.common.domain.user.dto.UserReqDto;
import feedmysheep.feedmysheepapi.common.domain.user.repository.UserRepository;
import feedmysheep.feedmysheepapi.common.global.utils.response.error.CustomException;
import feedmysheep.feedmysheepapi.common.global.utils.response.error.ErrorMessage;
import feedmysheep.feedmysheepapi.common.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public JoinUserDto join(UserReqDto.joinUser body
  ) {

    String name = body.getName();
    String phone = body.getPhone();

   // 1) UserEntity에 해당하는 필드값들을 user라는 변수에 담기.
    UserEntity userData = UserEntity.builder()
        .name(body.getName())
        .password(body.getPassword())
        .birthday(body.getBirthday())
        .address(body.getAddress())
        .gender(body.isGender())
        .phone(body.getPhone())
        .isValid(body.isValid())
        .build();

    // 2) userRepository에 1)에서 넣었던 값들을 저장.
    UserEntity joinUser = this.userRepository.save(userData);

    // 3) 중복된 유저인지 확인 // user는 값이 없는 추상적인 느낌임
    this.userRepository.findUserByPhoneNumber(name, phone)
        .ifPresent( user ->  {
          throw new CustomException(ErrorMessage.ALREADY_JOINED_USER);
        });

  //중복된 유저인지 찾기(중복으로 걸러낼 값: 폰번호) -> 3)에서 완료
  //휴대폰 인증번호 받는 법 알아보기
  //주소 입력하는건 어떻게 하지?
  //로그인

   System.out.println(joinUser);

//    UserEntity userInfo = this.userRepository.findUserByUserInfo(body.getName(), body.getBirthday(), body.getAddress())
//        .orElseThrow(() -> new CustomException(ErrorMessage.ALREADY_JOINED_USER));

    //원하는 타입만 가져오려고 만든거
  JoinUserDto joinUserDto = new JoinUserDto(
      body.getName(), body.getBirthday(),
      body.getAddress(), body.isGender(), body.getPhone(), body.isValid());

    return joinUserDto;
}
};