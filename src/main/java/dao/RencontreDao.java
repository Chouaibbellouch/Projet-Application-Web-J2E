package dao;

import entites.Rencontre;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class RencontreDao {

    @PersistenceContext
    private EntityManager em;

    // Constructeur par défaut
    public RencontreDao() {
        // L'EntityManager est normalement injecté par le conteneur JEE ou Spring.
    }

    // Méthode pour insérer une nouvelle rencontre dans la base de données
    public void create(Rencontre rencontre) {
        em.persist(rencontre);
    }

    // Méthode pour trouver une rencontre par son ID
    public Rencontre findById(Long id) {
        return em.find(Rencontre.class, id);
    }

    // Méthode pour mettre à jour une rencontre
    public void update(Rencontre rencontre) {
        em.merge(rencontre);
    }

    // Méthode pour supprimer une rencontre de la base de données
    public void delete(Long id) {
        Rencontre rencontre = findById(id);
        if (rencontre != null) {
            em.remove(rencontre);
        }
    }

    // Méthode pour récupérer toutes les rencontres
    public List<Rencontre> findAll() {
        TypedQuery<Rencontre> query = em.createQuery("SELECT r FROM Rencontre r", Rencontre.class);
        return query.getResultList();
    }

    // Méthode pour trouver des rencontres par lieu d'accueil
    public List<Rencontre> findByLieuAccueil(Long lieuxAccueilId) {
        TypedQuery<Rencontre> query = em.createQuery(
            "SELECT r FROM Rencontre r WHERE r.lieuxAccueil.id = :lieuxAccueilId", Rencontre.class);
        query.setParameter("lieuxAccueilId", lieuxAccueilId);
        return query.getResultList();
    }

    // Méthode pour trouver des rencontres par intervalle de date
    public List<Rencontre> findByDateRange(Date start, Date end) {
        TypedQuery<Rencontre> query = em.createQuery(
            "SELECT r FROM Rencontre r WHERE r.startTime >= :start AND r.endTime <= :end", Rencontre.class);
        query.setParameter("start", start);
        query.setParameter("end", end);
        return query.getResultList();
    }

    // Méthode pour trouver des rencontres impliquant une certaine équipe
    public List<Rencontre> findByEquipe(Long equipeId) {
        TypedQuery<Rencontre> query = em.createQuery(
            "SELECT r FROM Rencontre r WHERE r.equipeDomicile.id = :equipeId OR r.equipeExterieur.id = :equipeId", Rencontre.class);
        query.setParameter("equipeId", equipeId);
        return query.getResultList();
    }
    
    // Ajoutez ici d'autres méthodes personnalisées selon les besoins...
}
