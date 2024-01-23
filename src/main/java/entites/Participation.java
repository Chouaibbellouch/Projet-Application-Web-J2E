package entites;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "participation")
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rencontre_id")
    private Rencontre rencontre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "joueur_id")
    private Joueur joueur;

    @Column(name = "time_entree")
    private Date timeEntree;

    @Column(name = "time_sortie")
    private Date timeSortie;

    // Constructeurs, getters et setters
    public Participation() {
    }

    // Getters et setters
    // ...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rencontre getRencontre() {
        return rencontre;
    }

    public void setRencontre(Rencontre rencontre) {
        this.rencontre = rencontre;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public Date getTimeEntree() {
        return timeEntree;
    }

    public void setTimeEntree(Date timeEntree) {
        this.timeEntree = timeEntree;
    }

    public Date getTimeSortie() {
        return timeSortie;
    }

    public void setTimeSortie(Date timeSortie) {
        this.timeSortie = timeSortie;
    }
}
