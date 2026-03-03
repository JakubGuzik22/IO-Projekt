package ksiegarnia.repository.mem;

import org.springframework.stereotype.Component;
import ksiegarnia.model.Autor;
import ksiegarnia.model.Ksiegarnia;
import ksiegarnia.repository.KsiazkaDao;
import ksiegarnia.model.Ksiazka;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemKsiazkaDao implements KsiazkaDao {
    @Override
    public List<Ksiazka> findAll() {
        return SampleData.ksiazki;
    }

    @Override
    public Ksiazka findById(int id) {
        return SampleData.ksiazki.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Ksiazka> findByAutor(Autor d) {
       return SampleData.ksiazki.stream().filter(m -> m.getAutor() == d).collect(Collectors.toList());
    }

    @Override
    public List<Ksiazka> findByKsiegarnia(Ksiegarnia c) {
        return SampleData.ksiazki.stream().filter(m -> m.getKsiazki().contains(c)).collect(Collectors.toList());
    }

    @Override
    public Ksiazka add(Ksiazka m) {
        int max = SampleData.ksiazki.stream().max((m1, m2) -> m1.getId() - m2.getId()).get().getId();
        m.setId(++max);
        SampleData.ksiazki.add(m);
        return m;
    }
}
