package feedmysheep.feedmysheepapi.common.domain.user.dto;

import feedmysheep.feedmysheepapi.common.models.UserEntity;
import java.time.LocalDate;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class UserResDto {

  private String message;

  @Getter
  @Setter
  public static class joinUser {

    private String name;
    private LocalDate birthday;
    private AddressDTO address;
    //    private Gender gender;
    private String phone;
    private String email;
//    private boolean is_valid;
  }

  public UserResDto(boolean b, String message) {
    this.message = message;
  }
  public static UserResDto of(String message){
    return new UserResDto(false, message);
  }


  public static UserResDto.joinUser toUserDto(UserEntity userEntity){
      UserResDto.joinUser userDto = new UserResDto.joinUser();
      userDto.setName(userEntity.getName());
//      userDto.setBirthday(userEntity.getBirthday());
//      userDto.setAddress(userEntity.getAddress());
      userDto.setPhone(userEntity.getPhone());
//      userDto.set_valid(userEntity.is_valid());
      userDto.setEmail(userEntity.getEmail());
      return userDto;
    }
};