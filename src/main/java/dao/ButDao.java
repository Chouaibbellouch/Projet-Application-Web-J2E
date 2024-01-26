package dao;

import entites.But;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class ButDao {

    @PersistenceContext
    private EntityManager em;

    // Constructeur par défaut
    public ButDao() {
        // L'EntityManager est normalement injecté par le conteneur JEE ou Spring.
    }

    // Méthode pour insérer un nouveau but
    public void create(But but) {
        em.persist(but);
    }

    // Méthode pour trouver un but par son ID
    public But findById(Long id) {
        return em.find(But.class, id);
    }

    // Méthode pour mettre à jour un but
    public void update(But but) {
        em.merge(but);
    }

    // Méthode pour supprimer un but
    public void delete(Long id) {
        But but = findById(id);
        if (but != null) {
            em.remove(but);
        }
    }

    // Méthode pour récupérer tous les buts
    public List<But> findAll() {
        TypedQuery<But> query = em.createQuery("SELECT b FROM But b", But.class);
        return query.getResultList();
    }

    // Méthode pour trouver des buts par rencontre
    public List<But> findByRencontre(Long rencontreId) {
        TypedQuery<But> query = em.createQuery(
            "SELECT b FROM But b WHERE b.rencontre.id = :rencontreId", But.class);
        query.setParameter("rencontreId", rencontreId);
        return query.getResultList();
    }

    // Méthode pour trouver des buts par joueur
    public List<But> findByJoueur(Long joueurId) {
        TypedQuery<But> query = em.createQuery(
            "SELECT b FROM But b WHERE b.joueur.id = :joueurId", But.class);
        query.setParameter("joueurId", joueurId);
        return query.getResultList();
    }

    // Autres méthodes personnalisées pour interagir avec la base de données peuvent être ajoutées ici...
}
