package service;

import dao.ParticipationDao;
import entites.Participation;

import javax.inject.Inject;
import java.util.List;

public class ParticipationService {

    @Inject
    private ParticipationDao participationDao;

    // Constructeur par défaut
    public ParticipationService() {
        // L'injection est normalement gérée par le conteneur JEE ou Spring.
    }

    // Méthode pour créer une nouvelle participation
    public void createParticipation(Participation participation) {
        participationDao.create(participation);
    }

    // Méthode pour trouver une participation par son ID
    public Participation findParticipationById(Long id) {
        return participationDao.findById(id);
    }

    // Méthode pour mettre à jour une participation
    public void updateParticipation(Participation participation) {
        participationDao.update(participation);
    }

    // Méthode pour supprimer une participation par son ID
    public void deleteParticipationById(Long id) {
        participationDao.delete(id);
    }

    // Méthode pour lister toutes les participations
    public List<Participation> getAllParticipations() {
        return participationDao.findAll();
    }

    // Méthode pour trouver des participations par joueur
    public List<Participation> findParticipationsByJoueur(Long joueurId) {
        return participationDao.findByJoueur(joueurId);
    }

    // Méthode pour trouver des participations par rencontre
    public List<Participation> findParticipationsByRencontre(Long rencontreId) {
        return participationDao.findByRencontre(rencontreId);
    }

    // Vous pouvez ajouter d'autres méthodes de service ou de validation au besoin...
}
