package banque.entite;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "banque")
public class Banque implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom")
    private String nom;

    public Banque() {
    }

    public Banque(String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "banque{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
