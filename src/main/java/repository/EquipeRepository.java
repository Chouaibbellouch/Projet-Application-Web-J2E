package repository;

import entites.Equipe;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class EquipeRepository {

    @PersistenceContext
    private EntityManager em;

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
    
    // Vous pouvez ajouter d'autres méthodes spécifiques aux opérations liées aux équipes ici.
}
