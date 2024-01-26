package entites;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "equipe")
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    // La relation inverse de Joueur vers Equipe
    @OneToMany(mappedBy = "equipe", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Joueur> joueurs = new HashSet<>();
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lieux_accueil_id") 
    private LieuxAccueil lieuxAccueil;
    
    @OneToMany(mappedBy = "equipe", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Entraineur> entraineurs = new HashSet<>();
    
    // Constructeur par défaut
    public Equipe() {
    }

    public Equipe(String nom) {
    	this.nom = nom;
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
    
    public LieuxAccueil getLieuxAccueil() {
        return lieuxAccueil;
    }
    
    public void setLieuxAccueil(LieuxAccueil lieuxAccueil) {
        this.lieuxAccueil = lieuxAccueil;
    }
    
    public Set<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(Set<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    // Méthodes pour ajouter et supprimer un joueur
    public void addJoueur(Joueur joueur) {
        joueurs.add(joueur);
        joueur.setEquipe(this);
    }

    public void removeJoueur(Joueur joueur) {
        joueurs.remove(joueur);
        joueur.setEquipe(null);
    }
    
    public Set<Entraineur> getEntraineurs() {
        return entraineurs;
    }

    public void setEntraineurs(Set<Entraineur> entraineurs) {
        this.entraineurs = entraineurs;
    }
}