package domain.todo;

import domain.DomainException;
import presentation.ErrorCode;

/**
 * Todo の id
 */
public class TodoId {

  public final String value;

  private TodoId(String value) {
    this.value = value;
  }

  /**
   * TodoId を作成して返却する
   *
   * @param value id の値
   * @return TodoId
   * @throws DomainException value が空文字の時
   */
  public static TodoId create(String value) throws DomainException {
    if (value == "") {
      throw new DomainException("value is required.",
          ErrorCode.DOMAIN_MODEL_ARGUMENT_REQUIRED_ERROR);
    }
    return new TodoId(value);
  }
}
