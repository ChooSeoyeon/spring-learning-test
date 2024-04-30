package cholog.exception;

import cholog.controller.MemberController;
import cholog.controller.ProductController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = {MemberController.class, ProductController.class})
public class GlobalExceptionHandler {
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<String> handlerIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>("IllegalArgumentException occurred", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<String> handlerNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>("NotFoundException occurred", HttpStatus.NOT_FOUND);
    }
}
