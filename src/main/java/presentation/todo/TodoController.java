package presentation.todo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.linecorp.armeria.common.HttpMethod;
import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.common.MediaType;
import com.linecorp.armeria.server.ServerBuilder;
import com.linecorp.armeria.server.annotation.ProducesJson;
import domain.todo.Todo;
import infrastructure.todo.TodoRepositoryImpl;
import java.util.List;
import org.apache.ibatis.session.SqlSessionFactory;
import presentation.NotFoundPresentationException;
import usecase.todo.GetUseCase;

public class TodoController {

  public static void execute(SqlSessionFactory sqlSessionFactory, ServerBuilder serverBuilder) {
    serverBuilder.service("/todo", ((ctx, req) -> {
      if (ctx.method() == HttpMethod.GET) {
        return TodoController.get(sqlSessionFactory);
      }
      throw new NotFoundPresentationException("method not found");
    }));
  }
  
  private static HttpResponse get(SqlSessionFactory sqlSessionFactory) {
    try {
      var todoRepository = new TodoRepositoryImpl(sqlSessionFactory);
      var getUseCase = new GetUseCase(todoRepository);
      var todos = getUseCase.execute();
      var response = new GetResponse(todos);
      var objectMapper = new ObjectMapper();
      var json = objectMapper.writeValueAsString(response);
      return HttpResponse.of(HttpStatus.OK, MediaType.JSON_UTF_8, json);
    } catch (Exception e) {
      return HttpResponse.of(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}

class GetResponse {

  @JsonProperty("result")
  private Todos result;

  public GetResponse(List<Todo> value) {
    var todos = new Todos(value);
    this.result = todos;
  }

  class Todos {

    @JsonProperty("todos")
    private List<Todo> value;

    private Todos(List<Todo> todos) {
      this.value = todos;
    }
  }
}
