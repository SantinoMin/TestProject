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

//  public List<UserEntity> user(String id){
//
//     List<UserEntity> findUser = this.userRepository.findAll().stream().map(n -> n.getName()).toList();
//    System.out.println(findUser);
//    return findUser;
//  }


  public JoinUserDto join(UserReqDto.joinUser body
  ) {

    String name = body.getName();
    String phone = body.getPhone();

    // 1) UserEntity에 해당하는 필드값들을 user라는 변수에 담기.
    UserEntity userData = UserEntity.builder()
        .id(body.getId())
        .name(body.getName())
        .password(body.getPassword())
        .phone(body.getPhone())
        .address(body.getAddress())
        .birthday(body.getBirthday())
        .is_valid(body.is_valid())
        .register_date(body.getRegister_date())
        .update_date(body.getUpdate_date())
        .build();

    System.out.println(userData);

    // 2) userRepository에 1)에서 넣었던 값들을 저장.
    UserEntity joinUser = this.userRepository.save(userData);

    // 3) 중복된 유저인지 확인
    this.userRepository.findUserByPhoneNumber(name, phone)
        .orElseThrow(() -> new CustomException(ErrorMessage.ALREADY_JOINED_USER)
        );

    System.out.println(joinUser);

  //중복된 유저인지 찾기(중복으로 걸러낼 값: 폰번호) -> 3)에서 완료 // 근데 값 중복된 경우, 그냥 실행될 경우 메시지 띄우는 건 아직 미완료.


  //휴대폰 인증번호 받는 법 알아보기
  //주소 입력하는건 어떻게 하지?
  //로그인

  //원하는 타입만 가져오려고 만든거
  JoinUserDto joinUserDto = new JoinUserDto(
      body.getName(), body.getBirthday(),
      body.getAddress(), body.getPhone(), body.is_valid(), body.getRegister_date()
  );

    System.out.println(joinUserDto);

    return joinUserDto;
}
};