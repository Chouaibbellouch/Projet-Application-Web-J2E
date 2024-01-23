package service;

import entites.Participation;
import repository.ParticipationRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ParticipationService {

    @Inject
    private ParticipationRepository participationRepository;

    public Participation findParticipation(Long id) {
        return participationRepository.findById(id);
    }

    public List<Participation> findAllParticipations() {
        return participationRepository.findAll();
    }

    public Participation saveParticipation(Participation participation) {
        return participationRepository.save(participation);
    }

    public void deleteParticipation(Long id) {
        Participation participation = participationRepository.findById(id);
        if (participation != null) {
            participationRepository.delete(participation);
        }
    }

    // Ajoutez ici d'autres méthodes métier pour Participation si nécessaire.
}
