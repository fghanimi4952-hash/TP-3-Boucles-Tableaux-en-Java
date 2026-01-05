import java.util.Scanner;

/**
 * Exercice 1 : Calcul de la somme des n premiers termes de la série harmonique
 * Série harmonique : 1 + 1/2 + 1/3 + 1/4 + ... + 1/n
 */
public class Exercice1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Entrez la valeur de n : ");
            int n = scanner.nextInt();
            
            if (n <= 0) {
                System.out.println("Erreur : n doit être strictement positif.");
                return;
            }
            
            double somme = 0.0;
            
            // Calcul de la somme de la série harmonique
            for (int i = 1; i <= n; i++) {
                somme += 1.0 / i;
            }
            
            System.out.println("La somme des " + n + " premiers termes de la série harmonique est : " + somme);
        }
    }
}

