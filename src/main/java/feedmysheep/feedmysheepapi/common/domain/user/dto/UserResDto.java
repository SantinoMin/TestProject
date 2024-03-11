package feedmysheep.feedmysheepapi.common.domain.user.dto;

import java.util.Date;
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

    private String name;
    private Date birthday;
    private String address;
    private boolean gender;
    private String phone;
    private boolean isValid;


//    public JoinUser(String name,  Date birthday, String address, boolean gender, String phone, boolean valid) {
//      this.name = name;
//      this.birthday = birthday;
//      this.address = address;
//      this.gender = gender;
//      this.phone = phone;
//      this.isValid = valid;
//    }
}};