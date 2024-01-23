package repository;

import entites.Rencontre;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RencontreRepository {

    @PersistenceContext
    private EntityManager em;

    public Rencontre findById(Long id) {
        return em.find(Rencontre.class, id);
    }

    public List<Rencontre> findAll() {
        return em.createQuery("SELECT r FROM Rencontre r", Rencontre.class).getResultList();
    }

    public Rencontre save(Rencontre rencontre) {
        if (rencontre.getId() == null) {
            em.persist(rencontre);
            return rencontre;
        } else {
            return em.merge(rencontre);
        }
    }

    public void delete(Rencontre rencontre) {
        if (em.contains(rencontre)) {
            em.remove(rencontre);
        } else {
            em.remove(em.merge(rencontre));
        }
    }
    
    // Ajoutez ici d'autres méthodes personnalisées si nécessaire.
}
