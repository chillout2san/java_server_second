package infrastructure.todo;

import domain.todo.Todo;
import domain.todo.TodoRepository;
import infrastructure.RepositoryException;
import java.util.List;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TodoRepositoryImpl implements TodoRepository {

  private static Logger logger = LoggerFactory.getLogger(TodoRepository.class);

  private SqlSessionFactory databaseSessionFactory;

  public TodoRepositoryImpl(SqlSessionFactory databaseSessionFactory) {
    this.databaseSessionFactory = databaseSessionFactory;
  }

  /**
   * 全ての Todo を取得する
   *
   * @return 全ての Todo
   */
  public List<Todo> findAll() throws RepositoryException {
    try (var session = this.databaseSessionFactory.openSession()) {
      var mapper = session.getMapper(TodoRepository.class);
      return mapper.findAll();
    } catch (Exception e) {
      this.logger.error(e.getMessage());
      throw new RepositoryException(e.getMessage());
    }
  }
}
