package ksiegarnia.service;

import ksiegarnia.model.Ksiazka;
import ksiegarnia.model.Ksiegarnia;

import java.util.List;

public interface KsiegarniaService {

    Ksiegarnia getKsiegarniaById(int id);

    List<Ksiegarnia> getAllKsiegarnie();

    List<Ksiegarnia> getKsiegarnieByKsiazka(Ksiazka ksiazka);

    List<Ksiazka> getKsiazkiByKsiegarnia(Ksiegarnia ksiegarnia);

    Ksiegarnia dodajKsiegarnie(Ksiegarnia ksiegarnia);
}