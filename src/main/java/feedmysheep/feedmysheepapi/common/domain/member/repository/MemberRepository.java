package feedmysheep.feedmysheepapi.common.domain.member.repository;

import feedmysheep.feedmysheepapi.common.models.MemberEntity;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

  @Query("SELECT m from MemberEntity m WHERE m.memberName = :memberName and m.memberEmail = :memberEmail")
  Optional<MemberEntity> findByMemberNameAndEmail(@Param("memberName") String memberName, @Param("memberEmail") String memberEmail);
};

//  @Query("SELECT u FROM UserEntity u WHERE u.name = :name and u.phone = :phone and u.is_valid= true ")
//  Optional<UserEntity> findUserByPhoneNumber(
//      @Param("name") String name,
//      @Param("phone") String phone);
