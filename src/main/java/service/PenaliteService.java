package service;

import entites.Penalite;
import repository.PenaliteRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class PenaliteService {

    @Inject
    private PenaliteRepository penaliteRepository;

    public Penalite findPenalite(Long id) {
        return penaliteRepository.findById(id);
    }

    public List<Penalite> findAllPenalites() {
        return penaliteRepository.findAll();
    }

    public Penalite savePenalite(Penalite penalite) {
        return penaliteRepository.save(penalite);
    }

    public void deletePenalite(Long id) {
        Penalite penalite = penaliteRepository.findById(id);
        if (penalite != null) {
            penaliteRepository.delete(penalite);
        }
    }

    // Ajoutez ici d'autres méthodes métier pour Penalite si nécessaire.
}
