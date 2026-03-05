package ksiegarnia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Ksiegarnia {

    private int id;
    private String nazwa;

    @JsonIgnore
    private List<Ksiazka> ksiazki = new ArrayList<>();

    public Ksiegarnia(int id, String name) {
        this.id = id;
        this.nazwa = name;
    }

    public Ksiegarnia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String name) {
        this.nazwa = name;
    }

    public List<Ksiazka> getKsiazki() {
        return ksiazki;
    }

    public void setKsiazki(List<Ksiazka> ksiazki) {
        this.ksiazki = ksiazki;
    }

    public void addKsiazki(Ksiazka m) {
        this.ksiazki.add(m);
    }

    @Override
    public String toString() {
        return "Ksiegarnia{" +
                "name='" + nazwa + '\'' +
                '}';
    }

    public void addKsiazka(Ksiazka m) {
        this.ksiazki.add(m);
    }
}
