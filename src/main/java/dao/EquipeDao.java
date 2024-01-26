package dao;

import entites.Equipe;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class EquipeDao {

    @PersistenceContext
    private EntityManager em;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("matchsInfosUnit");
    // Constructeur par défaut
    public EquipeDao() {
        // Crée l'EntityManagerFactory et l'EntityManager
        
        this.em = emf.createEntityManager();
    }
    
    // Méthode pour insérer une nouvelle équipe dans la base de données
    public void create(Equipe equipe) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            
            em.persist(equipe);
            
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e; // ou vous pourriez gérer l'erreur comme vous le souhaitez
        } finally {
            em.close();
        }
    }

    // Méthode pour trouver une équipe par son ID
    public Equipe findById(Long id) {
        return em.find(Equipe.class, id);
    }

    // Méthode pour mettre à jour une équipe
    public void update(Equipe equipe) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();

            em.merge(equipe);

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e; // ou vous pourriez gérer l'erreur comme vous le souhaitez
        } finally {
            em.close();
        }
    }


    // Méthode pour supprimer une équipe
    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();

            Equipe equipe = em.find(Equipe.class, id);
            if (equipe != null) {
                em.remove(equipe);
            }

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e; // ou vous pourriez gérer l'erreur comme vous le souhaitez
        } finally {
            em.close();
        }
    }


    // Méthode pour lister toutes les équipes
    public List<Equipe> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
        	System.out.println("findAll");
            TypedQuery<Equipe> query = em.createQuery("SELECT e FROM Equipe e LEFT JOIN FETCH e.lieuxAccueil", Equipe.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }


    // Méthode pour trouver une équipe par nom
    public List<Equipe> findByName(String nom) {
        TypedQuery<Equipe> query = em.createQuery("SELECT e FROM Equipe e WHERE e.nom = :nom", Equipe.class);
        query.setParameter("nom", nom);
        return query.getResultList();
    }
    
    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
    
    // Vous pouvez ajouter d'autres méthodes personnalisées ici...
}
