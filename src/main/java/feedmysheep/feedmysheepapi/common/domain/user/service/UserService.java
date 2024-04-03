package feedmysheep.feedmysheepapi.common.domain.user.service;

import feedmysheep.feedmysheepapi.common.domain.user.dto.LoginUserReqDto;
import feedmysheep.feedmysheepapi.common.domain.user.dto.UserReqDto;
import feedmysheep.feedmysheepapi.common.domain.user.dto.UserResDto;
import feedmysheep.feedmysheepapi.common.domain.user.repository.UserRepository;
import feedmysheep.feedmysheepapi.common.global.utils.response.error.CustomException;
import feedmysheep.feedmysheepapi.common.global.utils.response.error.ErrorMessage;
import feedmysheep.feedmysheepapi.common.models.UserEntity;
import java.time.LocalDate;
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
  public ResponseEntity<UserResDto.message> join(UserReqDto body
  ) {

    LocalDate registerDate = LocalDate.now();
    LocalDate updateDate = LocalDate.now();

    String username = body.getUserName();
    String password = body.getPassword();
    String email = body.getEmail();
    String phone = body.getPhone();

    /**
     * 1.중복 회원 찾기(Email) And 중복 회원 찾기(Phone)
     */

    // 중복 회원 찾기(Email)
    Optional<UserEntity> duplicateUserByEmail = this.userRepository.findUserByEmail(email);
    // 중복 회원 찾기(Phone)
    Optional<UserEntity> duplicateUserByPhone = this.userRepository.findUserByPhone(phone);

    //세팅 다시하자
    // 1-1. 이메일 중복건 1-2. 폰 번호 중복건 -> 변수로 만들기
    // 2.

    // 회원가입 절차)
    // 1. 이메일 중복 -> 중복이라고 하고 끝
    // 2. 폰 번호 중복 -> 폰 번호 중복이라고 하고 끝
    // repository에서 저장되어 있는 user정보와 dto에서 얻은 user가 입력한 정보 비교하기.

    /**
     * 2. 이메일 또는 휴대폰 번호가 이미 존재하는 경우, 에러 메시지 띄우기
     */

    // 이메일 중복 검사
    duplicateUserByEmail.ifPresent(user -> {
      if (user.getEmail().equals(body.getEmail())) {
        throw new CustomException(ErrorMessage.DUPLICATE_EMAIL);
      }
    });

    // 휴대폰 번호 중복 검사
    duplicateUserByPhone.ifPresent(user -> {
      if(user.getPhone().equals(body.getPhone())){
        throw new CustomException(ErrorMessage.DUPLICATE_PHONE);
      }});


    /**
     * 3.duplicaeUserList에서 해당 user가 있는 경우 그대로 실행=중복 // 없는 경우 -> 회원 가입 가능.
     */

    boolean saveUser = userRepository.findDuplicateUserByPhoneAndEmail(body.getPhone(), body.getEmail()).isEmpty();

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
    success.setMessage("회원가입에 성공 하였습니다");

    return ResponseEntity.ok(success);
  }

  ;

  public ResponseEntity<UserResDto.message> login(LoginUserReqDto body) {

    Optional<UserEntity> UserByEmailAndPassword = this.userRepository.findUserByEmailAndPassword(
        body.getEmail(), body.getPassword());

    // 1) 이메일과 비밀번호 중 하나라도 일치하지 않는 경우, 에러 메시지 띄우기
    UserEntity findUserByEmailAndPassword = UserByEmailAndPassword.orElseThrow(
        () -> new CustomException(ErrorMessage.NOT_FOUND_USER));

    // 2) 이메일과 비밀번호 둘 다 일치할 경우, 로그인 성공
    if (findUserByEmailAndPassword.getEmail().equals(body.getEmail())
        && findUserByEmailAndPassword.getPassword().equals(body.getPassword())) {
      UserResDto.message dto = new UserResDto.message();

      System.out.println("로그인에 성공 하였습니다!");
      dto.setMessage("로그인에 성공하였습니다!"); // 성공 메시지 설정
      return ResponseEntity.ok(dto);
    }

    System.out.println("로그인에 실패 하였다.");
    throw new CustomException(ErrorMessage.FAILTOLOGIN);
  }
};