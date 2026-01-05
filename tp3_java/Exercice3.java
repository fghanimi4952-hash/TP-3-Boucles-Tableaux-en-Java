import java.util.Scanner;

/**
 * Exercice 3 : Création d'un tableau contenant les carrés des n premiers nombres impairs
 */
public class Exercice3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Combien de valeurs : ");
            int n = scanner.nextInt();
            
            if (n <= 0) {
                System.out.println("Erreur : n doit être strictement positif.");
                return;
            }
            
            // Création du tableau pour stocker les carrés
            int[] carres = new int[n];
            
            // Remplissage du tableau avec les carrés des n premiers nombres impairs
            for (int i = 0; i < n; i++) {
                int nombreImpair = 2 * i + 1;  // 1, 3, 5, 7, 9, ...
                carres[i] = nombreImpair * nombreImpair;
            }
            
            // Affichage au format demandé
            for (int i = 0; i < n; i++) {
                int nombreImpair = 2 * i + 1;
                System.out.println(nombreImpair + " a pour carre " + carres[i]);
            }
        }
    }
}

