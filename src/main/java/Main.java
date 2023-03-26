import infrastructure.DatabaseSessionFactory;
import presentation.Router;

public class Main {

  public static void main(String[] args) {

    try {
      var databaseSessionFactory = DatabaseSessionFactory.get();
      Router.execute();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
