import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entites.Joueur;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("matchsInfosUnit");
        EntityManager em = emf.createEntityManager();
        
        try {
            // Remplacez 'id' par l'identifiant de l'objet Joueur que vous souhaitez supprimer
            Long id = (long) 3; 

            // Débuter la transaction
            em.getTransaction().begin();

            // Trouver l'objet Joueur
            Joueur joueur = em.find(Joueur.class, id);

            // Supprimer l'objet s'il existe
            if (joueur != null) {
                em.remove(joueur);
            }

            // Valider la transaction
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}
