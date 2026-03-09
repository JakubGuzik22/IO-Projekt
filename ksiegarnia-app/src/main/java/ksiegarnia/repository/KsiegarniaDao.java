package ksiegarnia.repository;

import ksiegarnia.model.Ksiegarnia;
import ksiegarnia.model.Ksiazka;

import java.util.List;

public interface KsiegarniaDao {

    List<Ksiegarnia> findAll();

    Ksiegarnia findById(int id);

    List<Ksiegarnia> findByKsiazka(Ksiazka m);

    Ksiegarnia save(Ksiegarnia ksiegarnia);
}
