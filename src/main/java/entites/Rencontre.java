package entites;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rencontre")
public class Rencontre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_time")
    private java.util.Date startTime;

    @Column(name = "end_time")
    private java.util.Date endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lieux_accueil_id")
    private LieuxAccueil lieuxAccueil;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipe_domicile_id")
    private Equipe equipeDomicile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipe_exterieur_id")
    private Equipe equipeExterieur;

    @Column(name = "billet_url")
    private String billetUrl;
    
    @OneToMany(mappedBy = "rencontre", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<But> buts = new HashSet<>();
    
    @ManyToMany
    @JoinTable(
        name = "rencontre_arbitre",
        joinColumns = @JoinColumn(name = "rencontre_id"),
        inverseJoinColumns = @JoinColumn(name = "arbitre_id")
    )
    private Set<Arbitre> arbitres = new HashSet<>();
    
    @OneToMany(mappedBy = "rencontre", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Penalite> penalites = new HashSet<>();
    
    @OneToMany(mappedBy = "rencontre", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Participation> participations = new HashSet<>();
    
    // Constructeurs, getters et setters
    public Rencontre() {
    }

    // Getters et setters
    // ...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.util.Date getStartTime() {
        return startTime;
    }

    public void setStartTime(java.util.Date startTime) {
        this.startTime = startTime;
    }

    public java.util.Date getEndTime() {
        return endTime;
    }

    public void setEndTime(java.util.Date endTime) {
        this.endTime = endTime;
    }

    public LieuxAccueil getLieuxAccueil() {
        return lieuxAccueil;
    }

    public void setLieuxAccueil(LieuxAccueil lieuxAccueil) {
        this.lieuxAccueil = lieuxAccueil;
    }

    public Equipe getEquipeDomicile() {
        return equipeDomicile;
    }

    public void setEquipeDomicile(Equipe equipeDomicile) {
        this.equipeDomicile = equipeDomicile;
    }

    public Equipe getEquipeExterieur() {
        return equipeExterieur;
    }

    public void setEquipeExterieur(Equipe equipeExterieur) {
        this.equipeExterieur = equipeExterieur;
    }

    public String getBilletUrl() {
        return billetUrl;
    }

    public void setBilletUrl(String billetUrl) {
        this.billetUrl = billetUrl;
    }
    
    public Set<But> getButs() {
        return buts;
    }

    public void setButs(Set<But> buts) {
        this.buts = buts;
    }
    
    public Set<Penalite> getPenalites() {
        return penalites;
    }

    public void setPenalites(Set<Penalite> penalites) {
        this.penalites = penalites;
    }
    
    public Set<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(Set<Participation> participations) {
        this.participations = participations;
    }
}
