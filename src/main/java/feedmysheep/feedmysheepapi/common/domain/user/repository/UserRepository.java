package feedmysheep.feedmysheepapi.common.domain.user.repository;

import feedmysheep.feedmysheepapi.common.domain.user.dto.UserResDto;
import feedmysheep.feedmysheepapi.common.models.UserEntity;
import java.util.Date;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  @Query("SELECT u FROM UserEntity u WHERE u.name =: name and u.birthday =: birthday and u.valid = true ")
  Optional<UserResDto.joinUser> findUserByUserInfo(
      @Param("name") String name, @Param("birthday") Date birthday);
};

