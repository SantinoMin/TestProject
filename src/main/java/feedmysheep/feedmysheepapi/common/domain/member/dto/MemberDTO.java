package feedmysheep.feedmysheepapi.common.domain.member.dto;

import feedmysheep.feedmysheepapi.common.models.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDTO {
    private Long id;
    private String member_name;
    private String member_password;
    private String member_email;

    // entity -> dto로 변환하기
   public static MemberDTO toMemberDTO(MemberEntity memberEntity){
       MemberDTO memberDTO = new MemberDTO();
       memberDTO.setId(memberDTO.getId());
       memberDTO.setMember_name(memberEntity.getMember_name());
       memberDTO.setMember_email(memberEntity.getMember_email());
       memberDTO.setMember_password(memberEntity.getMember_password());
       return memberDTO;
   }
}
