package ksiegarnia.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Ksiazka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tytul;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
    private float ocena;

    @ManyToMany
    @JoinTable (name="ksiazka_ksiegarnia", joinColumns = @JoinColumn(name = "ksiazka_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ksiegarnia_id", referencedColumnName = "id"))
    private List<Ksiegarnia> ksiegarnie = new ArrayList<>();

    public Ksiazka(int id, String title, Autor autor, float rating) {
        this.id = id;
        this.tytul = title;
        this.autor = autor;
        this.ocena = rating;
    }

    public Ksiazka() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String title) {
        this.tytul = title;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public float getOcena() {
        return ocena;
    }

    public void setOcena(float rating) {
        this.ocena = rating;
    }

    public List<Ksiegarnia> getKsiazki() {
        return ksiegarnie;
    }

    public void setKsiazki(List<Ksiegarnia> ksiegarnie) {
        this.ksiegarnie = ksiegarnie;
    }

    public void addKisazka(Ksiegarnia c) {
        this.ksiegarnie.add(c);
    }


   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ksiazka movie = (Ksiazka) o;

        if (id != movie.id) return false;
        if (Float.compare(movie.rating, rating) != 0) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        return poster != null ? poster.equals(movie.poster) : movie.poster == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (poster != null ? poster.hashCode() : 0);
        result = 31 * result + (rating != +0.0f ? Float.floatToIntBits(rating) : 0);
        return result;
    }*/

    @Override
    public String toString() {
        return "Ksiazka{" +
                "title='" + tytul + '\'' +
                ", autor=" + autor +
                ", rating=" + ocena +
                '}';
    }

    public void addKsiegarnia(Ksiegarnia c) {
        this.ksiegarnie.add(c);
    }
}
