package dao;

import entites.Entraineur;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class EntraineurDao {

    @PersistenceContext
    private EntityManager em;

    // Constructeur par défaut
    public EntraineurDao() {
        // EntityManager est normalement injecté par le conteneur d'EJB ou Spring
    }

    // Méthode pour insérer un nouvel entraineur dans la base de données
    public void create(Entraineur entraineur) {
        em.persist(entraineur);
    }

    // Méthode pour trouver un entraineur par son ID
    public Entraineur findById(Long id) {
        return em.find(Entraineur.class, id);
    }

    // Méthode pour mettre à jour les informations d'un entraineur
    public void update(Entraineur entraineur) {
        em.merge(entraineur);
    }

    // Méthode pour supprimer un entraineur de la base de données
    public void delete(Long id) {
        Entraineur entraineur = findById(id);
        if (entraineur != null) {
            em.remove(entraineur);
        }
    }

    // Méthode pour récupérer tous les entraineurs
    public List<Entraineur> findAll() {
        TypedQuery<Entraineur> query = em.createQuery("SELECT e FROM Entraineur e", Entraineur.class);
        return query.getResultList();
    }

    // Méthode pour trouver des entraineurs par nom
    public List<Entraineur> findByNom(String nom) {
        TypedQuery<Entraineur> query = em.createQuery("SELECT e FROM Entraineur e WHERE e.nom = :nom", Entraineur.class);
        query.setParameter("nom", nom);
        return query.getResultList();
    }
    
    // Méthode pour trouver des entraineurs par équipe
    public List<Entraineur> findByEquipe(Long equipeId) {
        TypedQuery<Entraineur> query = em.createQuery(
                "SELECT e FROM Entraineur e WHERE e.equipe.id = :equipeId", Entraineur.class);
        query.setParameter("equipeId", equipeId);
        return query.getResultList();
    }

    // Autres méthodes personnalisées pour interagir avec la base de données peuvent être ajoutées ici...
}
