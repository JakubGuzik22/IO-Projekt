package ksiegarnia.web.ui;

import ksiegarnia.model.Autor;
import ksiegarnia.model.Ksiazka;
import ksiegarnia.model.Ksiegarnia;
import ksiegarnia.service.KsiazkaService;
import ksiegarnia.service.KsiegarniaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class KsiazkaController {
    private final KsiegarniaService ksiegarniaService;
    private final KsiazkaService ksiazkaService;

    @GetMapping("/ksiazki") //ksiegarnie?ksiazkaId=3
    String getKsiazki(Model model,
                      @RequestParam(value = "ksiegarniaId", required = false) Integer ksiegarniaId,
                      @RequestParam(value = "autorId", required = false) Integer autorId){
        log.info("zaraz dostaniemy liste ksiegarni");
        if(ksiegarniaId != null){
            Ksiegarnia ksiegarnia = ksiegarniaService.getKsiegarniaById(ksiegarniaId);
            List<Ksiazka> ksiazki = ksiegarniaService.getKsiazkiByKsiegarnia(ksiegarnia);
            model.addAttribute("ksiazki", ksiazki);
            model.addAttribute("title", "znajduja sie w ksiegarniach '"+ksiegarnia.getNazwa()+"'");
        }
        else if(autorId != null){
            Autor autor = ksiazkaService.getAutorById(autorId);
            List<Ksiazka> ksiazki = ksiazkaService.getKsiazkiByAutor(autor);
            model.addAttribute("ksiazki", ksiazki);
            model.addAttribute("title", "ksiazki napisane przez '"+autor.getNazwisko()+"'");
        }
        else {
            List<Ksiazka> ksiazki = ksiazkaService.getAllKsiazki();
            model.addAttribute("ksiazki", ksiazki);
            model.addAttribute("title", "Ksiazki");
        }

        return "ksiazkiView";
    }
}
