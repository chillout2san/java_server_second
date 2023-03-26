package infrastructure;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DatabaseSessionFactory {

  public static SqlSessionFactory get() throws DatabaseSessionException {
    var resource = "/mybatis-config.xml";
    try {
      var inputStream = DatabaseSessionFactory.class.getResourceAsStream(resource);
      var sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      return sqlSessionFactory;
    } catch (Exception e) {
      throw new DatabaseSessionException("Could create SqlSessionFactory:" + e.getMessage());
    }
  }
}

class DatabaseSessionException extends Exception {

  public DatabaseSessionException(String message) {
    super(message);
  }
}
