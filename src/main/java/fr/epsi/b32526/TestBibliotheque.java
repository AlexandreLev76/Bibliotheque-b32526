package fr.epsi.b32526;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestBibliotheque {

    public static void main(String[] args) {

        /* TP3
         * Réalisez une requête qui permet d'extraire un emprunt et tous ses livres associés
         * Réalisez une requête qui permet d'extraire tous les emprunts d'un client donné
         * JPQL
         */
//        try (
//                EntityManagerFactory emf = Persistence.createEntityManagerFactory("BibliothequePU");
//                EntityManager em = emf.createEntityManager();
//        ) {
//            em.getTransaction().begin();
//
//            // Réalisez une requête qui permet d'extraire un emprunt et tous ses livres associés
//            int idEmprunt = 1;
//            Emprunt emprunt = em.createQuery(
//                            "SELECT e FROM Emprunt e LEFT JOIN FETCH e.livres WHERE e.id = :id",
//                            Emprunt.class)
//                    .setParameter("id", idEmprunt)
//                    .getSingleResult();
//            if (emprunt != null) {
//                System.out.println("Emprunt " + emprunt.getId() + " - Livres : ");
//                emprunt.getLivres().forEach(l -> System.out.println("  - " + l.getTitre() + ", " + l.getAuteur()));
//            } else {
//                System.out.println("L'emprunt n'est pas trouvé.");
//            }
//
//            // Réalisez une requête qui permet d'extraire tous les emprunts d'un client donné
//            int idClient = 1;
//            List<Emprunt> empruntsDuClient = em.createQuery(
//                            "SELECT e FROM Emprunt e WHERE e.client.id = :idClient",
//                            Emprunt.class)
//                    .setParameter("idClient", idClient)
//                    .getResultList();
//            System.out.println("Emprunts du client " + idClient + " : " + empruntsDuClient.size());
//            empruntsDuClient.forEach(e -> System.out.println("  - Emprunt id=" + e.getId()));
//
//            em.getTransaction().commit();
//        }

        /* TP3
         * Réalisez une requête qui permet d'extraire un emprunt et tous ses livres associés
         * Réalisez une requête qui permet d'extraire tous les emprunts d'un client donné
         * JPA
         */
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("BibliothequePU");
             EntityManager em = emf.createEntityManager();) {

            em.getTransaction().begin();

            Emprunt emprunt = em.find(Emprunt.class, 1);
            if (emprunt != null) {
                System.out.println("Emprunt " + emprunt.getId() + " - Livres : ");
                emprunt.getLivres().forEach(l -> System.out.println("  - " + l.getTitre() + ", " + l.getAuteur()));
            } else {
                System.out.println("L'emprunt n'est pas trouvé.");
            }

            Client client = em.find(Client.class, 1);
            if (client != null) {
                System.out.println("Emprunts du client " + client.getId() + " : " + client.getEmprunts().size());
                client.getEmprunts().forEach(e -> System.out.println("  - Emprunt id=" + e.getId()));
            } else {
                System.out.println("Le client n'est pas trouvé.");
            }
            em.getTransaction().commit();

        }
    }
}
