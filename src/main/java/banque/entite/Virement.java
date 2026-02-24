package banque.entite;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "virement")
@PrimaryKeyJoinColumn(name = "id")
public class Virement extends Operation {

    @Column(name = "beneficiaire")
    private String beneficiaire;

    public Virement() {
    }

    public Virement(LocalDateTime date, double montant, String motif, String beneficiaire) {
        super(date, montant, motif);
        this.beneficiaire = beneficiaire;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    @Override
    public String toString() {
        return "Virement{" +
                "beneficiaire='" + beneficiaire + '\'' +
                "} " + super.toString();
    }
}
