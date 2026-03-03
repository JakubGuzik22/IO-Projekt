package ksiegarnia.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ksiegarnia.model.Ksiegarnia;

import java.util.List;

public class KsiazkaServiceMain {

    public static void main(String[] args) {
        System.out.println("Znajdzmy ksiegarnie!");

        ApplicationContext context = new AnnotationConfigApplicationContext("ksiegarnia");
        KsiegarniaService service = context.getBean(KsiegarniaService.class);
        KsiegarniaService service2 = context.getBean(KsiegarniaService.class);

        List<Ksiegarnia> ksiegarnie = service.getAllKsiegarnie();
        System.out.println(ksiegarnie.size() + " ksiegarnie znalezione:");
        ksiegarnie.forEach(System.out::println);

        String foo = context.getBean(String.class);
        System.out.println("Zawartość foo: "+ foo);
    }
}
