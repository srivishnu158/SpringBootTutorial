package error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(DeptNotFoundException.class)
	public ResponseEntity<ErrorMessage> DeptNotFoundException(DeptNotFoundException exc,WebRequest request) {
		ErrorMessage msg = new ErrorMessage(HttpStatus.NOT_FOUND,exc.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
	}
}
