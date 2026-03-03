package ksiegarnia.repository.mem;

import org.springframework.stereotype.Component;
import ksiegarnia.repository.AutorDao;
import ksiegarnia.model.Autor;

import java.util.List;

@Component
public class MemAutorDao implements AutorDao {
    @Override
    public List<Autor> findAll() {
        return SampleData.autorzy;
    }

    @Override
    public Autor findById(int id) {
        return SampleData.autorzy.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Autor add(Autor d) {
        int max = SampleData.autorzy.stream().max((d1, d2) -> d1.getId() - d2.getId()).get().getId();
        d.setId(++max);
        SampleData.autorzy.add(d);
        return d;
    }
}
