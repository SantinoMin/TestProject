package feedmysheep.feedmysheepapi.common.domain.member.service;

import feedmysheep.feedmysheepapi.common.domain.member.dto.MemberDTO;
import feedmysheep.feedmysheepapi.common.domain.member.repository.MemberRepository;
import feedmysheep.feedmysheepapi.common.models.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
private final MemberRepository memberRepository;


  public void save(MemberDTO memberDto) {
    MemberEntity memberEntity


  }
}
