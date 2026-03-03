package ksiegarnia.repository.mem;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ksiegarnia.model.Ksiazka;
import ksiegarnia.model.Ksiegarnia;
import ksiegarnia.repository.KsiegarniaDao;

import java.util.List;
import java.util.stream.Collectors;

@Component("KsiegarniaDao")
@Primary
public class MemKsiegarniaDao implements KsiegarniaDao {

    @Override
    public List<Ksiegarnia> findAll() {
        return SampleData.ksiegarnie;
    }

    @Override
    public Ksiegarnia findById(int id) {
        return SampleData.ksiegarnie.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Ksiegarnia> findByKsiazka(Ksiazka m) {
        return SampleData.ksiegarnie.stream().filter(c -> c.getKsiazki().contains(m)).collect(Collectors.toList());
    }
}
