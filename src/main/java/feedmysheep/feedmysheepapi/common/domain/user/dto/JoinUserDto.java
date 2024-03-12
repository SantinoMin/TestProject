package feedmysheep.feedmysheepapi.common.domain.user.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JoinUserDto {

  private String name;
  private LocalDate birthday;
  private String address;
  private boolean gender;
  private String phone;
  private boolean isValid;



  //매개변수를 받는 생성(필드 초기화)
//  public JoinUserDto(String name, String address, Date birthday) {
//
//
//  }


  public JoinUserDto(String name, LocalDate birthday, String address, boolean gender, String phone, boolean valid) {
    this.name = name;
    this.birthday = birthday;
    this.address = address;
    this.gender = gender;
    this.phone = phone;
    this.isValid = valid;
  }
};
