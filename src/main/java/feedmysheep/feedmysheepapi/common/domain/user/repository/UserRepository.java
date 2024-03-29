package feedmysheep.feedmysheepapi.common.domain.user.repository;

import feedmysheep.feedmysheepapi.common.models.UserEntity;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//jpa를 사용하면, 아래 어노테이션은 작성 안해줘도 알아서 설정됨.
//@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  //중복 회원 찾기
  @Query("SELECT u FROM UserEntity u WHERE u.email = :email and u.phone = :phone and u.is_valid = false")
  Optional<UserEntity> findUserByEmailAndPhone(
      @Param("email") String email,
      @Param("phone") String phone);

  //E-mail과 비밀번호로 일치하는 회원 찾기
  @Query("SELECT u FROM UserEntity u WHERE u.email = :email and u.password = :password and u.is_valid = false")
  Optional<UserEntity> findUserByEmailAndPassword(
      @Param("email") String email,
      @Param("password") String password);
};

