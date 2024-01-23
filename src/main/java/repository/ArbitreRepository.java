package repository;

import entites.Arbitre;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ArbitreRepository {

    @PersistenceContext
    private EntityManager em;

    public Arbitre findById(Long id) {
        return em.find(Arbitre.class, id);
    }

    public List<Arbitre> findAll() {
        return em.createQuery("SELECT a FROM Arbitre a", Arbitre.class).getResultList();
    }

    public Arbitre save(Arbitre arbitre) {
        if (arbitre.getId() == null) {
            em.persist(arbitre);
            return arbitre;
        } else {
            return em.merge(arbitre);
        }
    }

    public void delete(Arbitre arbitre) {
        if (em.contains(arbitre)) {
            em.remove(arbitre);
        } else {
            em.remove(em.merge(arbitre));
        }
    }
    
    // Ajoutez ici d'autres méthodes personnalisées si nécessaire.
}
