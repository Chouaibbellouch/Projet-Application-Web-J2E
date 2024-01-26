package service;

import dao.RencontreDao;
import entites.Rencontre;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Stateless
public class RencontreService {

    @Inject
    private RencontreDao rencontreDao;

    // Constructeur par défaut
    public RencontreService() {
        // L'injection est normalement gérée par le conteneur EJB ou Spring.
    }

    // Méthode pour créer une nouvelle rencontre
    public void createRencontre(Rencontre rencontre) {
        rencontreDao.create(rencontre);
    }

    // Méthode pour trouver une rencontre par son ID
    public Rencontre findRencontreById(Long id) {
        return rencontreDao.findById(id);
    }

    // Méthode pour mettre à jour une rencontre
    public void updateRencontre(Rencontre rencontre) {
        rencontreDao.update(rencontre);
    }

    // Méthode pour supprimer une rencontre par son ID
    public void deleteRencontreById(Long id) {
        rencontreDao.delete(id);
    }

    // Méthode pour lister toutes les rencontres
    public List<Rencontre> getAllRencontres() {
        return rencontreDao.findAll();
    }

    // Méthode pour trouver des rencontres par lieu d'accueil
    public List<Rencontre> findRencontresByLieuAccueil(Long lieuxAccueilId) {
        return rencontreDao.findByLieuAccueil(lieuxAccueilId);
    }

    // Méthode pour trouver des rencontres par intervalle de date
    public List<Rencontre> findRencontresByDateRange(Date start, Date end) {
        return rencontreDao.findByDateRange(start, end);
    }

    // Méthode pour trouver des rencontres impliquant une certaine équipe
    public List<Rencontre> findRencontresByEquipe(Long equipeId) {
        return rencontreDao.findByEquipe(equipeId);
    }

    // Vous pouvez ajouter d'autres méthodes de service ou de validation au besoin...
}
