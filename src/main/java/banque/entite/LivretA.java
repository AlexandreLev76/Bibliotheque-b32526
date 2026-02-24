package banque.entite;

import jakarta.persistence.*;

@Entity
@Table(name = "livret_a")
@PrimaryKeyJoinColumn(name = "id")
public class LivretA extends Compte {

    @Column(name = "taux")
    private Double taux;

    public LivretA() {
    }

    public LivretA(String numero, double solde, double taux) {
        super(numero, solde);
        this.taux = taux;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "LivretA{" +
                "taux=" + taux +
                "} " + super.toString();
    }
}
