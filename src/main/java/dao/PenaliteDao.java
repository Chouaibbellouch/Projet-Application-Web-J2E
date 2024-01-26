package dao;

import entites.Penalite;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class PenaliteDao {

    @PersistenceContext
    private EntityManager em;

    // Constructeur par défaut
    public PenaliteDao() {
        // L'EntityManager est normalement injecté par le conteneur JEE ou Spring.
    }

    // Méthode pour insérer une nouvelle pénalité dans la base de données
    public void create(Penalite penalite) {
        em.persist(penalite);
    }

    // Méthode pour trouver une pénalité par son ID
    public Penalite findById(Long id) {
        return em.find(Penalite.class, id);
    }

    // Méthode pour mettre à jour une pénalité
    public void update(Penalite penalite) {
        em.merge(penalite);
    }

    // Méthode pour supprimer une pénalité
    public void delete(Long id) {
        Penalite penalite = findById(id);
        if (penalite != null) {
            em.remove(penalite);
        }
    }

    // Méthode pour récupérer toutes les pénalités
    public List<Penalite> findAll() {
        TypedQuery<Penalite> query = em.createQuery("SELECT p FROM Penalite p", Penalite.class);
        return query.getResultList();
    }

    // Méthode pour trouver des pénalités par joueur
    public List<Penalite> findByJoueur(Long joueurId) {
        TypedQuery<Penalite> query = em.createQuery(
            "SELECT p FROM Penalite p WHERE p.joueur.id = :joueurId", Penalite.class);
        query.setParameter("joueurId", joueurId);
        return query.getResultList();
    }

    // Méthode pour trouver des pénalités par rencontre
    public List<Penalite> findByRencontre(Long rencontreId) {
        TypedQuery<Penalite> query = em.createQuery(
            "SELECT p FROM Penalite p WHERE p.rencontre.id = :rencontreId", Penalite.class);
        query.setParameter("rencontreId", rencontreId);
        return query.getResultList();
    }

    // Ajoutez ici d'autres méthodes personnalisées selon les besoins...
}
