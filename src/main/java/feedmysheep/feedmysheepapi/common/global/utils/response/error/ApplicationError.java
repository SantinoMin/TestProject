package feedmysheep.feedmysheepapi.common.global.utils.response.error;

import lombok.Getter;

@Getter
public class ApplicationError {

  private String status;
  private String message;

  public void setStatus(String status) {
    this.status = status;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
