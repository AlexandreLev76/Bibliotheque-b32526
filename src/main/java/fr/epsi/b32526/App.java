package fr.epsi.b32526;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    public static void main(String[] args) {
        try (
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("BibliothequePU");
                EntityManager em = emf.createEntityManager();
        ) {
        /* TP2
            em.getTransaction().begin();

            //Réaliser un « find » simple permettant d’extraire un livre en fonction de son identifiant et affichez son titre et son auteur
            Livre Voirlivre = em.find(Livre.class, 1);
                if (Voirlivre != null) {
                    System.out.println("Livre trouvé: " + Voirlivre.getTitre() + " by " + Voirlivre.getAuteur());
                } else {
                    System.out.println("Le livre n'est pas la");
                }

            //Insérer un nouveau Livre de votre choix en base de données
            Livre nouveauLivre = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry");
            em.persist(nouveauLivre);

            //Modifier le titre du livre dont l’identifiant est 5 qui possède une erreur :
            //le nouveau titre doit être « Du plaisir dans la cuisine » au lieu de « 1001 recettes de Cuisine »
            Livre livreAModifier = em.find(Livre.class, 5);
            if (livreAModifier != null) {
                livreAModifier.setTitre("Du plaisir dans la cuisine");
            } else {
                System.out.println("Il est pas la");
            }

            // Faire une requête JPQL pour extraire de la base un livre en fonction de son titre
            String titreRecherche = "Le Petit Prince";
            Livre livreTrouve = em.createQuery("SELECT l FROM Livre l WHERE l.titre = :titre", Livre.class)
                    .setParameter("titre", titreRecherche)
                    .getSingleResult();
            if (livreTrouve != null) {
                System.out.println("Livre trouvé: " + livreTrouve.getTitre() + " by " + livreTrouve.getAuteur());
            } else {
                System.out.println("Toujours pas la");
            }

            // Faire une requête JPQL pour extraire de la base un livre en fonction de son auteur
            String AuteurRecherche = "Antoine de Saint-Exupéry";
            Livre livreTrouve2 = em.createQuery("SELECT l FROM Livre l WHERE l.auteur = :auteur", Livre.class)
                    .setParameter("auteur", AuteurRecherche)
                    .getSingleResult();
            if (livreTrouve2 != null) {
                System.out.println("Livre trouvé: " + livreTrouve2.getTitre() + " by " + livreTrouve2.getAuteur());
            } else {
                System.out.println("Et non pas la");
            }

            // Supprimer un livre de votre choix en base de données
            Livre livreASupprimer = em.find(Livre.class, 2);
            if (livreASupprimer != null) {
                em.remove(livreASupprimer);
            } else {
                System.out.println("Il est pas la");
            }

            // Afficher la liste de tous les livres présents en base de données (titre et auteur)
            System.out.println("Liste de tous les livres :");
            em.createQuery("SELECT l FROM Livre l", Livre.class)
                    .getResultList()
                    .forEach(livre -> System.out.println(livre.getTitre() + " by " + livre.getAuteur()));
            em.getTransaction().commit();
        */


        }
    }
}