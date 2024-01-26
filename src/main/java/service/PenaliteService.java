package service;

import dao.PenaliteDao;
import entites.Penalite;

import javax.inject.Inject;
import java.util.List;

public class PenaliteService {

    @Inject
    private PenaliteDao penaliteDao;

    // Constructeur par défaut
    public PenaliteService() {
        // L'injection est normalement gérée par le conteneur JEE ou Spring.
    }

    // Méthode pour créer une nouvelle pénalité
    public void createPenalite(Penalite penalite) {
        penaliteDao.create(penalite);
    }

    // Méthode pour trouver une pénalité par son ID
    public Penalite findPenaliteById(Long id) {
        return penaliteDao.findById(id);
    }

    // Méthode pour mettre à jour une pénalité
    public void updatePenalite(Penalite penalite) {
        penaliteDao.update(penalite);
    }

    // Méthode pour supprimer une pénalité par son ID
    public void deletePenaliteById(Long id) {
        penaliteDao.delete(id);
    }

    // Méthode pour lister toutes les pénalités
    public List<Penalite> getAllPenalites() {
        return penaliteDao.findAll();
    }

    // Méthode pour trouver des pénalités par joueur
    public List<Penalite> findPenalitesByJoueur(Long joueurId) {
        return penaliteDao.findByJoueur(joueurId);
    }

    // Méthode pour trouver des pénalités par rencontre
    public List<Penalite> findPenalitesByRencontre(Long rencontreId) {
        return penaliteDao.findByRencontre(rencontreId);
    }

    // Vous pouvez ajouter d'autres méthodes de service ou de validation au besoin...
}
