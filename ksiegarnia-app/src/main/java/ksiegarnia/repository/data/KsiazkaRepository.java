package ksiegarnia.repository.data;

import ksiegarnia.model.Autor;
import ksiegarnia.model.Ksiazka;
import ksiegarnia.model.Ksiegarnia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KsiazkaRepository extends JpaRepository<Ksiazka,Integer> {

    List<Ksiazka> findAllByAutor(Autor autor);

    List<Ksiazka> findAllByKsiegarnieContaining(Ksiegarnia ksiegarnia);
}
