package feedmysheep.feedmysheepapi.common.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "password", nullable = false)
  private String password;

//  @Column(name="gender", nullable = true)
//  @Enumerated(EnumType.STRING)

//  private Gender gender;

  @Column(name = "phone", nullable = false, unique = true)
  private String phone;

  @Column(name = "address", nullable = false)
  private String address;

  @Column(name = "birthday", nullable = false)
  private LocalDate birthday;

  // active 상태 만드려면, 어떻게 설정 해야되는지?
  @Column(name = "is_valid", nullable = false)
  private boolean is_valid;

  @Column(name = "register_date", nullable = false)
  private LocalDate register_date;

  @Column(name = "update_date", nullable = false)
  private LocalDate update_date;

}
