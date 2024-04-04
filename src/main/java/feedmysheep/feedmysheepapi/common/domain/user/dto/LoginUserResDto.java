package feedmysheep.feedmysheepapi.common.domain.user.dto;

import feedmysheep.feedmysheepapi.common.models.UserEntity;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Data
@Setter
@Getter
public class LoginUserResDto {


  private String userName;
  private String address;
  private String email;
  private String message;


  @RequiredArgsConstructor
  @Getter
  @Setter
  public static class loginUser {

    private String name;
    private String address;
    private String email;
    private String phone;

  }


  public static LoginUserResDto toUserDto(UserEntity userEntity) {
    LoginUserResDto userDto = new LoginUserResDto();
    userDto.setUserName(userEntity.getUsername());
    userDto.setAddress(userEntity.getAddress());
    userDto.setEmail(userEntity.getEmail());
    return userDto;
  }
}