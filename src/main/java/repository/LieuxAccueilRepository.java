package repository;

import entites.LieuxAccueil;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LieuxAccueilRepository {

    @PersistenceContext
    private EntityManager em;

    public LieuxAccueil findById(Long id) {
        return em.find(LieuxAccueil.class, id);
    }

    public List<LieuxAccueil> findAll() {
        return em.createQuery("SELECT l FROM LieuxAccueil l", LieuxAccueil.class).getResultList();
    }

    public LieuxAccueil save(LieuxAccueil lieuAccueil) {
        if (lieuAccueil.getId() == null) {
            em.persist(lieuAccueil);
            return lieuAccueil;
        } else {
            return em.merge(lieuAccueil);
        }
    }

    public void delete(LieuxAccueil lieuAccueil) {
        if (em.contains(lieuAccueil)) {
            em.remove(lieuAccueil);
        } else {
            em.remove(em.merge(lieuAccueil));
        }
    }
    
    // Vous pouvez ajouter d'autres méthodes spécifiques pour les opérations liées aux lieux d'accueil.
}
