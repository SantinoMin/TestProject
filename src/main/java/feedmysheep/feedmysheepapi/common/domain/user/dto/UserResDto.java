package feedmysheep.feedmysheepapi.common.domain.user.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class UserResDto {

  @AllArgsConstructor
  @Getter
  @Setter
  public static class joinUser {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;

  }
};