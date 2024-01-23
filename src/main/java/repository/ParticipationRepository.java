package repository;

import entites.Participation;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ParticipationRepository {

    @PersistenceContext
    private EntityManager em;

    public Participation findById(Long id) {
        return em.find(Participation.class, id);
    }

    public List<Participation> findAll() {
        return em.createQuery("SELECT p FROM Participation p", Participation.class).getResultList();
    }

    public Participation save(Participation participation) {
        if (participation.getId() == null) {
            em.persist(participation);
            return participation;
        } else {
            return em.merge(participation);
        }
    }

    public void delete(Participation participation) {
        if (em.contains(participation)) {
            em.remove(participation);
        } else {
            em.remove(em.merge(participation));
        }
    }
    
    // Ajoutez ici d'autres méthodes personnalisées si nécessaire.
}
