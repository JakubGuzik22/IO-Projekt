package ksiegarnia.web.rest;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ksiegarnia.model.Ksiegarnia;
import ksiegarnia.service.KsiegarniaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KsiegarniaValidator implements Validator {

    private final KsiegarniaService ksiegarniaService;

    @Override
    public boolean supports(Class<?> clazz){return clazz.isAssignableFrom(Ksiegarnia.class);}

    @Override
    public void validate(Object target, Errors errors){
        Ksiegarnia validatedKsiegarnia = (Ksiegarnia) target;

        boolean duplicated = ksiegarniaService.getAllKsiegarnie().stream()
                .anyMatch(ksiegarnia ->ksiegarnia.getNazwa().equalsIgnoreCase(validatedKsiegarnia.getNazwa()));

        if(duplicated){
            errors.rejectValue("nazwa", "ksiegarnia.nazwa.duplicated");
        }
    }
}
