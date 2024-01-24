import entites.Equipe;
import service.EquipeService;
import repository.EquipeRepository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("matchsInfosUnit");
        EntityManager em = emf.createEntityManager();

        // Création des instances de repository et service
        EquipeRepository equipeRepository = new EquipeRepository();
        equipeRepository.setEntityManager(em);
        EquipeService equipeService = new EquipeService();
        equipeService.setEquipeRepository(equipeRepository);

        Equipe nouvelleEquipe = new Equipe();
        nouvelleEquipe.setNom("Barcelona");

        try {
            em.getTransaction().begin();
            equipeService.saveEquipe(nouvelleEquipe);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
