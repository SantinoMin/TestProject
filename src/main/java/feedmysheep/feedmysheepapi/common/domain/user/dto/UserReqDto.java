package feedmysheep.feedmysheepapi.common.domain.user.dto;

import feedmysheep.feedmysheepapi.common.models.UserEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@ToString
public class UserReqDto {

  @Id
  private int id;

  @NotBlank(message = "name은 필수값입니다.")
  private String name;

  @NotBlank(message = "The password is required.")
  @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*()]).{8,}$", message = "Password must be 8 characters long and combination of uppercase letters, lowercase letters, numbers, special characters.")
  private String password;

  @NotNull(message = "birthday는 필수값입니다.")
  private LocalDate birthday;

  @NotNull(message = "The address is required.")
  private AddressDTO address;

  //      @NotNull(message = "gender는 필수 값입니다.")
  //    private Gender gender;
  @NotEmpty(message = "The email is required.")
  @Email(message = "The email is not a valid email.")
  private String email;

//  @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "올바른 전화번호 형식이어야 합니다.")
  @NotNull(message = "phone은 필수값입니다.")
  private String phone;

  private boolean is_valid;

  @NotNull(message = "The graduation date is required.")
  @Past(message = "The graduation date must be in the past.")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
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