package ksiegarnia.repository.data;

import ksiegarnia.model.Autor;
import ksiegarnia.repository.AutorDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Primary
public class DataAutorDao implements AutorDao {

    private final AutorRepository repository;

    @Override
    public List<Autor> findAll() {
        return repository.findAll();
    }

    @Override
    public Autor findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Autor add(Autor d) {
        return repository.save(d);
    }
}
