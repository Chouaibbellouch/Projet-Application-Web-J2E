package dao;

import entites.Participation;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class ParticipationDao {

    @PersistenceContext
    private EntityManager em;

    // Constructeur par défaut
    public ParticipationDao() {
        // L'EntityManager est normalement injecté par le conteneur JEE ou Spring.
    }

    // Méthode pour insérer une nouvelle participation dans la base de données
    public void create(Participation participation) {
        em.persist(participation);
    }

    // Méthode pour trouver une participation par son ID
    public Participation findById(Long id) {
        return em.find(Participation.class, id);
    }

    // Méthode pour mettre à jour une participation
    public void update(Participation participation) {
        em.merge(participation);
    }

    // Méthode pour supprimer une participation
    public void delete(Long id) {
        Participation participation = findById(id);
        if (participation != null) {
            em.remove(participation);
        }
    }

    // Méthode pour récupérer toutes les participations
    public List<Participation> findAll() {
        TypedQuery<Participation> query = em.createQuery("SELECT p FROM Participation p", Participation.class);
        return query.getResultList();
    }

    // Méthode pour trouver des participations par joueur
    public List<Participation> findByJoueur(Long joueurId) {
        TypedQuery<Participation> query = em.createQuery(
            "SELECT p FROM Participation p WHERE p.joueur.id = :joueurId", Participation.class);
        query.setParameter("joueurId", joueurId);
        return query.getResultList();
    }

    // Méthode pour trouver des participations par rencontre
    public List<Participation> findByRencontre(Long rencontreId) {
        TypedQuery<Participation> query = em.createQuery(
            "SELECT p FROM Participation p WHERE p.rencontre.id = :rencontreId", Participation.class);
        query.setParameter("rencontreId", rencontreId);
        return query.getResultList();
    }

    // Ajoutez ici d'autres méthodes personnalisées selon les besoins...
}
