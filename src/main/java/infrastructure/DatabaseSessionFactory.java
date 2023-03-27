package infrastructure;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import presentation.ErrorCode;

public class DatabaseSessionFactory {

  public static SqlSessionFactory get() throws RepositoryException {
    var resource = "/mybatis-config.xml";
    try {
      var inputStream = DatabaseSessionFactory.class.getResourceAsStream(resource);
      var sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      return sqlSessionFactory;
    } catch (Exception e) {
      throw new RepositoryException("could create SqlSessionFactory:" + e.getMessage(),
          ErrorCode.DATABASE_SESSION_FACTORY_ERROR);
    }
  }
}

