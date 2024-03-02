package domain.signUp.repository;

import models.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpRepository extends JpaRepository<MemberEntity, Long> {


  @Query("SELECT m FROM MemberEntity m WHERE m.screenKey = :screenKey and m.memberName =: memberName")
  MemberEntity signUpByScreenKey(@Param("screenKey") Long screenKey,
      @Param("memberName") String memberName);
};

