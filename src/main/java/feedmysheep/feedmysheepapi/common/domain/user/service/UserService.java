package feedmysheep.feedmysheepapi.common.domain.user.service;

import feedmysheep.feedmysheepapi.common.domain.user.dto.UserReqDto;
import feedmysheep.feedmysheepapi.common.domain.user.dto.UserResDto.joinUser;
import feedmysheep.feedmysheepapi.common.domain.user.repository.UserRepository;
import feedmysheep.feedmysheepapi.common.global.utils.response.error.CustomException;
import feedmysheep.feedmysheepapi.common.global.utils.response.error.ErrorMessage;
import feedmysheep.feedmysheepapi.common.models.UserEntity;
import java.util.Date;
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

  public Optional<joinUser> join(UserReqDto.joinUser body
  ) {

    String name = body.getName();
    String password = body.getPassword();
    Date birthday = body.getBirthday();

//    String phone = body.getPhone();
//    String address = body.getAddress();
//    Date birthday = body.getBirthday();
//    Date registeredDate = body.getRegisteredDate();
//    LocalDate updateDate = body.getUpdateDate();

//    userName 중복 check
    //!!!!근데 유저가 이미 있을 때, 에러를 띄워야함
    this.userRepository.findUserByUserInfo(name, birthday)
        .orElseThrow(() -> new CustomException(ErrorMessage.ALREADY_JOINED_USER));

    UserEntity user = UserEntity.builder()
        .name(name)
        .password(password)
//        .phone(phone)
//        .address(address)
        .build();
    userRepository.save(user);

//반환 타입을 어떻게 맞출 수 있지? ->
    return this.userRepository.findUserByUserInfo(name, birthday);
  }
}