package feedmysheep.feedmysheepapi.common.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="word")
public class WordEntity {

  @Id
  @Column(nullable = false)
  private int id;

  @Column(nullable = false)
  private String words;

  @Column(nullable = false)
  private String verse;
}
