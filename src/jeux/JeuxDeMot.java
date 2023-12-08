/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jeux;

import java.util.Scanner;
/**
 * JeuxDeMot est un jeu où l'utilisateur doit deviner un mot de 7 lettres.
 * Le programme affiche des indices pour aider l'utilisateur à trouver le mot.
 *
 * @author imino
 */
public class JeuxDeMot {

    /**
     *
     * @param args Les arguments de la ligne de commande (non utilisés ici).
     */
    public static void main(String[] args) {

        // Initialisation du scanner pour la saisie utilisateur.
        Scanner in = new Scanner(System.in);

        // Codes de couleur pour la mise en forme du texte dans la console.
        final String BG_RED = "\u001B[31m";
        final String BG_YELLOW = "\u001B[43m";
        final String BG_BLUE = "\u001B[34m";

        // Tableau de mots de 7 lettres.
        String words[] = {"GRIEVES", "GROOMED", "GRANTED", "GRIZZLY"};

        // Sélection aléatoire d'un mot dans le tableau.
        int index = (int) (Math.random() * words.length);
        String word = words[index];
        String userGuess;
        int round;

        // Boucle principale du jeu, limitée à 5 essais.
        for (round = 0; round < 5; round++) {

            // Demande à l'utilisateur de saisir un mot de 7 lettres.
            do {
                try {
                    System.out.println("Entrez votre mot de 7 lettres : ");
                    userGuess = in.nextLine().toUpperCase();

                    // Vérification de la longueur du mot saisi.
                    if (userGuess.length() != 7) {
                        throw new IllegalArgumentException("Le mot doit avoir exactement 7 lettres.");
                    }

                    // Comparaison des lettres du mot saisi avec le mot à deviner.
                    for (int i = 0; i < 7; i++) {
                        if (userGuess.substring(i, i + 1).equals(word.substring(i, i + 1))) {
                            // Lettre correcte à la bonne position.
                            System.out.print(BG_RED + userGuess.substring(i, i + 1) + BG_BLUE);
                        } else if (word.contains(userGuess.substring(i, i + 1))) {
                            // Lettre correcte, mais à la mauvaise position.
                            System.out.print(BG_YELLOW + userGuess.substring(i, i + 1) + BG_BLUE);
                        } else {
                            // Lettre incorrecte.
                            System.out.print(userGuess.substring(i, i + 1) + BG_BLUE);
                        }
                    }
                    System.out.println();

                    // Vérification de la victoire de l'utilisateur.
                    if (userGuess.equals(word)) {
                        System.out.println("CORRECT, VOUS AVEZ GAGNE !");
                        return; // Sort de la méthode en cas de victoire.
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (true); // Répète la boucle jusqu'à ce que la saisie soit valide.
        }

        // Affichage du message de défaite si l'utilisateur n'a pas deviné le mot en 5 essais.
        System.out.println("Vous avez perdu. Le mot était : " + word);
    }
}
