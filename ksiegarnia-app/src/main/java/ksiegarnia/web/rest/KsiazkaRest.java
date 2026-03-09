package ksiegarnia.web.rest;

import ksiegarnia.model.Ksiazka;
import ksiegarnia.model.Ksiegarnia;
import ksiegarnia.service.KsiazkaService;
import ksiegarnia.service.KsiegarniaService;
import ksiegarnia.web.rest.dto.KsiazkaDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class KsiazkaRest {
    private final KsiegarniaService ksiegarniaService;
    private final KsiazkaService ksiazkaService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    @GetMapping("ksiazki")
    List<Ksiazka> getKsiazki(){
        log.info("zaraz dostaniemy liste ksiazek");
        List<Ksiazka> ksiazki = ksiazkaService.getAllKsiazki();
        log.info("{} ksiazek znaleziono", ksiazki.size());
        return ksiazki;
    }

    @GetMapping("ksiazki/{id}")
    ResponseEntity<Ksiazka> getKsiazki(@PathVariable("id") int id){
        log.info("zaraz dostaniemy ksiazke", id);
        Ksiazka ksiazka = ksiazkaService.getKsiazkaById(id);
        log.info("{} ksiazke znaleziono: ", ksiazka);
        if (ksiazka != null) {
            return ResponseEntity.ok(ksiazka);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("ksiegarnie/{ksiegarniaId}/ksiazki")
    ResponseEntity<List<Ksiazka>> getKsiazkiByKsiegarnia(@PathVariable("ksiegarniaId") int ksiegarniaId){
        log.info("zaraz dostaniemy ksiazki z danych ksiegarni", ksiegarniaId);
        Ksiegarnia ksiegarnia = ksiegarniaService.getKsiegarniaById(ksiegarniaId);
        if(ksiegarnia == null){
            return ResponseEntity.notFound().build();
        }
        else{
            List<Ksiazka> ksiazki = ksiegarniaService.getKsiazkiByKsiegarnia(ksiegarnia);
            log.info("znaleziono {} ksiazek w ksiegarni {}", ksiazki.size(), ksiegarnia.getNazwa());
            return ResponseEntity.ok(ksiazki);
        }
    }

    @PostMapping("/ksiazki")
    ResponseEntity<?> addKsiazki(@RequestBody KsiazkaDTO ksiazkaDTO){
        log.info("zaraz dodamy nowa ksiazke {}", ksiazkaDTO);
        Ksiazka ksiazka = new Ksiazka();
        ksiazka.setTytul(ksiazkaDTO.getTytul());
        ksiazka.setOcena(ksiazkaDTO.getOcena());
        ksiazka.setAutor(ksiazkaService.getAutorById(ksiazkaDTO.getAutorId()));

        ksiazka = ksiazkaService.dodajKsiazke(ksiazka);
        log.info("dodano ksiazke: {}", ksiazka);
        return ResponseEntity.status(HttpStatus.CREATED).body(ksiazka);
        //return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequestUri().path("/"+ksiazka.getId()).build().toUri()).body(ksiazka);
    }
}
