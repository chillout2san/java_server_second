package domain.todo;

import domain.InvalidDomainArgumentException;

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
   * @throws InvalidDomainArgumentException value が空文字の時
   */
  public static TodoId create(String value) throws InvalidDomainArgumentException {
    if (value == "") {
      throw new InvalidDomainArgumentException("valueは必須です");
    }
    return new TodoId(value);
  }
}
