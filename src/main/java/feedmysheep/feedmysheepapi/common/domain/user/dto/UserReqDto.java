package feedmysheep.feedmysheepapi.common.domain.user.dto;

import feedmysheep.feedmysheepapi.common.models.Gender;
import feedmysheep.feedmysheepapi.common.models.UserEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Data
@ToString
@NoArgsConstructor
public class UserReqDto {

  @Id
  private int id;

  @NotBlank(message = "userName is required.")
  @Size(min = 3, max = 20, message = "The username must be from 3 to 20 characters.")
  private String userName;

  @NotNull(message = "enter type of the Male or Female")
  private Gender gender;

  @NotBlank(message = "The password is required.")
  @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*()]).{8,}$", message = "Password must be 8 characters long and combination of uppercase letters, lowercase letters, numbers, special characters.")
  private String password;

  @NotNull(message = "birthday is required")
  private LocalDate birthday;

  // @Valid annotation to address field inside its parent class.
  //! adress 필드에 "랜덤한 String값을 작성하면, 에러 메시지가 안 뜸" -> 필요시 해결 필요
  @NotNull(message = "The address is required.")
  private String address;

  @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "올바른 전화번호 형식이어야 합니다.")
  @NotNull(message = "phone is required.")
  private String phone;

  @NotEmpty(message = "The email is required.")
  @Email(message = "The email is not a valid email. You may need to include @ ")
  private String email;

  //dto에서는 is_valid작성 안해도 될듯? entity 작성할 때, 필드값으로 is_valid=false를 default로 설정하기.
  private boolean is_valid = false;

//  @NotNull(message = "The register date is required.")
//  @Past(message = "The register date must be in the past.")
//  @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "날짜 형식이 유효하지 않습니다. (yyyy-MM-dd)")
//  private LocalDate register_date;

//  @NotNull(message = "update date is required")
//  @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "날짜 형식이 유효하지 않습니다. (yyyy-MM-dd)")
//  private LocalDate update_date;


  // entity -> dto로 변환하기
  public static UserReqDto toUserReqDto(UserEntity userEntity) {
    UserReqDto userReqDto = new UserReqDto();
    userReqDto.setId(userEntity.getId());
    userReqDto.setUserName(userEntity.getUsername());
    userReqDto.setPhone(userEntity.getPhone());
    return userReqDto;
  }
}