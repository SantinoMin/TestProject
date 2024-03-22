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
    private String memberName;
    private String memberPassword;
    private String memberEmail;


// entity -> dto로 변환하기
   public static MemberDTO toMemberDTO(MemberEntity memberEntity){
       MemberDTO memberDTO = new MemberDTO();
       memberDTO.setId(memberDTO.getId());
       memberDTO.setMemberName(memberEntity.getMemberName());
       memberDTO.setMemberEmail(memberEntity.getMemberEmail());
       memberDTO.setMemberPassword(memberEntity.getMemberPassword());
       return memberDTO;
   }
};