package ksiegarnia.repository;

import ksiegarnia.model.Autor;

import java.util.List;

public interface AutorDao {

    List<Autor> findAll();

    Autor findById(int id);

    Autor add(Autor d);


}
