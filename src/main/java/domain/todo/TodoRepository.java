package domain.todo;

import infrastructure.RepositoryException;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoRepository {

  /**
   * 全ての Todo を取得する
   *
   * @return 全ての Todo
   */
  List<Todo> findAll() throws RepositoryException;
}
