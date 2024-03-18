package feedmysheep.feedmysheepapi.common.domain.member.repository;

import feedmysheep.feedmysheepapi.common.models.MemberEntity;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

  @Query("SELECT m from MemberEntity m WHERE m.member_name = :member_name and m.member_email = :member_email")
  Optional<MemberEntity> findByMemberEmail(@Param("member_name") String member_name, @Param("member_email") String member_email);
}

//  @Query("SELECT u FROM UserEntity u WHERE u.name = :name and u.phone = :phone and u.is_valid= true ")
//  Optional<UserEntity> findUserByPhoneNumber(
//      @Param("name") String name,
//      @Param("phone") String phone);