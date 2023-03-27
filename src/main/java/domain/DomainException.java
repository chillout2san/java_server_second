package domain;

import presentation.ErrorCode;

/**
 * ドメインモデルを作成する引数が invalid の時の例外
 */
public class DomainException extends Exception {

  public final ErrorCode errorCode;

  public DomainException(String message, ErrorCode errorCode) {
    super(message);
    this.errorCode = errorCode;
  }
}
