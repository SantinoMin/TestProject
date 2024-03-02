package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="member")
public class MemberEntity {

  @Id
  @Column(nullable = false)
  private String id;

  @Column(nullable = false)
  private String memberName;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private Long screenKey;



}
