package feedmysheep.feedmysheepapi.common.domain.member.service;

import feedmysheep.feedmysheepapi.common.domain.member.dto.MemberDTO;
import feedmysheep.feedmysheepapi.common.domain.member.repository.MemberRepository;
import feedmysheep.feedmysheepapi.common.models.MemberEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;


  public void save(MemberDTO memberDTO) {

    // 1. dto -> entity 변환
    // 2. Repository의 save 메서드 호출
    MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
    memberRepository.save(memberEntity);

    // repository의 save메서드 호출 (조건. entity객체를 넘겨줘야 함)
    System.out.println(memberEntity);
  }

  public MemberDTO login(MemberDTO memberDTO) {

    /*
    1. 회원이 입력한 이메일로 DB에서 조회를 함
    2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
     */
    Optional<MemberEntity> byMemberNameAndEmail = memberRepository.findByMemberNameAndEmail(
        memberDTO.getMemberName(), memberDTO.getMemberEmail());
    if (byMemberNameAndEmail.isPresent()) {
      // 조회 결과가 있다(해당 이름 및 이메일을 가진 회원 정보가 있다)
      MemberEntity memberEntity = byMemberNameAndEmail.get();
      if (memberEntity.getMemberName().equals(memberDTO.getMemberName())
          && memberEntity.getMemberEmail().equals(memberDTO.getMemberEmail())) {
        // 비밀번호 일치
        // !중요!
        // entity -> dto 변환 후 리턴
        MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
        return dto;

      } else {
        // 비밀번호 불일치(로그인 실패)
        return null;
      }
    } else {
      // 조회 결과가 없다(해당 이름 및 이메일을 가진 회원이 없다)
      return null;
    }

//    memberRepository.findByMemberEmail(member_name, member_email)
//        .orElseThrow(() -> new CustomException(ErrorMessage.NOT_FOUND_MEMBER));

//    return null;
  }

  public List<MemberDTO> findAll() {
    List<MemberEntity> memberEntityList = memberRepository.findAll();

    List<MemberDTO> memberDTOList = new ArrayList<>();
    for (MemberEntity memberEntity : memberEntityList) {
      memberDTOList.add(MemberDTO.toMemberDTO(memberEntity));
    }
    return memberDTOList;
  }

  public MemberDTO findById(Long id) {
    Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);
    if (optionalMemberEntity.isPresent()) {
//      MemberEntity memberEntity = optionalMemberEntity.get();
//      MemberDTO memberDTO = MemberDTO.toMemberDTO(memberEntity);
//      return memberDTO;
      return MemberDTO.toMemberDTO(optionalMemberEntity.get());
    } else {

      return null;
    }
}

  public MemberDTO updateForm(String myEmail, String myName) {
    Optional<MemberEntity> optionalMemberEntity= memberRepository.findByMemberNameAndEmail(myEmail, myName);
    if (optionalMemberEntity.isPresent()){
      return MemberDTO.toMemberDTO(optionalMemberEntity.get());
    } else {
      return null;
    }

  }

  public void update(MemberDTO memberDTO) {
    memberRepository.save(MemberEntity.toUpdateMemberEntity(memberDTO));

  }

  public void deleteById(Long id) {
    memberRepository.deleteById(id);
  }
};
