package feedmysheep.feedmysheepapi.common.domain.user.repository;

import feedmysheep.feedmysheepapi.common.models.UserEntity;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//jpa를 사용하면, 아래 어노테이션은 작성 안해줘도 알아서 설정됨.
//@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  /**
   * 중복 회원 조회(E-mail)
   * */
  @Query("SELECT u FROM UserEntity u WHERE u.email = :email and u.is_valid = false")
  Optional<UserEntity> findUserByEmail(
      @Param("email") String email);

  /**
   * 중복 회원 조회(Phone)
   * */
  @Query("SELECT u FROM UserEntity u WHERE u.phone = :phone and u.is_valid = false")
  Optional<UserEntity> findUserByPhone(
      @Param("phone") String phone);

  /**
   *
   */
  @Query("SELECT u FROM UserEntity u WHERE u.phone = :phone and u.email = :email and u.is_valid = false")
  List<UserEntity> findDuplicateUserByPhoneAndEmail(
      @Param("phone") String phone, @Param("email")String email);




  //E-mail과 비밀번호로 일치하는 회원 찾기
  @Query("SELECT u FROM UserEntity u WHERE u.email = :email and u.password = :password and u.is_valid = false")
  Optional<UserEntity> findUserByEmailAndPassword(
      @Param("email") String email,
      @Param("password") String password);

  //일단 Optional없이.
  @Query("SELECT u FROM UserEntity u WHERE u.username = :username and u.is_valid = false")
  UserEntity findByUserName(
      @Param("username") String username);

  Boolean existsByUsername(String username);
};

