package fr.epsi.b32526;

import jakarta.persistence.*;

@Entity
@Table(name = "emprunt")
public class Emprunt {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "date_debut")
    private String dateDebut;

    @Column(name = "date_fin")
    private String dateFin;

    @Column(name= "delai")
    private int delai;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
