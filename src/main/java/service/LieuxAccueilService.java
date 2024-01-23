package service;

import entites.LieuxAccueil;
import repository.LieuxAccueilRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class LieuxAccueilService {

    @Inject
    private LieuxAccueilRepository lieuxAccueilRepository;

    public LieuxAccueil findLieuxAccueil(Long id) {
        return lieuxAccueilRepository.findById(id);
    }

    public List<LieuxAccueil> findAllLieuxAccueils() {
        return lieuxAccueilRepository.findAll();
    }

    public LieuxAccueil saveLieuxAccueil(LieuxAccueil lieuxAccueil) {
        return lieuxAccueilRepository.save(lieuxAccueil);
    }

    public void deleteLieuxAccueil(Long id) {
        LieuxAccueil lieuxAccueil = lieuxAccueilRepository.findById(id);
        if (lieuxAccueil != null) {
            lieuxAccueilRepository.delete(lieuxAccueil);
        }
    }

    // Ajoutez ici d'autres méthodes métier pour LieuxAccueil si nécessaire.
}
