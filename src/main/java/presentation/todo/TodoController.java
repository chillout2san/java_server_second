package presentation.todo;

import com.linecorp.armeria.common.HttpMethod;
import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.common.MediaType;
import com.linecorp.armeria.server.ServerBuilder;
import com.linecorp.armeria.server.annotation.ProducesJson;
import infrastructure.todo.TodoRepositoryImpl;
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

  @ProducesJson
  private static HttpResponse get(SqlSessionFactory sqlSessionFactory) {
    try {
      var todoRepository = new TodoRepositoryImpl(sqlSessionFactory);
      var getUseCase = new GetUseCase(todoRepository);
      var todos = getUseCase.execute();
      return HttpResponse.of(HttpStatus.OK, MediaType.JSON_UTF_8, "{\"result\": {\"todos\":%v}",
          todos);
    } catch (Exception e) {
      return HttpResponse.of(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
