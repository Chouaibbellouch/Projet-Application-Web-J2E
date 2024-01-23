package repository;

import entites.Penalite;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PenaliteRepository {

    @PersistenceContext
    private EntityManager em;

    public Penalite findById(Long id) {
        return em.find(Penalite.class, id);
    }

    public List<Penalite> findAll() {
        return em.createQuery("SELECT p FROM Penalite p", Penalite.class).getResultList();
    }

    public Penalite save(Penalite penalite) {
        if (penalite.getId() == null) {
            em.persist(penalite);
            return penalite;
        } else {
            return em.merge(penalite);
        }
    }

    public void delete(Penalite penalite) {
        if (em.contains(penalite)) {
            em.remove(penalite);
        } else {
            em.remove(em.merge(penalite));
        }
    }
    
    // Ajoutez ici d'autres méthodes personnalisées si nécessaire.
}
