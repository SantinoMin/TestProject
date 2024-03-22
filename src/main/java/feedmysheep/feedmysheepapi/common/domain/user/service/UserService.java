package feedmysheep.feedmysheepapi.common.domain.user.service;

import feedmysheep.feedmysheepapi.common.domain.user.dto.LoginUserDto;
import feedmysheep.feedmysheepapi.common.domain.user.dto.LoginUserResDto;
import feedmysheep.feedmysheepapi.common.domain.user.dto.UserReqDto;
import feedmysheep.feedmysheepapi.common.domain.user.dto.UserResDto;
import feedmysheep.feedmysheepapi.common.domain.user.repository.UserRepository;
import feedmysheep.feedmysheepapi.common.global.utils.response.error.CustomException;
import feedmysheep.feedmysheepapi.common.global.utils.response.error.ErrorMessage;
import feedmysheep.feedmysheepapi.common.models.UserEntity;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  // 회원가입
  public UserResDto.joinUser join(UserReqDto body
  ) {

    // body에서 가져온 dto값인데, Entity로 변환한거라고 보면 됨?ㅇㅇ
    UserEntity user = UserEntity.builder()
        .id(body.getId())
        .name(body.getName())
        .password(body.getPassword())
        .phone(body.getPhone())
        .email(body.getEmail())
        .address(body.getAddress())
        .birthday(body.getBirthday())
        .is_valid(body.is_valid())
        .register_date(body.getRegister_date())
        .update_date(body.getUpdate_date())
        .build();

    Optional<UserEntity> checkDuplicateUserByNameAndPhoneNumber =
        this.userRepository.findUserByEmailAndPhone(body.getEmail(), body.getPhone());

    // 사용자가 입력한 값이(email,phone) 둘 중 하나라도 중복되는 값이 db에 있다면, "이미 등록된 회원" 메시지 띄우고 -> 회원가입 x
    if (checkDuplicateUserByNameAndPhoneNumber.isPresent()) {
      UserEntity joinUser = checkDuplicateUserByNameAndPhoneNumber.get();
      if (joinUser.getEmail().equals(body.getEmail()) || joinUser.getPhone().equals(body.getPhone())) {
        System.out.println("회원이 이미 있습니다.");
        throw new CustomException(ErrorMessage.USER_ALREADY_EXIST);
      }
    } else {
      System.out.println("회원가입 가능합니다.");
      this.userRepository.save(user);
      return UserResDto.joinUser.toUserDto(user);
    }
    //null 대신에 메시지를 띄우도록 해보기
    return null;
  }


  public LoginUserResDto login(LoginUserDto body) {

    Optional<UserEntity> findUserByEmailAndPassword = this.userRepository.findUserByEmailAndPassword(
        body.getEmail(), body.getPassword());

    if (findUserByEmailAndPassword.isPresent()) {
      UserEntity userEntity = findUserByEmailAndPassword.get();
      if (userEntity.getEmail().equals(body.getEmail()) &&
          userEntity.getPassword().equals(body.getPassword())) {
        LoginUserResDto dto = LoginUserResDto.toUserDto(userEntity);
        System.out.println("로그인에 성공 하였습니다!");
        return dto;
      } else {
        return null;
      }
    } else {
      return null;
    }
  }};

//휴대폰 인증번호 받는 법 알아보기
//주소 입력하는건 어떻게 하지?
//LocalDate localdate = LocalDate.now(); 사용법?