package dao;

import entites.Joueur;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class JoueurDao {

    @PersistenceContext
    private EntityManager em;

    // Constructeur par défaut
    public JoueurDao() {
        // L'EntityManager est normalement injecté par le conteneur JEE ou Spring.
    }

    // Méthode pour créer un nouveau joueur
    public void create(Joueur joueur) {
        em.persist(joueur);
    }

    // Méthode pour trouver un joueur par son ID
    public Joueur findById(Long id) {
        return em.find(Joueur.class, id);
    }

    // Méthode pour mettre à jour un joueur
    public void update(Joueur joueur) {
        em.merge(joueur);
    }

    // Méthode pour supprimer un joueur
    public void delete(Long id) {
        Joueur joueur = findById(id);
        if (joueur != null) {
            em.remove(joueur);
        }
    }

    // Méthode pour récupérer tous les joueurs
    public List<Joueur> findAll() {
        TypedQuery<Joueur> query = em.createQuery("SELECT j FROM Joueur j", Joueur.class);
        return query.getResultList();
    }

    // Méthode pour trouver des joueurs par nom
    public List<Joueur> findByNom(String nom) {
        TypedQuery<Joueur> query = em.createQuery("SELECT j FROM Joueur j WHERE j.nom = :nom", Joueur.class);
        query.setParameter("nom", nom);
        return query.getResultList();
    }
    
    // Méthode pour trouver des joueurs par équipe
    public List<Joueur> findByEquipe(Long equipeId) {
        TypedQuery<Joueur> query = em.createQuery(
                "SELECT j FROM Joueur j WHERE j.equipe.id = :equipeId", Joueur.class);
        query.setParameter("equipeId", equipeId);
        return query.getResultList();
    }
    
    // Méthode pour trouver des joueurs par nationalité
    public List<Joueur> findByNationalite(String nationalite) {
        TypedQuery<Joueur> query = em.createQuery(
                "SELECT j FROM Joueur j WHERE j.nationalite = :nationalite", Joueur.class);
        query.setParameter("nationalite", nationalite);
        return query.getResultList();
    }

    // Ajoutez ici d'autres méthodes personnalisées selon les besoins...
}
