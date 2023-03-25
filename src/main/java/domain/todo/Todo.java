package domain.todo;

import static domain.todo.Status.DONE;
import static domain.todo.Status.WORK_IN_PROGRESS;

import domain.InvalidDomainArgumentException;
import ulid4j.Ulid;

/**
 * Todo のドメインモデル
 */
public class Todo {

  public final TodoId id;
  private String name;
  private String content;
  private Status status;

  private Todo(TodoId id, String name, String content, Status status) {
    this.id = id;
    this.name = name;
    this.content = content;
    this.status = DONE;
  }

  /**
   * Todo を新規作成するメソッド
   *
   * @param name    Todo のタイトル
   * @param content Todo の中身
   * @return Todo
   * @throws InvalidDomainArgumentException
   */
  public static Todo create(String name, String content) throws InvalidDomainArgumentException {
    var id = TodoId.create(new Ulid().create());
    return new Todo(id, name, content, WORK_IN_PROGRESS);
  }

  /**
   * 既存の Todo を返却するメソッド
   *
   * @param id      Todo の id
   * @param name    Todo のタイトル
   * @param content Todo の中身
   * @param status  Todo の状態
   * @return Todo
   */
  public static Todo reconstruct(TodoId id, String name, String content, Status status) {
    return new Todo(id, name, content, status);
  }

  public String getName() {
    return this.name;
  }

  public String getContent() {
    return this.content;
  }
}
