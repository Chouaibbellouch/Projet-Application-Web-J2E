package service;

import entites.But;
import repository.ButRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ButService {

    @Inject
    private ButRepository butRepository;

    public But findBut(Long id) {
        return butRepository.findById(id);
    }

    public List<But> findAllButs() {
        return butRepository.findAll();
    }

    public But saveBut(But but) {
        return butRepository.save(but);
    }

    public void deleteBut(Long id) {
        But but = butRepository.findById(id);
        if (but != null) {
            butRepository.delete(but);
        }
    }

    // Ajoutez ici d'autres méthodes métier pour But si nécessaire.
}
