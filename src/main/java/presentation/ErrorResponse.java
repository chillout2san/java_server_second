package presentation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {

  @JsonProperty("result")
  private Value result;

  public ErrorResponse(ErrorCode errorCode) {
    this.result = new Value(errorCode);
  }

  class Value {

    @JsonProperty("error_code")
    private ErrorCode value;

    public Value(ErrorCode errorCode) {
      this.value = errorCode;
    }
  }
}
