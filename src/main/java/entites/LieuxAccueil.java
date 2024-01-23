package entites;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lieux_accueil")
public class LieuxAccueil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "nom")
    private String nom;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "courriel")
    private String courriel;

    @Column(name = "site_internet")
    private String siteInternet;

    @Column(name = "infos_pmr")
    private String infosPMR;

    @Column(name = "capacite")
    private Integer capacite;

    @Column(name = "commentaires")
    private String commentaires;

    @OneToMany(mappedBy = "lieuxAccueil", fetch = FetchType.LAZY)
    private Set<Equipe> equipes = new HashSet<>();
    
    @OneToMany(mappedBy = "lieuxAccueil", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Rencontre> rencontres = new HashSet<>();

    // Constructeurs, getters et setters
    public LieuxAccueil() {
    }

    // Getters et setters
    // ...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getSiteInternet() {
        return siteInternet;
    }

    public void setSiteInternet(String siteInternet) {
        this.siteInternet = siteInternet;
    }

    public String getInfosPMR() {
        return infosPMR;
    }

    public void setInfosPMR(String infosPMR) {
        this.infosPMR = infosPMR;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    public Set<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(Set<Equipe> equipes) {
        this.equipes = equipes;
    }
    
    public Set<Rencontre> getRencontres() {
        return rencontres;
    }

    public void setRencontres(Set<Rencontre> rencontres) {
        this.rencontres = rencontres;
    }

    // ...
}
