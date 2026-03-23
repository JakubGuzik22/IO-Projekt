package ksiegarnia.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import ksiegarnia.model.Ksiazka;
import ksiegarnia.model.Ksiegarnia;
import ksiegarnia.repository.KsiegarniaDao;
import ksiegarnia.repository.KsiazkaDao;
import ksiegarnia.service.KsiegarniaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
@Scope("prototype")
public class KsiegarniaServiceBean implements KsiegarniaService {

    private static final Logger log = Logger.getLogger(KsiegarniaService.class.getName());

    private KsiegarniaDao ksiegarniaDao;

    private KsiazkaDao ksiazkaDao;

    public KsiegarniaServiceBean(KsiegarniaDao ksiegarniaDao, KsiazkaDao ksiazkaDao) {
        log.info("creating ksiegarnia service bean");
        this.ksiegarniaDao = ksiegarniaDao;
        this.ksiazkaDao = ksiazkaDao;
    }

    @Override
    public Ksiegarnia getKsiegarniaById(int id) {
        log.info("searching ksiegarnia by id " + id);
        return ksiegarniaDao.findById(id);
    }

    @Override
    public List<Ksiazka> getKsiazkiByKsiegarnia(Ksiegarnia k) {
        log.info("searching ksiazki in ksiegarnia " + k.getId());
        return ksiazkaDao.findByKsiegarnia(k);
    }

    @Override
    public List<Ksiegarnia> getAllKsiegarnie() {
        log.info("searching all ksiegarnie");
        return ksiegarniaDao.findAll();
    }
    @Override
    public List<Ksiegarnia> getKsiegarnieByKsiazka(Ksiazka ksiazka) {
        log.info("searching ksiegarnie by ksiazka " + ksiazka.getId());
        return ksiegarniaDao.findByKsiazka(ksiazka);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public Ksiegarnia dodajKsiegarnie(Ksiegarnia k) {
        log.info("adding ksiegarnia " + k.getId());
        return ksiegarniaDao.save(k);
    }

}