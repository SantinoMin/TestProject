package feedmysheep.feedmysheepapi.common.domain.user.service;

import feedmysheep.feedmysheepapi.common.domain.user.dto.UserReqDto;
import feedmysheep.feedmysheepapi.common.domain.user.dto.UserResDto;
import feedmysheep.feedmysheepapi.common.domain.user.dto.UserResDto.joinUser;
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

  public UserResDto.joinUser join(UserReqDto.joinUser body
  ) {

    //1번 또는 2번으로 사용하기
    // 1번
    UserEntity user = UserEntity.builder()
        .name(body.getName())
        .password(body.getPassword())
        .birthday(body.getBirthday())
        .address(body.getAddress())
        .gender(body.isGender())
        .phone(body.getPhone())
        .valid(body.isValid())
        .build();

    // 2번
//    UserEntity userInfo = new UserEntity();
//    userInfo.setName(body.getName());
//    userInfo.setPassword(body.getPassword());
//    userInfo.setBirthday(body.getBirthday());
//    userInfo.setAddress(body.getAddress());
//    userInfo.setGender(body.isGender());
//    userInfo.setPhone(body.getPhone());
//    userInfo.setValid(body.isValid());

    //!!!UserEntity를 사용해서, 값들을 userRepository에 저장하고
    this.userRepository.save(user);

    System.out.println(user);

//    userName 중복 check
    //!!!!근데 유저가 이미 있을 때, 에러를 띄워야함

// JoinUserDto를 통하여, 원하는 값들만 받아 온 후, 그 값들을 반환하기.

    //dto랑 매핑될 값들 설정
    // 타입으로 dto 값들을 만들어보기

//    return this.~~mapper.difeifef(entity);

    joinUser userInfo = this.userRepository.findUserByUserInfo(body.getName(), body.getBirthday(), body.getAddress())
        .orElseThrow(() -> new CustomException(ErrorMessage.ALREADY_JOINED_USER));

    UserResDto.joinUser userJoinInfo = new UserResDto.joinUser(body.getName(), body.getBirthday(),
        body.getAddress(), body.isGender(), body.getPhone(), body.isValid());

    return userJoinInfo;
  }
};