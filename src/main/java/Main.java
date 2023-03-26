import infrastructure.DatabaseSessionFactory;
import infrastructure.todo.TodoRepositoryImpl;
import presentation.Router;

public class Main {

  public static void main(String[] args) {

    try {
      var databaseSessionFactory = DatabaseSessionFactory.get();
      Router.execute(databaseSessionFactory);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
