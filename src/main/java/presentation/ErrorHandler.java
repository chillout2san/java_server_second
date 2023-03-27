package presentation;

import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.common.MediaType;
import domain.DomainException;
import infrastructure.RepositoryException;

public class ErrorHandler {

  public static HttpResponse execute(Exception e) {
    if (e instanceof DomainException) {
      return HttpResponse.of(HttpStatus.BAD_REQUEST);
    }

    if (e instanceof RepositoryException) {
      var errorResponse = new ErrorResponse(((RepositoryException) e).errorCode);
      var response = JsonMapper.execute(errorResponse);
      return HttpResponse.of(HttpStatus.INTERNAL_SERVER_ERROR, MediaType.JSON_UTF_8, response);
    }

    return HttpResponse.of(HttpStatus.INTERNAL_SERVER_ERROR);
  }
}