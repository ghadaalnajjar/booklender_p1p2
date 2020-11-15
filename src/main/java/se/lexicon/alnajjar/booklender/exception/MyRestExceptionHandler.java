package se.lexicon.alnajjar.booklender.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MyRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RecordNotFoundException.class})
    public ResponseEntity<APIError> handleRecordNotFoundException(RecordNotFoundException ex, WebRequest request) {
        APIError response = new APIError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return ResponseEntity.badRequest().body(response);
    }


    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<APIError> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        APIError response = new APIError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Argument Exception",
                ex.getMessage(),
                request.getDescription(false)
        );
        return ResponseEntity.badRequest().body(response);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<String> details = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }

        APIError response = new APIError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Validation Error",
                details.toString(),
                request.getDescription(false)
        );
        return ResponseEntity.badRequest().body(response);
    }

}
