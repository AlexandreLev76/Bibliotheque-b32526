package banque.entite;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class App {

    public static void main(String[] args) {

        try (
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("banquePU");
                EntityManager em = emf.createEntityManager();
        ) {
            em.getTransaction().begin();

            // Banque
            Banque banque = new Banque("Banque Populaire");

            // Clients avec adresses
            Client client1 = new Client("Dupont", "Jean", "1990-01-01");
            client1.setAdresse(new Adresse("10", "Rue A", 75001, "Paris"));
            client1.setBanque(banque);

            Client client2 = new Client("Durand", "Marie", "1985-05-10");
            client2.setAdresse(new Adresse("20", "Rue B", 69000, "Lyon"));
            client2.setBanque(banque);

            Client client3 = new Client("Martin", "Paul", "1992-09-15");
            client3.setAdresse(new Adresse("30", "Rue C", 33000, "Bordeaux"));
            client3.setBanque(banque);

            banque.getClients().add(client1);
            banque.getClients().add(client2);
            banque.getClients().add(client3);

            // 1. Insérer un compte associé à 2 clients
            Compte compteCommun = new Compte("C-0001", 1000.0);
            compteCommun.getClients().add(client1);
            compteCommun.getClients().add(client2);
            client1.getComptes().add(compteCommun);
            client2.getComptes().add(compteCommun);

            // 2. Insérer un client avec plusieurs comptes :
            //    - 1 compte de type AssuranceVie
            //    - 1 compte de type LivretA
            AssuranceVie assuranceVie = new AssuranceVie("AV-0001", 5000.0,
                    LocalDate.now().plusYears(5), 1.8);
            LivretA livretA = new LivretA("LA-0001", 2000.0, 1.2);

            assuranceVie.getClients().add(client3);
            livretA.getClients().add(client3);
            client3.getComptes().add(assuranceVie);
            client3.getComptes().add(livretA);

            // 3. Insérer des opérations de type virements sur un compte
            Virement virement1 = new Virement(LocalDateTime.now(), -200.0,
                    "Virement loyer", "Propriétaire");
            Virement virement2 = new Virement(LocalDateTime.now(), 300.0,
                    "Virement salaire", "Employeur");
            virement1.setCompte(compteCommun);
            virement2.setCompte(compteCommun);
            compteCommun.getOperations().add(virement1);
            compteCommun.getOperations().add(virement2);

            // 4. Insérer des opérations \"simples\" sur un compte
            Operation op1 = new Operation(LocalDateTime.now(), -50.0, "Retrait DAB");
            Operation op2 = new Operation(LocalDateTime.now(), -20.0, "Commission");
            op1.setCompte(compteCommun);
            op2.setCompte(compteCommun);
            compteCommun.getOperations().add(op1);
            compteCommun.getOperations().add(op2);

            // Persistance explicite (pas de cascade configurée)
            em.persist(banque);
            em.persist(client1);
            em.persist(client2);
            em.persist(client3);

            em.persist(compteCommun);
            em.persist(assuranceVie);
            em.persist(livretA);

            em.persist(virement1);
            em.persist(virement2);
            em.persist(op1);
            em.persist(op2);

            em.getTransaction().commit();
        }

    }
}
