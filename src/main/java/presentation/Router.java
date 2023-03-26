package presentation;

import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.server.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Router {

  private static Logger logger = LoggerFactory.getLogger(Router.class);

  public static void execute() {
    var serverBuilder = Server.builder();
    serverBuilder.http(8080);
    serverBuilder.service("/", (ctx, req) -> HttpResponse.of("Hello world"));

    var server = serverBuilder.build();
    var future = server.start();
    future.join();
    logger.info("Router executed");
  }
}
