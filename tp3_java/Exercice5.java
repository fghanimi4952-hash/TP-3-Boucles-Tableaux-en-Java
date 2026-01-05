import java.util.Scanner;

/**
 * Exercice 5 : Rotation en place d'une matrice N×N de 90° dans le sens horaire
 * Mémoire O(1) - pas de second tableau
 */
public class Exercice5 {
    
    /**
     * Méthode 1 (conseillée) : Transposition puis renversement des lignes
     * Rotation 90° horaire = Transposition + Renversement des lignes
     */
    public static void rotate90ClockwiseInPlace(int[][] A) {
        int N = A.length;
        
        // Étape 1 : Transposition (échanger A[i][j] et A[j][i] pour i < j)
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        
        // Étape 2 : Renverser chaque ligne (échanger A[i][j] et A[i][N-1-j])
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][N - 1 - j];
                A[i][N - 1 - j] = temp;
            }
        }
    }
    
    /**
     * Méthode 2 (bonus) : Rotation par couches (anneaux)
     * Échange 4 éléments à la fois pour chaque "anneau"
     */
    public static void rotate90ClockwiseInPlaceByLayers(int[][] A) {
        int N = A.length;
        
        // Pour chaque couche (anneau) de la matrice
        for (int couche = 0; couche < N / 2; couche++) {
            int premier = couche;
            int dernier = N - 1 - couche;
            
            // Pour chaque élément dans la couche actuelle
            for (int i = premier; i < dernier; i++) {
                int offset = i - premier;
                
                // Sauvegarder le premier élément
                int temp = A[premier][i];
                
                // Déplacer de gauche vers haut
                A[premier][i] = A[dernier - offset][premier];
                
                // Déplacer de bas vers gauche
                A[dernier - offset][premier] = A[dernier][dernier - offset];
                
                // Déplacer de droite vers bas
                A[dernier][dernier - offset] = A[i][dernier];
                
                // Déplacer de haut vers droite
                A[i][dernier] = temp;
            }
        }
    }
    
    /**
     * Bonus : Rotation 90° dans le sens anti-horaire
     * Rotation 90° anti-horaire = Renversement des lignes + Transposition
     */
    public static void rotate90CounterClockwiseInPlace(int[][] A) {
        int N = A.length;
        
        // Étape 1 : Renverser chaque ligne
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][N - 1 - j];
                A[i][N - 1 - j] = temp;
            }
        }
        
        // Étape 2 : Transposition
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
    }
    
    /**
     * Bonus : Rotation 180°
     * Rotation 180° = Renverser toutes les lignes puis renverser toutes les colonnes
     * Ou simplement : échanger A[i][j] avec A[N-1-i][N-1-j]
     */
    public static void rotate180InPlace(int[][] A) {
        int N = A.length;
        
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N; j++) {
                int temp = A[i][j];
                A[i][j] = A[N - 1 - i][N - 1 - j];
                A[N - 1 - i][N - 1 - j] = temp;
            }
        }
        
        // Si N est impair, il faut aussi renverser la ligne du milieu
        if (N % 2 == 1) {
            int milieu = N / 2;
            for (int j = 0; j < milieu; j++) {
                int temp = A[milieu][j];
                A[milieu][j] = A[milieu][N - 1 - j];
                A[milieu][N - 1 - j] = temp;
            }
        }
    }
    
    /**
     * Affiche la matrice (une ligne par rangée, éléments séparés par un espace)
     */
    public static void afficherMatrice(int[][] A) {
        int N = A.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(A[i][j]);
                if (j < N - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Lire N
            System.out.print("Entrez la taille de la matrice (N) : ");
            int N = scanner.nextInt();
            
            if (N < 2 || N > 200) {
                System.out.println("Erreur : N doit être entre 2 et 200.");
                return;
            }
            
            // Lire la matrice
            int[][] matrice = new int[N][N];
            System.out.println("Entrez les " + N + " lignes de " + N + " entiers :");
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrice[i][j] = scanner.nextInt();
                }
            }
            
            System.out.println("\nMatrice originale :");
            afficherMatrice(matrice);
            
            // Rotation 90° horaire
            rotate90ClockwiseInPlace(matrice);
            
            System.out.println("\nMatrice après rotation 90° horaire :");
            afficherMatrice(matrice);
        }
    }
}

