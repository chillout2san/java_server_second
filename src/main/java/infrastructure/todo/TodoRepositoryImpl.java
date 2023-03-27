package infrastructure.todo;

import domain.todo.Todo;
import domain.todo.TodoRepository;
import infrastructure.RepositoryException;
import java.util.List;
import org.apache.ibatis.datasource.DataSourceException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import presentation.ErrorCode;

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
    var session = this.databaseSessionFactory.openSession();
    try {
      session.getConnection().setAutoCommit(false);
      var mapper = session.getMapper(TodoRepository.class);
      var todos = mapper.findAll();
      session.commit();
      return todos;
    } catch (Exception e) {
      session.rollback();
      throw new RepositoryException(e.getMessage(), ErrorCode.UNKNOWN);
    } finally {
      session.close();
    }
  }
}
