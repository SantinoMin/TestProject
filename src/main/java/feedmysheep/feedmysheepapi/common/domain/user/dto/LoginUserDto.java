package feedmysheep.feedmysheepapi.common.domain.user.dto;

import feedmysheep.feedmysheepapi.common.models.UserEntity;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class LoginUserDto {

  private int id;
  //    @NotNull(message = "id는 필수 값입니다.")
  private String name;
  //    @NotNull(message = "password는 필수 값입니다.")
  private String password;
  private String email;
  //    @NotNull(message = "birthday는 필수 값입니다.")
  private LocalDate birthday;
  //    @NotNull(message = "address는 필수 값입니다.")
  private String address;
//    @NotNull(message = "gender는 필수 값입니다.")
//    private Gender gender;

  private String phone;

  //    @NotNull(message = "valid는 필수 값입니다.")
  private boolean is_valid;

  private LocalDate register_date;
  private LocalDate update_date;


//  LocalDate localdate = LocalDate.now();


  // entity -> dto로 변환하기
  public static LoginUserDto toUserReqDto(UserEntity userEntity) {
    LoginUserDto userReqDto = new LoginUserDto();
    userReqDto.setId(userEntity.getId());
    userReqDto.setName(userEntity.getName());
    userReqDto.setPhone(userEntity.getPhone());
    return userReqDto;
  }
}