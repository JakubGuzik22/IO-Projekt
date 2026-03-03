package ksiegarnia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ksiegarnia.model.Autor;
import ksiegarnia.model.Ksiazka;
import ksiegarnia.model.Ksiegarnia;
import ksiegarnia.repository.KsiegarniaDao;
import ksiegarnia.repository.AutorDao;
import ksiegarnia.repository.KsiazkaDao;
import ksiegarnia.service.KsiazkaService;

import java.util.List;
import java.util.logging.Logger;

@Component
public class KsiazkaServiceBean implements KsiazkaService {

    private static final Logger log = Logger.getLogger(KsiazkaServiceBean.class.getName());

    @Autowired
    public void setAutorDao(AutorDao autorDao) {
        this.autorDao = autorDao;
    }

    private AutorDao autorDao;

    private KsiegarniaDao ksiegarniaDao;

    private KsiazkaDao ksiazkaDao;

    public KsiazkaServiceBean(AutorDao autorDao,
                              KsiegarniaDao ksiegarniaDao,
                              KsiazkaDao ksiazkaDao) {
        log.info("creating ksiazka service bean");
        this.autorDao = autorDao;
        this.ksiegarniaDao = ksiegarniaDao;
        this.ksiazkaDao = ksiazkaDao;
    }

    @Override
    public List<Ksiazka> getAllKsiazki() {
        log.info("searching all ksiazki");
        return ksiazkaDao.findAll();
    }

    @Override
    public List<Ksiazka> getKsiazkiByAutor(Autor autor) {
        log.info("searching ksiazki by autor " + autor.getId());
        return ksiazkaDao.findByAutor(autor);
    }

    @Override
    public List<Ksiazka> getKsiazkiByKsiegarnia(Ksiegarnia ksiegarnia) {
        log.info("searching ksiazki in ksiegarnia " + ksiegarnia.getId());
        return ksiazkaDao.findByKsiegarnia(ksiegarnia);
    }

    @Override
    public Ksiazka getKsiazkaById(int id) {
        log.info("searching ksiazka by id " + id);
        return ksiazkaDao.findById(id);
    }

    @Override
    public List<Autor> getAllAutorzy() {
        log.info("searching all autorzy");
        return autorDao.findAll();
    }

    @Override
    public Autor getAutorById(int id) {
        log.info("searching autor by id " + id);
        return autorDao.findById(id);
    }
}