package team.trillion.yamuzip.common.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import team.trillion.yamuzip.common.exception.OrderFailedException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(OrderFailedException.class)
    public ResponseEntity<Object> errorAsync() {
        System.out.println("errorAsync");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ExceptionHandler(RuntimeException.class)
    public String errorView(Exception e, Model model) {
        System.out.println("errorView");
        model.addAttribute("errorMessage", e.getMessage());
        return "common/error";
    }
}
