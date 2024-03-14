package feedmysheep.feedmysheepapi.common.domain.user.dto;

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
    private boolean is_valid;


    public joinUser(String name, LocalDate birthday, String address,
//        Gender gender,
        String phone, boolean valid) {
      this.name = name;
      this.birthday = birthday;
      this.address = address;
//      this.gender = gender;
      this.phone = phone;
      this.is_valid = valid;
    }
}};