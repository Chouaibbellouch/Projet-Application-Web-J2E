package repository;

import entites.Joueur;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class JoueurRepository {

    @PersistenceContext
    private EntityManager em;

    public Joueur findById(Long id) {
        return em.find(Joueur.class, id);
    }

    public List<Joueur> findAll() {
        return em.createQuery("SELECT j FROM Joueur j", Joueur.class).getResultList();
    }

    public Joueur save(Joueur joueur) {
        if (joueur.getId() == null) {
            em.persist(joueur);
            return joueur;
        } else {
            return em.merge(joueur);
        }
    }

    public void delete(Joueur joueur) {
        if (em.contains(joueur)) {
            em.remove(joueur);
        } else {
            em.remove(em.merge(joueur));
        }
    }
}
