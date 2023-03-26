package usecase.todo;

import domain.todo.Todo;
import domain.todo.TodoRepository;
import infrastructure.RepositoryException;
import java.util.List;

public class GetUseCase {

  private TodoRepository todoRepository;

  public GetUseCase(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public List<Todo> execute() throws RepositoryException {
    var todos = this.todoRepository.findAll();
    return todos;
  }
}
