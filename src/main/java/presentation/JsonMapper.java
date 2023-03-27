package presentation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapper {

  public static String execute(Object object) throws JsonMapperExecutionException {
    try {
      var objectMapper = new ObjectMapper();
      var json = objectMapper.writeValueAsString(object);
      return json;
    } catch (Exception e) {
      throw new JsonMapperExecutionException(e.getMessage());
    }
  }
}

class JsonMapperExecutionException extends RuntimeException {

  public JsonMapperExecutionException(String message) {
    super(message);
  }
}