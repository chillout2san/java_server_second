package infrastructure;

import presentation.ErrorCode;

public class RepositoryException extends Exception {

  public final ErrorCode errorCode;

  public RepositoryException(String message, ErrorCode errorCode) {
    super(message);
    this.errorCode = errorCode;
  }
}
