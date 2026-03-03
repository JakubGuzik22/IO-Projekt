package ksiegarnia.web.rest;

import ksiegarnia.model.Ksiegarnia;
import ksiegarnia.service.KsiegarniaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class KsiegarniaRest {
    private final KsiegarniaService ksiegarniaService;

    @GetMapping("ksiegarnie")
    List<Ksiegarnia> getKsiegarnia() {
        log.info("zaraz dostaniemy liste ksiegarni: ");
        List<Ksiegarnia> ksiegarnie = ksiegarniaService.getAllKsiegarnie();
        log.info("{} ksiegarnie found", ksiegarnie.size());
        return ksiegarnie;
    }
}
