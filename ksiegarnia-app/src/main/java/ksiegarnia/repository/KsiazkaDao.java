package ksiegarnia.repository;

import ksiegarnia.model.Autor;
import ksiegarnia.model.Ksiegarnia;
import ksiegarnia.model.Ksiazka;

import java.util.List;

public interface KsiazkaDao {

    List<Ksiazka> findAll();

    Ksiazka findById(int id);

    List<Ksiazka> findByAutor(Autor autor);

    List<Ksiazka> findByKsiegarnia(Ksiegarnia ksiegarnia);

    Ksiazka add(Ksiazka ksiazka);
}