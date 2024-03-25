package feedmysheep.feedmysheepapi.common.domain.user.dto;

import jakarta.validation.Valid;
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
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@Data
@ToString
@NoArgsConstructor
public class UserReqDto {

  @Id
  private int id;

  @NotBlank(message = "name is required.")
  @Size(min = 3, max = 20, message = "The username must be from 3 to 20 characters.")
  private String name;

  @NotBlank(message = "The password is required.")
  @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*()]).{8,}$", message = "Password must be 8 characters long and combination of uppercase letters, lowercase letters, numbers, special characters.")
  private String password;

  @NotNull(message = "birthday is required")
  private LocalDate birthday;

  // @Valid annotation to address field inside its parent class.
  //! adress 필드에 "랜덤한 String값을 작성하면, 에러 메시지가 안 뜸" -> 필요시 해결 필요
  @Valid
  @NotNull(message = "The address is required.")
  private AddressDTO address;

  @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "올바른 전화번호 형식이어야 합니다.")
  @NotNull(message = "phone is required.")
  private String phone;

  //      @NotNull(message = "gender는 필수 값입니다.")
  //    private Gender gender;

  @NotEmpty(message = "The email is required.")
  @Email(message = "The email is not a valid email. You may need to include @ ")
  private String email;

  //dto에서는 is_valid작성 안해도 될듯? entity 작성할 때, 필드값으로 is_valid=false를 default로 설정하기.
  private boolean is_valid;

  //??????
  @NotNull(message = "The register date is required.")
  @Past(message = "The register date must be in the past.")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate register_date;

//  @NotNull(message = "update date is required")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate update_date;


  // entity -> dto로 변환하기
//  public static UserReqDto toUserReqDto(UserEntity userEntity) {
//    UserReqDto userReqDto = new UserReqDto();
//    userReqDto.setId(userEntity.getId());
//    userReqDto.setName(userEntity.getName());
//    userReqDto.setPhone(userEntity.getPhone());
//    return userReqDto;
//  }
}