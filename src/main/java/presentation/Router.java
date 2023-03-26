package presentation;

import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.server.Server;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import presentation.todo.TodoController;

public class Router {

  private static Logger logger = LoggerFactory.getLogger(Router.class);

  public static void execute(SqlSessionFactory sqlSessionFactory) {
    var serverBuilder = Server.builder();
    serverBuilder.http(8080);

    TodoController.execute(sqlSessionFactory, serverBuilder);

    var server = serverBuilder.build();
    var future = server.start();
    future.join();
    logger.info("router executed");
  }
}
