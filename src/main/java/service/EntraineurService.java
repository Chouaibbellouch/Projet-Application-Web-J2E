package service;

import entites.Entraineur;
import repository.EntraineurRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class EntraineurService {

    @Inject
    private EntraineurRepository entraineurRepository;

    public Entraineur findEntraineur(Long id) {
        return entraineurRepository.findById(id);
    }

    public List<Entraineur> findAllEntraineurs() {
        return entraineurRepository.findAll();
    }

    public Entraineur saveEntraineur(Entraineur entraineur) {
        return entraineurRepository.save(entraineur);
    }

    public void deleteEntraineur(Long id) {
        Entraineur entraineur = entraineurRepository.findById(id);
        if (entraineur != null) {
            entraineurRepository.delete(entraineur);
        }
    }

    // Ajoutez ici d'autres méthodes métier pour Entraineur si nécessaire.
}
