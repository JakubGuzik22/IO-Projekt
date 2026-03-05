package ksiegarnia.model;

import java.util.ArrayList;
import java.util.List;

public class Autor {

    private int id;
    private String imie;
    private String nazwisko;
    private List<Ksiazka> ksiazki = new ArrayList<>();


    public Autor(int id, String firstName, String lastName) {
        this.id = id;
        this.imie = firstName;
        this.nazwisko = lastName;
    }

    public Autor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String firstName) {
        this.imie = firstName;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String lastName) {
        this.nazwisko = lastName;
    }

    public List<Ksiazka> getKsiazki() {
        return ksiazki;
    }

    public void setKsiazki(List<Ksiazka> ksiazki) {
        this.ksiazki = ksiazki;
    }

    public void addKsiazka(Ksiazka m) {
        this.ksiazki.add(m);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", firstName='" + imie + '\'' +
                ", lastName='" + nazwisko + '\'' +
                '}';
    }
}
