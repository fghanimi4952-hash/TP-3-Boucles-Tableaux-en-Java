import java.util.Scanner;

/**
 * Exercice 2 : Affichage d'un triangle isocèle formé d'étoiles
 * La dernière ligne du triangle s'affiche sur le bord gauche de l'écran
 */
public class Exercice2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Entrez la hauteur du triangle (nombre de lignes) : ");
            int hauteur = scanner.nextInt();
            
            if (hauteur <= 0) {
                System.out.println("Erreur : la hauteur doit être strictement positive.");
                return;
            }
            
            // Affichage du triangle isocèle
            // Pour la ligne i (0-indexée), on affiche (2*i+1) étoiles
            for (int i = 0; i < hauteur; i++) {
                int nombreEtoiles = 2 * i + 1;
                for (int j = 0; j < nombreEtoiles; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}

