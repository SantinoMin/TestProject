package feedmysheep.feedmysheepapi.common.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AddressDTO {

  @NotBlank(message = "[Address] The city is required.")
  private String city;

  @NotBlank(message = "[Address] The street name is required.")
  private String street;

  // getters and setters
}