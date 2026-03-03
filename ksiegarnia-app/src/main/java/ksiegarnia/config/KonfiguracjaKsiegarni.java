package ksiegarnia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KonfiguracjaKsiegarni {

    @Bean
    String foo() { return new String("ksiazka"); }
}
