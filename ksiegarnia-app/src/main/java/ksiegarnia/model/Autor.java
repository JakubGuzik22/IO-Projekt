package ksiegarnia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    @OneToMany(mappedBy = "autor")
    @JsonIgnore
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

    @JsonIgnore
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
