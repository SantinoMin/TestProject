package feedmysheep.feedmysheepapi.common.domain.user.dto;

import feedmysheep.feedmysheepapi.common.models.Gender;
import feedmysheep.feedmysheepapi.common.models.UserEntity;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
@Data
public class UserResDto {

  public String message;

  @Getter
  @Setter
  public static class joinUser {

    private String userName;
    private LocalDate birthday;
    private String address;
    private Gender gender;
    private String phone;
    private String email;
    private String message;
  }

  @Setter
  @Getter
  public static class message {
    private String message;

  }

  public static UserResDto.message toMessage(UserEntity userEntity){
    UserResDto.message userDto = new UserResDto.message();
    userDto.setMessage(userEntity.getMessage());
    return userDto;
  }


  public static UserResDto.joinUser toJoinUserDto(UserEntity userEntity){
      UserResDto.joinUser userDto = new UserResDto.joinUser();
      userDto.setUserName(userEntity.getUsername());
      userDto.setBirthday(userEntity.getBirthday());
      userDto.setAddress(userEntity.getAddress());
      userDto.setPhone(userEntity.getPhone());
//      userDto.set_valid(userEntity.is_valid());
      userDto.setEmail(userEntity.getEmail());
      return userDto;
    }
};