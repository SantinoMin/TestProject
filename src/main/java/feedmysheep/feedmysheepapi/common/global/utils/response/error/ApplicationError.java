package feedmysheep.feedmysheepapi.common.global.utils.response.error;

import lombok.Getter;

@Getter
public class ApplicationError {

  public void setStatus(String status) {
    this.status = status;
  }

  private String status;
  private String message;


  public void setMessage(String message) {
    this.message = message;
  }
}
