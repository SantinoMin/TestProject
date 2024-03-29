package feedmysheep.feedmysheepapi.common.domain.word.dto;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class WordResDto {

  private Long id;
  private String verse;
  private String word;

};