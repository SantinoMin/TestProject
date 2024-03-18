package feedmysheep.feedmysheepapi.common.models;

import feedmysheep.feedmysheepapi.common.domain.member.dto.MemberDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "member_table")
public class MemberEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
  @Column(name = "id")
  private Long id;

  @Column(name = "member_email", unique = true) // unique 제약조건 추가
  private String member_email;

  @Column(name ="member_name")
  private String member_name;

  @Column(name = "member_password")
  private String member_password;



// dto -> entity로 변환하기 (아래와 같이)
  public static MemberEntity toMemberEntity(MemberDTO memberDTO){
    MemberEntity memberEntity = new MemberEntity();
    memberEntity.setMember_name(memberDTO.getMember_name());
    memberEntity.setMember_password(memberDTO.getMember_password());
    memberEntity.setMember_email(memberDTO.getMember_email());
    return memberEntity;
  }

  public static MemberEntity toUpdateMemberEntity(MemberDTO memberDTO){
    MemberEntity memberEntity = new MemberEntity();
    memberEntity.setId(memberDTO.getId());
    memberEntity.setMember_name(memberDTO.getMember_name());
    memberEntity.setMember_password(memberDTO.getMember_password());
    memberEntity.setMember_email(memberDTO.getMember_email());
    return memberEntity;
}};
