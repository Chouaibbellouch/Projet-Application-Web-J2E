package repository;

import entites.But;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ButRepository {

    @PersistenceContext
    private EntityManager em;

    public But findById(Long id) {
        return em.find(But.class, id);
    }

    public List<But> findAll() {
        return em.createQuery("SELECT b FROM But b", But.class).getResultList();
    }

    public But save(But but) {
        if (but.getId() == null) {
            em.persist(but);
            return but;
        } else {
            return em.merge(but);
        }
    }

    public void delete(But but) {
        if (em.contains(but)) {
            em.remove(but);
        } else {
            em.remove(em.merge(but));
        }
    }
    
    // Ajoutez ici d'autres méthodes personnalisées si nécessaire.
}