package ksiegarnia.web.ui;

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
public class KsiegarniaController {
    private final KsiegarniaService ksiegarniaService;
    private final KsiazkaService ksiazkaService;

    @GetMapping("/ksiegarnie") //ksiegarnie?ksiazkaId=3
    String getKsiegarnie(Model model, @RequestParam(value = "ksiazkaId", required = false) Integer ksiazkaId){
        log.info("zaraz dostaniemy liste ksiegarni");
        if(ksiazkaId != null){
            Ksiazka ksiazka = ksiazkaService.getKsiazkaById(ksiazkaId);
            List<Ksiegarnia> ksiegarnie = ksiegarniaService.getKsiegarnieByKsiazka(ksiazka);
            model.addAttribute("ksiegarnie", ksiegarnie);
            model.addAttribute("title", "ksiegarnie zawierajace '"+ksiazka.getTytul()+"'");
        }
        else {
            List<Ksiegarnia> ksiegarnie = ksiegarniaService.getAllKsiegarnie();
            model.addAttribute("ksiegarnie", ksiegarnie);
            model.addAttribute("title", "Ksiegarnie");
        }

        return "ksiegarnieView";
    }
}
