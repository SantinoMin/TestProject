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
  public UserService(UserRepository userRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }


  // 회원가입
  public UserResDto.message join(UserReqDto body
  ) {

    LocalDate registerDate = LocalDate.now();
    LocalDate updateDate = LocalDate.now();
    String password = body.getPassword();

    // body에서 가져온 dto값인데, Entity로 변환한거라고 보면 됨?ㅇㅇ
    UserEntity user = UserEntity.builder()
        .id(body.getId())
        .name(body.getName())
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

    Optional<UserEntity> duplicateUserByEmailOrPhoneNumber =
        this.userRepository.findUserByEmailAndPhone(body.getEmail(), body.getPhone());

    // 1. 이미 등록된 회원인 경우 -> 회원가입 안 됨 => 에러 메시지 띄우고 추가 작업 x
    duplicateUserByEmailOrPhoneNumber.ifPresent(duplicateUser -> {
      System.out.println("이미 등록된 회원입니다.");
      throw new CustomException(ErrorMessage.USER_ALREADY_EXIST);
    });

    // 2. repository에서 회원 찾기 후, 중복되는 회원 없다면, 가입 하도록.
    List<UserEntity> findAllUser = this.userRepository.findAll();
    List<UserEntity> duplicateUser = findAllUser.stream().filter(checkUser ->
        checkUser.getPhone().equals(body.getPhone()) && checkUser.getEmail()
            .equals(body.getEmail())).toList();

    //?? 근데 성공했을 때에도 CustomException으로 실행함?
    if (duplicateUser.isEmpty()) {
      this.userRepository.save(user);
      System.out.println("회원가입에 성공 하였습니다.");

      throw new CustomException(ErrorMessage.SUCCESS);

//      UserResDto.message userResDto = UserResDto.toMessage(user);
//      return userResDto;
    } else {
      System.out.println("이메일 또는 휴대폰 번호가 이미 존재합니다.");
      throw new CustomException(ErrorMessage.DUPLICATE_EMAILORPHONE);
    }
  }

  ;

  public  ResponseEntity<LoginUserResDto> login(LoginUserReqDto body) {

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