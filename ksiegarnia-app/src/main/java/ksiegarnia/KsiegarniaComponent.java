package ksiegarnia;

import jakarta.annotation.PostConstruct;
import ksiegarnia.model.Ksiegarnia;
import ksiegarnia.service.KsiegarniaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class KsiegarniaComponent implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {

    private final KsiegarniaService ksiegarniaService;

    public KsiegarniaComponent(KsiegarniaService ksiegarniaService){ this.ksiegarniaService = ksiegarniaService;}

//    @PostConstruct
//    void init(){
//        List<Ksiegarnia> ksiegarnie = ksiegarniaService.getAllKsiegarnie();
//        System.out.println(ksiegarnie.size() + " ksiegarnie znalezione:");
//        ksiegarnie.forEach(System.out::println);
//    }

    @PostConstruct
    public void init(){ log.info("in post construct");}

    @Override
    public void run(String... args) throws Exception {
        log.info("program arguments: {}", Arrays.toString(args));
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("on context refreshed");
        List<Ksiegarnia> ksiegarnie = ksiegarniaService.getAllKsiegarnie();
        log.info("{} ksiegarnie found", ksiegarnie.size());
        ksiegarnie.forEach(ksiegarnia -> log.info("{}", ksiegarnia));
    }

    @EventListener
    public void eventListener(ContextRefreshedEvent event) {
        log.info("on context refreshed (from annotated method");
    }
}
