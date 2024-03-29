package feedmysheep.feedmysheepapi.common.domain.word.dto;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class WordReqDto {

  private Long id;
  private String word;

};