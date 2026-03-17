package ksiegarnia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ksiegarnia")
public class Ksiegarnia {

    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 2, max = 20)
    private String nazwa;

    @ManyToMany(mappedBy = "ksiegarnie")
    @JsonIgnore
    private List<Ksiazka> ksiazki = new ArrayList<>();

    public Ksiegarnia(Integer id, String name) {
        this.id = id;
        this.nazwa = name;
    }

    public Ksiegarnia() {
    }

    public Integer getId() {
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
