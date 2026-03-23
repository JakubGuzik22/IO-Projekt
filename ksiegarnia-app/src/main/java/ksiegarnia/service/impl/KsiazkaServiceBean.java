package ksiegarnia.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import ksiegarnia.model.Autor;
import ksiegarnia.model.Ksiazka;
import ksiegarnia.model.Ksiegarnia;
import ksiegarnia.repository.KsiegarniaDao;
import ksiegarnia.repository.AutorDao;
import ksiegarnia.repository.KsiazkaDao;
import ksiegarnia.service.KsiazkaService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class KsiazkaServiceBean implements KsiazkaService {

    private static final Logger log = Logger.getLogger(KsiazkaServiceBean.class.getName());

//    @Autowired
//    public void setAutorDao(AutorDao autorDao) {
//        this.autorDao = autorDao;
//    }

    private final AutorDao autorDao;

    private final KsiegarniaDao ksiegarniaDao;

    private final KsiazkaDao ksiazkaDao;

    private final PlatformTransactionManager transactionManager;

//    public KsiazkaServiceBean(AutorDao autorDao,
//                              KsiegarniaDao ksiegarniaDao,
//                              KsiazkaDao ksiazkaDao) {
//        log.info("creating ksiazka service bean");
//        this.autorDao = autorDao;
//        this.ksiegarniaDao = ksiegarniaDao;
//        this.ksiazkaDao = ksiazkaDao;
//    }

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

//    @Override
//    public Ksiazka dodajKsiazke(Ksiazka k) {
//        log.info("adding ksiegarnia " + k.getId());
//        //return ksiazkaDao.add(k);
//        TransactionStatus ts = transactionManager.getTransaction(new DefaultTransactionDefinition());
//        try {
//            k = ksiazkaDao.add(k);
//            if(k.getTytul().equals("Apocalypse Now")){
//                throw new RuntimeException("not yet!");
//            }
//            transactionManager.commit(ts);
//        }
//        catch (RuntimeException e) {
//            transactionManager.rollback(ts);
//            throw e;
//        }
//        return k;
//    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Ksiazka dodajKsiazke(Ksiazka k){
        log.info("dodajemy ksiazke " + k);
        k = ksiazkaDao.add(k);
        if(k.getTytul().equals("Apocalypse Now")){
            throw new RuntimeException("not yet!");
        }
        return k;
    }
}