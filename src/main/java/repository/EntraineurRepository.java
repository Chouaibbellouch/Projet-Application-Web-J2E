package repository;

import entites.Entraineur;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class EntraineurRepository {

    @PersistenceContext
    private EntityManager em;

    public Entraineur findById(Long id) {
        return em.find(Entraineur.class, id);
    }

    public List<Entraineur> findAll() {
        return em.createQuery("SELECT e FROM Entraineur e", Entraineur.class).getResultList();
    }

    public Entraineur save(Entraineur entraineur) {
        if (entraineur.getId() == null) {
            em.persist(entraineur);
            return entraineur;
        } else {
            return em.merge(entraineur);
        }
    }

    public void delete(Entraineur entraineur) {
        if (em.contains(entraineur)) {
            em.remove(entraineur);
        } else {
            em.remove(em.merge(entraineur));
        }
    }
    
    // Ajoutez ici d'autres méthodes personnalisées si nécessaire.
}
