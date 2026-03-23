package ksiegarnia.repository.data;

import ksiegarnia.model.Autor;
import ksiegarnia.model.Ksiazka;
import ksiegarnia.model.Ksiegarnia;
import ksiegarnia.repository.KsiazkaDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Primary
public class DataKsiazkaDao implements KsiazkaDao {

    private final KsiazkaRepository repository;

    @Override
    public List<Ksiazka> findAll() {
        return repository.findAll();
    }

    @Override
    public Ksiazka findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Ksiazka> findByAutor(Autor autor) {
        return repository.findAllByAutor(autor);
    }

    @Override
    public List<Ksiazka> findByKsiegarnia(Ksiegarnia ksiegarnia) {
        return repository.findAllByKsiegarnieContaining(ksiegarnia);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public Ksiazka add(Ksiazka ksiazka) {
        return repository.save(ksiazka);
    }
}
