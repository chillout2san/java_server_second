package domain;

/**
 * ドメインモデルを作成する引数が invalid の時の例外
 */
public class InvalidDomainArgumentException extends Exception {

  public InvalidDomainArgumentException(String message) {
    super(message);
  }
}
