package ksiegarnia.repository.data;

import ksiegarnia.model.Ksiazka;
import ksiegarnia.model.Ksiegarnia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KsiegarniaRepository extends JpaRepository<Ksiegarnia, Integer> {

    List<Ksiegarnia> findAllByNazwaContaining(String nazwa);

    @Query("select k from Ksiegarnia k inner join k.ksiazki ksiazka where ksiazka=:ksiazka")
    List<Ksiegarnia> findAllByKsiazka(@Param("ksiazka") Ksiazka ksiazka);
}
