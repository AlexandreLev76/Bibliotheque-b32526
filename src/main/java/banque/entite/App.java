package banque.entite;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        try (
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("banquePU");
                EntityManager em = emf.createEntityManager();
        ) {
            em.getTransaction().begin();

            Banque banque = new Banque("Banque Populaire");
            em.persist(banque);

            Client client = new Client("Dupont", "Jean", "01/01/1990");
            em.persist(client);

            Compte compte = new Compte("123456789", 1000.0);
            em.persist(compte);

            em.getTransaction().commit();
        }

    }
}
