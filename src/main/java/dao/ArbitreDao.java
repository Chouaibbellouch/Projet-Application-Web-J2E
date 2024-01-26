package dao;

import entites.Arbitre;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class ArbitreDao {

    @PersistenceContext
    private EntityManager em;

    // Constructeur par défaut
    public ArbitreDao() {
        // L'EntityManager est normalement injecté par le conteneur JEE ou Spring.
    }

    // Méthode pour insérer un nouvel arbitre
    public void create(Arbitre arbitre) {
        em.persist(arbitre);
    }

    // Méthode pour trouver un arbitre par son ID
    public Arbitre findById(Long id) {
        return em.find(Arbitre.class, id);
    }

    // Méthode pour mettre à jour un arbitre
    public void update(Arbitre arbitre) {
        em.merge(arbitre);
    }

    // Méthode pour supprimer un arbitre
    public void delete(Long id) {
        Arbitre arbitre = findById(id);
        if (arbitre != null) {
            em.remove(arbitre);
        }
    }

    // Méthode pour récupérer tous les arbitres
    public List<Arbitre> findAll() {
        TypedQuery<Arbitre> query = em.createQuery("SELECT a FROM Arbitre a", Arbitre.class);
        return query.getResultList();
    }

    // Méthode pour trouver des arbitres par nom
    public List<Arbitre> findByNom(String nom) {
        TypedQuery<Arbitre> query = em.createQuery("SELECT a FROM Arbitre a WHERE a.nom = :nom", Arbitre.class);
        query.setParameter("nom", nom);
        return query.getResultList();
    }

    // Autres méthodes personnalisées pour interagir avec la base de données peuvent être ajoutées ici...
}
