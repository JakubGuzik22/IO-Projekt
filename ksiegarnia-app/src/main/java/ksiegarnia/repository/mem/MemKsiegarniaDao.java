package ksiegarnia.repository.mem;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ksiegarnia.model.Ksiazka;
import ksiegarnia.model.Ksiegarnia;
import ksiegarnia.repository.KsiegarniaDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("KsiegarniaDao")
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

    @Override
    public Ksiegarnia save(Ksiegarnia ksiegarnia) {
        int maxId = SampleData.ksiegarnie.stream()
                .sorted((c1,c2)->c2.getId()-c1.getId())
                .findFirst()
                .map(c->c.getId())
                .orElse(0);
        ksiegarnia.setId(maxId+1);
        SampleData.ksiegarnie.add(ksiegarnia);
        return ksiegarnia;
    }
}
