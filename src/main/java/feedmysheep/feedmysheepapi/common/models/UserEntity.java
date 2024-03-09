package feedmysheep.feedmysheepapi.common.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name="user")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name= "id", nullable = false, unique = true)
  private int id;

  @Column(name="name", nullable = false)
  private String name;

  @Column(name="password", nullable = false)
  private String password;

  @Column(name="gender", nullable = false)
  private boolean gender;

  @Column(name = "phone", nullable = false, unique = true)
  private String phone;

  @Column(name = "address", nullable = false)
  private String address;

  @Column(name = "birthday", nullable = false)
  private Date birthday;

  @Column(name ="registeredDate", nullable = false)
  private Date registeredDate;

  @Column(name ="updateDate", nullable = false)
  private LocalDate updateDate;

  // active 상태 만드려면, 어떻게 설정 해야되는지?
  @Column(name="valid", nullable = false)
  private boolean valid;


}
