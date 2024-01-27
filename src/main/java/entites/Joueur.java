package entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "joueur")
public class Joueur {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "age")
    private Integer age;

    @Column(name = "annee_de_naissance")
    private Integer anneeDeNaissance;

    @Column(name = "nationalite")
    private String nationalite;

    @Column(name = "poste")
    private String poste;

    @Column(name = "numero_de_maillot")
    private Integer numeroDeMaillot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipe_id") // le nom de la colonne dans la table joueur qui est la clé étrangère de la table equipe
    private Equipe equipe;

    // Constructeurs, getters et setters ci-dessous...

    public Joueur() {
    }
    
 // Constructeur générique
    public Joueur( String nom, String prenom, Integer age, Integer anneeDeNaissance, 
                  String nationalite, String poste, Integer numeroDeMaillot, Equipe equipe) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.anneeDeNaissance = anneeDeNaissance;
        this.nationalite = nationalite;
        this.poste = poste;
        this.numeroDeMaillot = numeroDeMaillot;
        this.equipe = equipe;
    }
    // Getters et setters
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAnneeDeNaissance() {
        return anneeDeNaissance;
    }

    public void setAnneeDeNaissance(Integer anneeDeNaissance) {
        this.anneeDeNaissance = anneeDeNaissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Integer getNumeroDeMaillot() {
        return numeroDeMaillot;
    }

    public void setNumeroDeMaillot(Integer numeroDeMaillot) {
        this.numeroDeMaillot = numeroDeMaillot;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}