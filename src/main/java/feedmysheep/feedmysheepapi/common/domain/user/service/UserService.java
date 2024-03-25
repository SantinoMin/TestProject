package feedmysheep.feedmysheepapi.common.domain.user.service;

import feedmysheep.feedmysheepapi.common.domain.user.dto.LoginUserReqDto;
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

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  // 회원가입
  public UserResDto join(UserReqDto body
  ) {

    // body에서 가져온 dto값인데, Entity로 변환한거라고 보면 됨?ㅇㅇ
    UserEntity user = UserEntity.builder()
        .id(body.getId())
        .name(body.getName())
        .password(body.getPassword())
        .phone(body.getPhone())
        .email(body.getEmail())
//        .address(body.getAddress())
        .birthday(body.getBirthday())
//        .is_valid(body.is_valid())
//        .register_date(body.getRegister_date())
//        .update_date(body.getUpdate_date())
        .build();

    Optional<UserEntity> duplicateUserByEmailOrPhoneNumber =
        this.userRepository.findUserByEmailAndPhone(body.getEmail(), body.getPhone());
    if (duplicateUserByEmailOrPhoneNumber.isPresent()) {
      UserEntity byEmailAndPhoneNumberIsPresent = duplicateUserByEmailOrPhoneNumber.get();
      System.out.println("회원이 이미 있습니다.");

      if (byEmailAndPhoneNumberIsPresent.getEmail().equals(body.getEmail())
          || byEmailAndPhoneNumberIsPresent.getPhone().equals(body.getPhone())) {
        System.out.println("이메일 또는 휴대폰 번호가 이미 존재합니다.");
      }
      throw new CustomException(ErrorMessage.DUPLICATE_INFO);
    } else {
      //중복되는 회원이 없는 경우
      System.out.println("회원가입 가능합니다.");
      this.userRepository.save(user);
      throw new CustomException(ErrorMessage.SUCCESS);
    }
//    return UserResDto.joinUser.toUserDto(user);
  }

  ;;
  // 1) 이메일, 폰 일치하는 회원이 이미 있는 경우 -> 중복이라 회원가입 x
  // 2) 이메일, 폰 일치하는 회원이 없는 경우 -> 하나라도 일치 하는 경우 -> 중복이라 회원가입 x
  // 3) 이메일, 폰 둘 다 일치하는 회원이 없는 경우 -> 회원가입 가능

//      throw new CustomException(ErrorMessage.SUCCESS);

//       throw new CustomException(ErrorMessage.USER_ALREADY_EXIST);
  // 1) 두개 다 해당하는 값이 존재 시, "회원이 이미 있습니다" 출력

//        (this.userRepository.findUserByEmailAndPhone(body.getEmail(), body.getEmail()).equals(duplicateUserByEmailAndPhoneNumber.);

//      if (byEmailAndPhoneNumberIsPresent.getEmail().equals(body.getEmail())
//          || byEmailAndPhoneNumberIsPresent.getPhone().equals(body.getPhone())) {
//        System.out.println("이메일 또는 휴대폰 번호가 이미 존재합니다.");
//        throw new CustomException(ErrorMessage.DUPLICATE_INFO);
//        // 2) 두개 중 하나라도 불일치 시, 바로 empty로 반환됨
//      }
//    }}}

  // 이메일, 휴대폰 번호 둘 다 일치하지 않을 경우에도, 이메일과 휴대폰 중 하나라도 일치하는 경우 찾아야 함.

  //만약 duplicateUserByEmailAndPhoneNumber이 false라면,
//      Optional<UserEntity> byEmailAndPhoneNumberIsEmtpy = this.userRepository.findUserByEmailAndPhone(body.getEmail(),
//          body.getPhone());
//
//       UserEntity byEmailAndPhoneNumberNotOp = byEmailAndPhoneNumberIsEmtpy.orElseThrow( () -> new CustomException(ErrorMessage.NOT_FOUND_USER));
//
//      // 1) 두개 다 해당하는 값이 존재 시, "회원이 이미 있습니다" 출력
//      if (byEmailAndPhoneNumberIsEmtpy.getEmail().equals(body.getEmail())
//          || byEmailAndPhoneNumberIsEmtpy.getPhone().equals(body.getPhone())) {
//        System.out.println("이메일 또는 휴대폰 번호가 이미 존재합니다.");
//        throw new CustomException(ErrorMessage.DUPLICATE_INFO);
//        // 2) 두개 중 하나라도 불일치 시, 바로 empty로 반환됨
//      }
//    }

  public LoginUserResDto login(LoginUserReqDto body) {

    Optional<UserEntity> findUserByEmailAndPassword = this.userRepository.findUserByEmailAndPassword(
        body.getEmail(), body.getPassword());

    if (findUserByEmailAndPassword.isPresent()) {
      UserEntity userEntity = findUserByEmailAndPassword.get();
      if (userEntity.getEmail().equals(body.getEmail()) &&
          userEntity.getPassword().equals(body.getPassword())) {
        LoginUserResDto dto = LoginUserResDto.toUserDto(userEntity);
        System.out.println("로그인에 성공 하였습니다!");
        return dto;
      }
      System.out.println("findUserByEmailAndPassword 메서드가 존재하지 않습니다.");
      throw new CustomException(ErrorMessage.IS_EMPTY);
    }
    System.out.println("LoginUserResDto에 대한 값 반환하면 끝.");
    return new LoginUserResDto();
  }
};


//휴대폰 인증번호 받는 법 알아보기
//주소 입력하는건 어떻게 하지?
//LocalDate localdate = LocalDate.now(); 사용법?