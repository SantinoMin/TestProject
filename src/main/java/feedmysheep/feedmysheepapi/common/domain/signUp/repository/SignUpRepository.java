package feedmysheep.feedmysheepapi.common.domain.signUp.repository;

import feedmysheep.feedmysheepapi.common.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpRepository extends JpaRepository<UserEntity, Long> {


  @Query("SELECT m FROM UserEntity m WHERE m.screenKey = :screenKey and m.memberName =: memberName")
  UserEntity signUpByScreenKey(@Param("screenKey") Long screenKey,
      @Param("memberName") String memberName);
};

