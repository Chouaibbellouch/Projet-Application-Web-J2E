package dao;

import entites.Joueur;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JoueurDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public JoueurDao() {
        emf = Persistence.createEntityManagerFactory("matchsInfosUnit");
        em = emf.createEntityManager();
    }

    public void create(Joueur joueur) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(joueur);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Joueur findById(Long id) {
        return em.find(Joueur.class, id);
    }

    public void update(Joueur joueur) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        try {
        	tx = em.getTransaction();
            tx.begin();

            em.merge(joueur);

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            Joueur joueur = em.find(Joueur.class, id);
            if (joueur != null) {
                em.remove(joueur);
            }
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

 // Méthode pour récupérer tous les joueurs avec leurs équipes
    public List<Joueur> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Joueur> query = em.createQuery(
                "SELECT j FROM Joueur j JOIN FETCH j.equipe", Joueur.class);
            List<Joueur> joueurs = query.getResultList();

            // Affichage des joueurs et de leurs équipes dans la console
            for (Joueur joueur : joueurs) {
                System.out.println("ID: " + joueur.getId() + ", Nom: " + joueur.getNom());
                if (joueur.getEquipe() != null) {
                    System.out.println("Équipe: " + joueur.getEquipe().getNom());
                } else {
                    System.out.println("Équipe: Non défini");
                }
            }

            return joueurs;
        } finally {
            em.close();
        }
    }


    // Autres méthodes...
}
