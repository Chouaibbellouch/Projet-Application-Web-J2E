package service;

import entites.Equipe;
import repository.EquipeRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class EquipeService {

    @Inject
    private EquipeRepository equipeRepository;

    public Equipe findEquipe(Long id) {
        return equipeRepository.findById(id);
    }

    public List<Equipe> findAllEquipes() {
        return equipeRepository.findAll();
    }

    public Equipe saveEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    public void deleteEquipe(Long id) {
        Equipe equipe = equipeRepository.findById(id);
        if (equipe != null) {
            equipeRepository.delete(equipe);
        }
    }
    
    public void setEquipeRepository(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    // Ajoutez ici d'autres méthodes métier pour Equipe si nécessaire.
}
