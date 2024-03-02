package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="word")
public class WordEntity {

  @Id
  @Column(nullable = false)
  private String id;

  @Column(nullable = false)
  private String word;
}
