package service;

import entites.Arbitre;
import repository.ArbitreRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ArbitreService {

    @Inject
    private ArbitreRepository arbitreRepository;

    public Arbitre findArbitre(Long id) {
        return arbitreRepository.findById(id);
    }

    public List<Arbitre> findAllArbitres() {
        return arbitreRepository.findAll();
    }

    public Arbitre saveArbitre(Arbitre arbitre) {
        return arbitreRepository.save(arbitre);
    }

    public void deleteArbitre(Long id) {
        Arbitre arbitre = arbitreRepository.findById(id);
        if (arbitre != null) {
            arbitreRepository.delete(arbitre);
        }
    }

    // Ajoutez ici d'autres méthodes métier pour Arbitre si nécessaire.
}