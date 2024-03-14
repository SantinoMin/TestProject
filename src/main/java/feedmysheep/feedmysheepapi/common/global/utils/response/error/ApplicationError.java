package feedmysheep.feedmysheepapi.common.global.utils.response.error;

public class ApplicationError {

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  private String status;
  private String message;



  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
