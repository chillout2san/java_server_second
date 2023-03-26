package presentation.todo;

import com.linecorp.armeria.common.HttpMethod;
import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.server.ServerBuilder;
import presentation.NotFoundPresentationException;

public class TodoController {

  public static void execute(ServerBuilder serverBuilder) {
    serverBuilder.service("/todo", ((ctx, req) -> {
      if (ctx.method() == HttpMethod.GET) {
        return TodoController.get();
      }
      throw new NotFoundPresentationException("存在しないメソッドです");
    }));
  }

  private static HttpResponse get() {
    return HttpResponse.of("hello world");
  }
}
