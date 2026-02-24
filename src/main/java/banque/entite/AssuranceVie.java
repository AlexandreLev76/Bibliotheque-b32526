package banque.entite;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "assurance_vie")
@PrimaryKeyJoinColumn(name = "id")
public class AssuranceVie extends Compte {

    @Column(name = "date_fin")
    private LocalDate dateFin;

    @Column(name = "taux")
    private Double taux;

    public AssuranceVie() {
    }

    public AssuranceVie(String numero, double solde, LocalDate dateFin, double taux) {
        super(numero, solde);
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "AssuranceVie{" +
                "dateFin=" + dateFin +
                ", taux=" + taux +
                "} " + super.toString();
    }
}
