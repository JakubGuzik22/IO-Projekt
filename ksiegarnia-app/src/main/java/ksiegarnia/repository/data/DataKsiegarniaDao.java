package ksiegarnia.repository.data;

import ksiegarnia.model.Ksiazka;
import ksiegarnia.model.Ksiegarnia;
import ksiegarnia.repository.KsiegarniaDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class DataKsiegarniaDao implements KsiegarniaDao {

    private final KsiegarniaRepository repository;

    @Override
    public List<Ksiegarnia> findAll() {
        return repository.findAll();
    }

    @Override
    public Ksiegarnia findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Ksiegarnia> findByKsiazka(Ksiazka m) {
        return repository.findAllByKsiazka(m);
    }

    @Override
    public Ksiegarnia save(Ksiegarnia ksiegarnia) {
        return repository.save(ksiegarnia);
    }
}
