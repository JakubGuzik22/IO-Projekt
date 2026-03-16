package ksiegarnia.web.rest;

import ksiegarnia.model.Autor;
import ksiegarnia.model.Ksiazka;
import ksiegarnia.service.KsiazkaService;
import ksiegarnia.web.rest.dto.KsiazkaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class KsiazkaValidator implements Validator {

    private final KsiazkaService ksiazkaService;

    @Override
    public boolean supports(Class<?> clazz){ return clazz.isAssignableFrom(KsiazkaDTO.class); }

    @Override
    public void validate(Object target, Errors errors){
        KsiazkaDTO ksiazka = (KsiazkaDTO)target;
        Autor autor = ksiazkaService.getAutorById(ksiazka.getAutorId());
        if(autor==null){
            errors.rejectValue("AutorId", "ksiazka.autor.missing");
        }
    }
}
