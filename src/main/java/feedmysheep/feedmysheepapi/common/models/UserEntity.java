package feedmysheep.feedmysheepapi.common.models;

import feedmysheep.feedmysheepapi.common.domain.user.dto.UserReqDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "user")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true)
  private int id;

  @Column(name="role", nullable = false)
  private String role;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "gender", nullable = false)
  @Enumerated(EnumType.STRING)
  private Gender gender;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "phone", nullable = false, unique = true)
  private String phone;

  @Column(name = "address", nullable = false)
  private String address;

  @Column(name = "birthday", nullable = false)
  private LocalDate birthday;

  // active 상태 만드려면, 어떻게 설정 해야되는지?
  // boolean은 default가 false이긴 함, 그래도 설정해주기.
  @Column(name = "is_valid", nullable = false)
  private boolean is_valid = false;

  @Column(name = "register_date", nullable = false)
  private LocalDate register_date;

  @Column(name = "update_date", nullable = false)
  private LocalDate update_date;

  @Column(name ="message", nullable = true)
  private String message;


  // dto -> entity로 변환하기
  public static UserEntity toUserEntity(UserReqDto userReqDto) {
    UserEntity userEntity = new UserEntity();
    userEntity.setUsername(userReqDto.getUserName());
    userEntity.setPhone(userReqDto.getPhone());
    userEntity.setEmail(userReqDto.getEmail());
    userEntity.setAddress(userReqDto.getAddress());
    userEntity.setBirthday(userReqDto.getBirthday());
    return userEntity;
  }
};
