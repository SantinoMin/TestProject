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


  private String name;
  //    private LocalDate birthday;
  private String address;
  private String email;
  //    private Gender gender;
//  private String phone;
  private String message;


  @RequiredArgsConstructor
  @Getter
  @Setter
  public static class loginUser {

    private String name;

    private String address;
    private String email;
    private String phone;
    //    private Gender gender;
    //    private LocalDate birthday;
//    private boolean is_valid;

  }

    public static LoginUserResDto toUserDto(UserEntity userEntity){
      LoginUserResDto userDto = new LoginUserResDto();
      userDto.setName(userEntity.getName());
      userDto.setAddress(userEntity.getAddress());
//      userDto.setPhone(userEntity.getPhone());
      userDto.setEmail(userEntity.getEmail());
      return userDto;
    }
}