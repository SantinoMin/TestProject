package feedmysheep.feedmysheepapi.common.domain.user.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class UserReqDto {


  @AllArgsConstructor
  @Getter
  public static class joinUser {

    @NotNull(message = "id는 필수 값입니다.")
    private String name;
    @NotNull(message = "password는 필수 값입니다.")
    private String password;
    @NotNull(message = "birthday는 필수 값입니다.")
    private LocalDate birthday;
    @NotNull(message = "address는 필수 값입니다.")
    private String address;
    @NotNull(message = "gender는 필수 값입니다.")
    private boolean gender;
    @NotNull(message = "phone는 필수 값입니다.")
    private String phone;
    @NotNull(message = "valid는 필수 값입니다.")
    private boolean isValid;
  }
}
  ;