package entites;

import javax.persistence.*;

@Entity
@Table(name = "penalite")
public class Penalite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rencontre_id")
    private Rencontre rencontre;

    @Column(name = "description")
    private String description;

    @Column(name = "time")
    private java.util.Date time;

    @Column(name = "decision")
    private String decision;

    // Constructeurs, getters et setters
    public Penalite() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.util.Date getTime() {
        return time;
    }

    public void setTime(java.util.Date time) {
        this.time = time;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }
}