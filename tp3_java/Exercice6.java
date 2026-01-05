import java.util.Scanner;

/**
 * Exercice 6 : Fenêtre glissante - nombre de valeurs distinctes par fenêtre
 * Complexité : O(n) avec uniquement des boucles et des tableaux
 */
public class Exercice6 {
    private static final int MAXV = 100000;
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Lire n et k
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            
            if (k < 1 || k > n || n > 100000) {
                System.out.println("Erreur : contraintes non respectées (1 ≤ k ≤ n ≤ 100000).");
                return;
            }
            
            // Lire le tableau T
            int[] T = new int[n];
            for (int i = 0; i < n; i++) {
                T[i] = scanner.nextInt();
                if (T[i] < 0 || T[i] > MAXV) {
                    System.out.println("Erreur : les valeurs doivent être dans [0..100000].");
                    return;
                }
            }
            
            // Tableau de fréquences
            int[] freq = new int[MAXV + 1];
            int distinct = 0;
            
            // Initialiser la première fenêtre [0..k-1]
            for (int i = 0; i < k; i++) {
                int x = T[i];
                freq[x]++;
                // Si c'est la première occurrence, incrémenter distinct
                if (freq[x] == 1) {
                    distinct++;
                }
            }
            
            // Afficher le résultat pour la première fenêtre
            System.out.print(distinct);
            
            // Glisser la fenêtre d'un cran vers la droite pour chaque i de k à n-1
            for (int i = k; i < n; i++) {
                // Retirer l'élément sortant : T[i-k]
                int out = T[i - k];
                freq[out]--;
                // Si l'élément n'apparaît plus, décrémenter distinct
                if (freq[out] == 0) {
                    distinct--;
                }
                
                // Ajouter l'élément entrant : T[i]
                int in = T[i];
                freq[in]++;
                // Si c'est une nouvelle occurrence, incrémenter distinct
                if (freq[in] == 1) {
                    distinct++;
                }
                
                // Afficher le résultat pour cette fenêtre
                System.out.print(" " + distinct);
            }
            
            System.out.println();
        }
    }
}

