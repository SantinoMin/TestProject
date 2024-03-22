package feedmysheep.feedmysheepapi.common.domain.user.dto;

import feedmysheep.feedmysheepapi.common.models.UserEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class UserReqDto {

  private int id;

  @NotBlank(message = "name은 필수값입니다.")
  private String name;

  @NotBlank(message = "password는 필수값입니다.")
  private String password;

  @NotNull(message = "birthday는 필수값입니다.")
  private LocalDate birthday;

  @NotBlank(message = "address는 필수값입니다.")
  private String address;

  //      @NotNull(message = "gender는 필수 값입니다.")
  //    private Gender gender;

  @Email
  private String email;

//  @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "올바른 전화번호 형식이어야 합니다.")
  @NotNull(message = "phone은 필수값입니다.")
  private String phone;

  private boolean is_valid;

  private LocalDate register_date;
  private LocalDate update_date;


  // entity -> dto로 변환하기
  public static UserReqDto toUserReqDto(UserEntity userEntity) {
    UserReqDto userReqDto = new UserReqDto();
    userReqDto.setId(userEntity.getId());
    userReqDto.setName(userEntity.getName());
    userReqDto.setPhone(userEntity.getPhone());
    return userReqDto;
  }
}