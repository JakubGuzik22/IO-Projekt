package ksiegarnia.repository.mem;

import ksiegarnia.model.Autor;
import ksiegarnia.model.Ksiazka;
import ksiegarnia.model.Ksiegarnia;

import java.util.ArrayList;
import java.util.List;

class SampleData {
    static List<Ksiegarnia> ksiegarnie = new ArrayList<>();
    static List<Autor> autorzy = new ArrayList<>();
    static List<Ksiazka> ksiazki = new ArrayList<>();

    static {

        // Autorzy
        Autor tokarczuk = new Autor(1, "Olga", "Tokarczuk");
        Autor sapkowski = new Autor(2, "Andrzej", "Sapkowski");
        Autor lem = new Autor(3, "Stanisław", "Lem");
        Autor szymborska = new Autor(4, "Wisława", "Szymborska");

        // Książki
        Ksiazka bieguni = new Ksiazka(1, "Bieguni", tokarczuk, 4.8f);
        Ksiazka domdzienny = new Ksiazka(2, "Dom dzienny, dom nocny", tokarczuk, 4.5f);

        Ksiazka wiedzminki = new Ksiazka(3, "Saga o Wiedźminie", sapkowski, 4.9f);
        Ksiazka krewelfow = new Ksiazka(4, "Krew elfów", sapkowski, 4.6f);

        Ksiazka solaris = new Ksiazka(5, "Solaris", lem, 4.7f);
        Ksiazka cyberiada = new Ksiazka(6, "Cyberiada", lem, 4.4f);

        Ksiazka koniec = new Ksiazka(7, "Koniec i początek", szymborska, 4.9f);
        Ksiazka wiersze = new Ksiazka(8, "Wiersze wybrane", szymborska, 4.3f);

        // powiązania książka–autor
        bind(bieguni, tokarczuk);
        bind(domdzienny, tokarczuk);

        bind(wiedzminki, sapkowski);
        bind(krewelfow, sapkowski);

        bind(solaris, lem);
        bind(cyberiada, lem);

        bind(koniec, szymborska);
        bind(wiersze, szymborska);

        // Księgarnie
        Ksiegarnia merlin = new Ksiegarnia(1, "Merlin Books");
        Ksiegarnia empik = new Ksiegarnia(2, "Empik Kraków");
        Ksiegarnia matras = new Ksiegarnia(3, "Matras");
        Ksiegarnia bonito = new Ksiegarnia(4, "Bonito Online");

        // powiązania książka–księgarnia
        bind(merlin, bieguni);
        bind(merlin, wiedzminki);

        bind(empik, bieguni);
        bind(empik, domdzienny);
        bind(empik, krewelfow);

        bind(matras, solaris);
        bind(matras, cyberiada);
        bind(matras, wiedzminki);

        bind(bonito, koniec);
        bind(bonito, wiersze);
        bind(bonito, bieguni);

        // dodanie do list
        ksiazki.add(bieguni);
        ksiazki.add(domdzienny);
        ksiazki.add(wiedzminki);
        ksiazki.add(krewelfow);
        ksiazki.add(solaris);
        ksiazki.add(cyberiada);
        ksiazki.add(koniec);
        ksiazki.add(wiersze);

        autorzy.add(tokarczuk);
        autorzy.add(sapkowski);
        autorzy.add(lem);
        autorzy.add(szymborska);

        ksiegarnie.add(merlin);
        ksiegarnie.add(empik);
        ksiegarnie.add(matras);
        ksiegarnie.add(bonito);
    }

    // pomocnicze metody
    private static void bind(Ksiegarnia ksiegarnia, Ksiazka ksiazka) {
        ksiegarnia.addKsiazka(ksiazka);
        ksiazka.addKsiegarnia(ksiegarnia);
    }

    private static void bind(Ksiazka ksiazka, Autor autor) {
        autor.addKsiazka(ksiazka);
        ksiazka.setAutor(autor);
    }
}