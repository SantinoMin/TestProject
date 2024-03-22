package feedmysheep.feedmysheepapi.common.domain.user.dto;

import feedmysheep.feedmysheepapi.common.models.UserEntity;
import java.time.LocalDate;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Data

public class UserResDto {

  @RequiredArgsConstructor
  @Getter
  @Setter
  public static class joinUser {

    private String name;
    private LocalDate birthday;
    private String address;
//    private Gender gender;
    private String phone;
    private String email;
//    private boolean is_valid;

//    @RequiredArgsConstructor
//    @Getter
//    @Setter
//    public static class joinUser {
//
//      private String name;
//      private LocalDate birthday;
//      private String address;
//      //    private Gender gender;
//      private String phone;
////    private boolean is_valid;
//

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
}};