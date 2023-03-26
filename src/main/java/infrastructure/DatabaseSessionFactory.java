package infrastructure;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseSessionFactory {

  private static Logger logger = LoggerFactory.getLogger(DatabaseSessionFactory.class);

  public static SqlSessionFactory get() throws DatabaseSessionException {
    var resource = "/mybatis-config.xml";
    try {
      var inputStream = DatabaseSessionFactory.class.getResourceAsStream(resource);
      var sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      return sqlSessionFactory;
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new DatabaseSessionException("could create SqlSessionFactory:" + e.getMessage());
    }
  }
}

