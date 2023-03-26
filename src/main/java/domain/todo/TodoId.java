package domain.todo;

import domain.InvalidDomainArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Todo の id
 */
public class TodoId {

  private static final Logger logger = LoggerFactory.getLogger(TodoId.class);

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
      logger.error("value is required.");
      throw new InvalidDomainArgumentException("value is required.");
    }
    return new TodoId(value);
  }
}
