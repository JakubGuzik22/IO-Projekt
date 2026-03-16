package ksiegarnia.web.rest;

import ksiegarnia.service.KsiegarniaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice(basePackages = "ksiegarnia.web.rest")
@RequiredArgsConstructor
@Slf4j
public class KsiegarniaAdvice {
    private final KsiegarniaValidator validator;
    private final KsiazkaValidator validator2;


    @InitBinder("ksiegarnia")
    void initBinderForKsiegarnia(WebDataBinder binder) {
        binder.addValidators(validator);
    }

    @InitBinder("ksiazkaDTO")
    void initBinderForKsiazka(WebDataBinder binder) {
        binder.addValidators(validator2);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("illegal argument provided", e);
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(e.getMessage());
    }
}
