package ksiegarnia.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ksiegarnia.model.Autor;
import ksiegarnia.model.Ksiazka;
import ksiegarnia.model.Ksiegarnia;
import ksiegarnia.repository.KsiazkaDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class JpaKsiazkaDao implements KsiazkaDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Ksiazka> findAll() {
        return entityManager.createQuery("select m from Ksiazka m").getResultList();
    }

    @Override
    public Ksiazka findById(int id) {
        return entityManager.find(Ksiazka.class, id);
    }

    @Override
    public List<Ksiazka> findByAutor(Autor a) {
        return entityManager.createQuery("select m from Ksiazka m where m.autor=:autor").setParameter("autor", a).getResultList();
    }

    @Override
    public List<Ksiazka> findByKsiegarnia(Ksiegarnia k) {
        return entityManager.createQuery("select m from Ksiazka m inner join m.ksiegarnie ksiegarnia where ksiegarnia=:ksiegarnia").setParameter("ksiegarnia",k).getResultList();
    }

    @Override
    public Ksiazka add(Ksiazka m) {
        entityManager.persist(m);
        return m;
    }
}
