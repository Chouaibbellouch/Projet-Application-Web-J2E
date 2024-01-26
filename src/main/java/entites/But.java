package entites;

import javax.persistence.*;

@Entity
@Table(name = "but")
public class But {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rencontre_id")
    private Rencontre rencontre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "joueur_id")
    private Joueur joueur;

    @Column(name = "time")
    private java.util.Date time;

    @Column(name = "type_action")
    private String typeAction;

    // Constructeurs, getters et setters
    public But() {
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

    public java.util.Date getTime() {
        return time;
    }

    public void setTime(java.util.Date time) {
        this.time = time;
    }

    public String getTypeAction() {
        return typeAction;
    }

    public void setTypeAction(String typeAction) {
        this.typeAction = typeAction;
    }
}