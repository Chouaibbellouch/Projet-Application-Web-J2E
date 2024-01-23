package entites;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "arbitre")
public class Arbitre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "annee_de_naissance")
    private Integer anneeDeNaissance;

    @ManyToMany(mappedBy = "arbitres", fetch = FetchType.LAZY)
    private Set<Rencontre> rencontres = new HashSet<>();

    // Constructeurs, getters et setters
    public Arbitre() {
    }

    // Getters et setters
    // ...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getAnneeDeNaissance() {
        return anneeDeNaissance;
    }

    public void setAnneeDeNaissance(Integer anneeDeNaissance) {
        this.anneeDeNaissance = anneeDeNaissance;
    }

    public Set<Rencontre> getRencontres() {
        return rencontres;
    }

    public void setRencontres(Set<Rencontre> rencontres) {
        this.rencontres = rencontres;
    }
}
