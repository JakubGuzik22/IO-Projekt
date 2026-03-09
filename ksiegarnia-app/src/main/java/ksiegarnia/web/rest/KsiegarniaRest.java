package ksiegarnia.web.rest;

import jakarta.servlet.http.HttpServletRequest;
import ksiegarnia.model.Ksiazka;
import ksiegarnia.model.Ksiegarnia;
import ksiegarnia.service.KsiazkaService;
import ksiegarnia.service.KsiegarniaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class KsiegarniaRest {
    private final KsiegarniaService ksiegarniaService;
    private final KsiazkaService ksiazkaService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
    private final KsiegarniaValidator validator;

    @InitBinder
    void initBinder(WebDataBinder binder) {binder.setValidator(validator);}

    @GetMapping("ksiegarnie")
    List<Ksiegarnia> getKsiegarnia(
            @RequestParam(value = "phrase", required = false) String phrase,
            @RequestHeader(value = "custom-header", required = false) String customHeader,
            @CookieValue(value = "some-cookie", required = false) String someCookie
            )
    {
        log.info("zaraz dostaniemy liste ksiegarni: ");
        log.info("parametr phrase: {}", phrase);
        log.info("specjalny naglowek: {}", customHeader);
        log.info("jakies cookie: {}", someCookie);
        List<Ksiegarnia> ksiegarnie = ksiegarniaService.getAllKsiegarnie();
        log.info("{} ksiegarnie found", ksiegarnie.size());
        return ksiegarnie;
    }

    @GetMapping("ksiegarnie/{id}")
    ResponseEntity<Ksiegarnia> getKsiegarnie(@PathVariable("id") int id) {
        log.info("szukamy ksiegarni o podanym id: ", id);
        Ksiegarnia ksiegarnia = ksiegarniaService.getKsiegarniaById(id);
        log.info("{} ksiegarnie found", ksiegarnia);
        if (ksiegarnia != null) {
            return ResponseEntity.status(200).body(ksiegarnia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/ksiazki/{ksiazkaId}/ksiegarnie")
    public ResponseEntity<List<Ksiegarnia>> getKsiegarnieByKsiazka(@PathVariable("ksiazkaId") int ksiazkaId) {
        log.info("zaraz dostaniemy ksiegarnie majace ksiazke o ID: {}", ksiazkaId);
        Ksiazka ksiazka = ksiazkaService.getKsiazkaById(ksiazkaId);

        if (ksiazka == null) {
            return ResponseEntity.notFound().build();
        } else {
            List<Ksiegarnia> ksiegarnie = ksiegarniaService.getKsiegarnieByKsiazka(ksiazka);
            log.info("Znaleziono {} ksiegarni z ksiazka: {}", ksiegarnie.size(), ksiazka.getTytul());
            return ResponseEntity.ok(ksiegarnie);
        }
    }

    @PostMapping("/ksiegarnie")
       ResponseEntity<?> dodajKsiegarnie(@Validated @RequestBody Ksiegarnia ksiegarnia, Errors errors, HttpServletRequest request) {
          log.info("teraz dodamy nowa ksiegarnie", ksiegarnia);

          if(errors.hasErrors()){
            Locale locale = localeResolver.resolveLocale(request);
                    //new Locale("pl","PL");
            String errorMessage = errors.getAllErrors().stream()
                    .map(oe->messageSource.getMessage(oe.getCode(), new Object[0], locale))
                    //.map(oe->oe.toString())
                    //.map(oe -> messageSource.getMessage(oe, locale))
                    .reduce("errors \n", (accu, oe) -> accu+oe+"\n");
            return ResponseEntity.badRequest().body(errorMessage);
          }
       ksiegarnia = ksiegarniaService.dodajKsiegarnie(ksiegarnia);
       log.info("dodano nowa ksiegarnie", ksiegarnia);
       return ResponseEntity.status(HttpStatus.CREATED).body(ksiegarnia);
    }
}
