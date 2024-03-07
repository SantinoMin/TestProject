package feedmysheep.feedmysheepapi.common.domain.word.repository;

import feedmysheep.feedmysheepapi.common.models.WordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<WordEntity, Long> {

  @Query("SELECT w FROM WordEntity w WHERE w.word = :word")
  WordEntity signUpByScreenKey(@Param("word") String word);
};

