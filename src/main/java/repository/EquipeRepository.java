package repository;

import entites.Equipe;
import javax.persistence.EntityManager;
import java.util.List;

public class EquipeRepository {

    private EntityManager em;

    // Méthode pour définir manuellement l'EntityManager
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public Equipe findById(Long id) {
        return em.find(Equipe.class, id);
    }

    public List<Equipe> findAll() {
        return em.createQuery("SELECT e FROM Equipe e", Equipe.class).getResultList();
    }

    public Equipe save(Equipe equipe) {
        if (equipe.getId() == null) {
            em.persist(equipe);
            return equipe;
        } else {
            return em.merge(equipe);
        }
    }

    public void delete(Equipe equipe) {
        if (em.contains(equipe)) {
            em.remove(equipe);
        } else {
            em.remove(em.merge(equipe));
        }
    }

    // Autres méthodes...
}