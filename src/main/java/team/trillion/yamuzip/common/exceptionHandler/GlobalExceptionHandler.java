package team.trillion.yamuzip.common.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import team.trillion.yamuzip.common.exception.OrderFailedException;
import team.trillion.yamuzip.common.exception.ReadAccessDeniedException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(OrderFailedException.class)
    public ResponseEntity<Object> errorAsync() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ExceptionHandler(RuntimeException.class)
    public String errorView(Exception e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "common/error";
    }

    @ExceptionHandler(ReadAccessDeniedException.class)
    public String messageAlert(Exception e, RedirectAttributes rttr) {
        rttr.addFlashAttribute("message", e.getMessage());
        return "redirect:/cs";
    }
}
