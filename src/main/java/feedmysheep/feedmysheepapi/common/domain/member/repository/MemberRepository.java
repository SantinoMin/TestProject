package feedmysheep.feedmysheepapi.common.domain.member.repository;

import feedmysheep.feedmysheepapi.common.models.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

}
