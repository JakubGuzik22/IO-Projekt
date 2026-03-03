package ksiegarnia.repository.dummy;

import org.springframework.stereotype.Component;
import ksiegarnia.model.Ksiazka;
import ksiegarnia.model.Ksiegarnia;
import ksiegarnia.repository.KsiegarniaDao;

import java.util.List;

@Component
public class DummyKsiegarniaDao implements KsiegarniaDao {

    @Override
    public List<Ksiegarnia> findAll() {
        return List.of();
    }

    @Override
    public Ksiegarnia findById(int id) {
        return null;
    }

    @Override
    public List<Ksiegarnia> findByKsiazka(Ksiazka m) {
        return List.of();
    }
}
