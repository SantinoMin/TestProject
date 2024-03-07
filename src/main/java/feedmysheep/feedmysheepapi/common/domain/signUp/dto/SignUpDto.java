package feedmysheep.feedmysheepapi.common.domain.signUp.dto;

import lombok.Data;


@Data
public class SignUpDto {
     private Long id;
     private String userName;
     private String email;

    public SignUpDto(Long id, String userName, String email) {
      this.id= id;
      this.userName=userName;
      this.email=email;

    }

  public void setId(Long id) {
    this.id = id;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setEmail(String email) {
    this.email = email;
  }
};