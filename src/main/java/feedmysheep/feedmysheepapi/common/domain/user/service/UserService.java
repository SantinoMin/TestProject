package feedmysheep.feedmysheepapi.common.domain.user.service;

import feedmysheep.feedmysheepapi.common.domain.user.dto.LoginUserReqDto;
import feedmysheep.feedmysheepapi.common.domain.user.dto.LoginUserResDto;
import feedmysheep.feedmysheepapi.common.domain.user.dto.UserReqDto;
import feedmysheep.feedmysheepapi.common.domain.user.dto.UserResDto;
import feedmysheep.feedmysheepapi.common.domain.user.repository.UserRepository;
import feedmysheep.feedmysheepapi.common.global.utils.response.error.CustomException;
import feedmysheep.feedmysheepapi.common.global.utils.response.error.ErrorMessage;
import feedmysheep.feedmysheepapi.common.models.UserEntity;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  /**
   * 회원가입
   */
  public UserResDto.message join(UserReqDto body
  ) {

    LocalDate registerDate = LocalDate.now();
    LocalDate updateDate = LocalDate.now();

    String username = body.getUserName();
    String password = body.getPassword();
    String email = body.getEmail();
    String phone = body.getPhone();

    /**
     * 중복 회원 찾기(Email) And 중복 회원 찾기(Phone)
     */
    Optional<UserEntity> duplicateUserByEmail =
        this.userRepository.findUserByEmail(email);

    Optional<UserEntity> duplicateUserByPhone =
        this.userRepository.findUserByPhone(phone);

    /**
     * 1. 이메일 또는 휴대폰 번호가 이미 존재하는 경우, 에러 메시지 띄우기
     */

    UserEntity byEmail = duplicateUserByEmail.orElseThrow(
        () -> new CustomException(ErrorMessage.DUPLICATE_EMAIL));
    System.out.println("이메일 중복!");

    UserEntity byPhone = duplicateUserByPhone.orElseThrow(
        () -> new CustomException(ErrorMessage.DUPLICATE_PHONE));
    System.out.println("휴대폰 번호 중복!");

    /**
     * 2. duplicateUserList에서 email,phone 둘 다 중복되는 경우 -> 둘 다 중복
     * 2-1.duplicaeUserList에서 둘 다 해당하는 경우 없으면 -> 회원 가입 가능.
     */
    List<UserEntity> duplicateUserList = this.userRepository.findDuplicateUser(body.getEmail(),
            body.getPhone())
        .stream()
        .filter(user -> user.getEmail().equals(body.getEmail()) && user.getPhone()
            .equals(body.getPhone()))
        .toList();

    duplicateUserList.forEach(user -> {
      if (user.getEmail().equals(body.getEmail()) && user.getPhone().equals(body.getPhone())) {
        System.out.println("해당 유저가 이미 존재합니다.(이메일, 휴대폰 번호 둘 다 중복");
        throw new CustomException(ErrorMessage.USER_ALREADY_EXIST);
      }
    });

    /**
     * 3. 회원가입 가능할 경우
     */
    duplicateUserList.stream().findAny()
        .orElseThrow(() -> new CustomException(ErrorMessage.SUCCESS));

    // repository에 저장할 데이터 설정
    UserEntity user = UserEntity.builder()
        .id(body.getId())
        .username(body.getUserName())
        .role("ROLE_ADMIN")
        .gender(body.getGender())
        //bCryptPassword로 보안 강화
        .password(bCryptPasswordEncoder.encode(password))
        .phone(body.getPhone())
        .email(body.getEmail())
        .address(body.getAddress())
        .birthday(body.getBirthday())
        .is_valid(body.is_valid())
        .register_date(registerDate)
        .update_date(updateDate)
        .build();

    this.userRepository.save(user);
    System.out.println("회원가입에 성공 하였습니다.");

    UserResDto.message success = new UserResDto.message();
    success.setMessage("성공");

    return success;
  }

  ;;;

  public ResponseEntity<LoginUserResDto> login(LoginUserReqDto body) {

    Optional<UserEntity> UserByEmailAndPassword = this.userRepository.findUserByEmailAndPassword(
        body.getEmail(), body.getPassword());

    // 1) 이메일과 비밀번호 중 하나라도 일치하지 않는 경우, 에러 메시지 띄우기
    UserEntity findUserByEmailAndPassword = UserByEmailAndPassword.orElseThrow(
        () -> new CustomException(ErrorMessage.NOT_FOUND_USER));

    // 2) 이메일과 비밀번호 둘 다 일치할 경우, 로그인 성공
    if (findUserByEmailAndPassword.getEmail().equals(body.getEmail())
        && findUserByEmailAndPassword.getPassword().equals(body.getPassword())) {
      LoginUserResDto dto = LoginUserResDto.toUserDto(findUserByEmailAndPassword);

      System.out.println("로그인에 성공 하였습니다!");
      dto.setMessage("로그인에 성공하였습니다!"); // 성공 메시지 설정
//      throw new CustomException(ErrorMessage.SUCCESS);
//      return dto;
      return ResponseEntity.ok(dto);
    }

    //해당 부분이 실행이 될 가능성이 있으려나? -> 없어 보임
    //아니면 return null;로 하는게 나을까?
    System.out.println("로그인에 실패 하였다.");
    throw new CustomException(ErrorMessage.FAILTOLOGIN);
  }
};