package ksiegarnia.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ksiegarnia.model.Ksiazka;
import ksiegarnia.model.Ksiegarnia;
import ksiegarnia.repository.KsiegarniaDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class JpaKsiegarniaDao implements KsiegarniaDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Ksiegarnia> findAll(){
        return entityManager.createQuery("select k from Ksiegarnia k").getResultList();
    }

    @Override
    public Ksiegarnia findById(int id) {
        return entityManager.find(Ksiegarnia.class, id);
    }

    @Override
    public List<Ksiegarnia> findByKsiazka(Ksiazka m) {
        return entityManager.createQuery("select k from Ksiegarnia k inner join k.ksiazki ksiazka where ksiazka=:ksiazka").setParameter("ksiazka", m).getResultList();
    }

    @Override
    public Ksiegarnia save(Ksiegarnia ksiegarnia) {
        entityManager.persist(ksiegarnia);
        return ksiegarnia;

    }

}
