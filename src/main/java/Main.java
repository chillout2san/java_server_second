import infrastructure.DatabaseSessionFactory;
import infrastructure.todo.TodoRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import presentation.Router;

public class Main {

  public static void main(String[] args) {
    Logger logger = LoggerFactory.getLogger(Main.class);

    try {
      var databaseSessionFactory = DatabaseSessionFactory.get();
      Router.execute(databaseSessionFactory);
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
  }
}
