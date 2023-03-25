package presentation;

import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.server.Server;

public class Router {

  public static void execute() {
    var serverBuilder = Server.builder();
    serverBuilder.http(8080);
    serverBuilder.service("/", (ctx, req) -> HttpResponse.of("Hello world"));

    var server = serverBuilder.build();
    var future = server.start();
    future.join();
    System.out.println("Router executed.");
  }
}
