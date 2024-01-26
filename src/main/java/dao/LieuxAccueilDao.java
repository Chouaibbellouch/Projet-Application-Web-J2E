package dao;

import entites.Equipe;
import entites.LieuxAccueil;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class LieuxAccueilDao {
	private EntityManager em;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("matchsInfosUnit");
    
    public LieuxAccueilDao() {
        // Crée l'EntityManagerFactory et l'EntityManager
        
        this.em = emf.createEntityManager();
    }
    
    // Méthode pour créer un nouveau lieu d'accueil
    public void create(LieuxAccueil lieuxAccueil) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            
            em.persist(lieuxAccueil);
            
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    // Méthode pour mettre à jour un lieu d'accueil
    public void update(LieuxAccueil lieuxAccueil) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();

            em.merge(lieuxAccueil);

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    // Méthode pour supprimer un lieu d'accueil
    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();

            LieuxAccueil lieuxAccueil = em.find(LieuxAccueil.class, id);
            if (lieuxAccueil != null) {
                em.remove(lieuxAccueil);
            }

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    // Méthode pour récupérer tous les lieux d'accueil
    public List<LieuxAccueil> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<LieuxAccueil> query = em.createQuery("SELECT l FROM LieuxAccueil l", LieuxAccueil.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    public LieuxAccueil findById(Long id) {
        return em.find(LieuxAccueil.class, id);
    }

    // Autres méthodes...
}
