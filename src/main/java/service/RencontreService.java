package service;

import entites.Rencontre;
import repository.RencontreRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class RencontreService {

    @Inject
    private RencontreRepository rencontreRepository;

    public Rencontre findRencontre(Long id) {
        return rencontreRepository.findById(id);
    }

    public List<Rencontre> findAllRencontres() {
        return rencontreRepository.findAll();
    }

    public Rencontre saveRencontre(Rencontre rencontre) {
        return rencontreRepository.save(rencontre);
    }

    public void deleteRencontre(Long id) {
        Rencontre rencontre = rencontreRepository.findById(id);
        if (rencontre != null) {
            rencontreRepository.delete(rencontre);
        }
    }

    // Ajoutez ici d'autres méthodes métier pour Rencontre si nécessaire.
}
