package service;

import entites.Joueur;
import repository.JoueurRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class JoueurService {

    @Inject
    private JoueurRepository joueurRepository;

    public Joueur findJoueur(Long id) {
        return joueurRepository.findById(id);
    }

    public List<Joueur> findAllJoueurs() {
        return joueurRepository.findAll();
    }

    public Joueur saveJoueur(Joueur joueur) {
        return joueurRepository.save(joueur);
    }

    public void deleteJoueur(Long id) {
        Joueur joueur = joueurRepository.findById(id);
        if (joueur != null) {
            joueurRepository.delete(joueur);
        }
    }

    // Ajoutez ici d'autres méthodes métier pour Joueur si nécessaire.
}