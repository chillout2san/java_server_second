package presentation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {

  @JsonProperty("error_code")
  public ErrorCode errorCode;

  public ErrorResponse(ErrorCode errorCode) {
    this.errorCode = errorCode;
  }
}
