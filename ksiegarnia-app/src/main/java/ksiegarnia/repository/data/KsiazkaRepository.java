package ksiegarnia.repository.data;

import ksiegarnia.model.Ksiazka;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KsiazkaRepository extends JpaRepository<Ksiazka,Integer> {
}
