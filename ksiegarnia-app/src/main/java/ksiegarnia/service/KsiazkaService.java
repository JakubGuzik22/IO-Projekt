package ksiegarnia.service;

import ksiegarnia.model.Autor;
import ksiegarnia.model.Ksiazka;
import ksiegarnia.model.Ksiegarnia;

import java.util.List;

public interface KsiazkaService {

    List<Ksiazka> getAllKsiazki();

    List<Ksiazka> getKsiazkiByAutor(Autor autor);

    List<Ksiazka> getKsiazkiByKsiegarnia(Ksiegarnia ksiegarnia);

    Ksiazka getKsiazkaById(int id);

    List<Autor> getAllAutorzy();

    Autor getAutorById(int id);
}