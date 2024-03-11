package feedmysheep.feedmysheepapi.common.domain.user.dto;

import jakarta.validation.constraints.NotNull;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class UserReqDto {


  @AllArgsConstructor
  @Getter
  public static class joinUser {

    @NotNull
    private String name;
    @NotNull
    private String password;
    @NotNull
    private Date birthday;
    @NotNull
    private String address;
    @NotNull
    private boolean gender;
    @NotNull
    private String phone;
    @NotNull
    private boolean valid;
  }
}
  ;