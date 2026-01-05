import java.util.Scanner;

/**
 * Exercice 4 : Classe utilitaire pour les tableaux de tableaux de double
 */
public class Exercice4 {
    
    /**
     * Affiche les valeurs du tableau 2D, une ligne d'écran pour une ligne du tableau
     */
    public static void affiche(double[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                System.out.print(t[i][j]);
                if (j < t[i].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Teste si le tableau est régulier (toutes les lignes ont la même taille)
     */
    public static boolean regulier(double[][] t) {
        if (t.length == 0) {
            return true; // Tableau vide considéré comme régulier
        }
        
        int taillePremiereLigne = t[0].length;
        for (int i = 1; i < t.length; i++) {
            if (t[i].length != taillePremiereLigne) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Renvoie un tableau contenant les sommes des différentes lignes
     */
    public static double[] sommeLignes(double[][] t) {
        double[] sommes = new double[t.length];
        
        for (int i = 0; i < t.length; i++) {
            double somme = 0.0;
            for (int j = 0; j < t[i].length; j++) {
                somme += t[i][j];
            }
            sommes[i] = somme;
        }
        
        return sommes;
    }
    
    /**
     * Vérifie que t1 et t2 sont réguliers et de mêmes dimensions,
     * puis renvoie leur somme ; sinon renvoie null
     */
    public static double[][] somme(double[][] t1, double[][] t2) {
        // Vérifier que les deux tableaux sont réguliers
        if (!regulier(t1) || !regulier(t2)) {
            return null;
        }
        
        // Vérifier que les dimensions sont identiques
        if (t1.length != t2.length || (t1.length > 0 && t1[0].length != t2[0].length)) {
            return null;
        }
        
        // Calculer la somme
        double[][] resultat = new double[t1.length][];
        for (int i = 0; i < t1.length; i++) {
            resultat[i] = new double[t1[i].length];
            for (int j = 0; j < t1[i].length; j++) {
                resultat[i][j] = t1[i][j] + t2[i][j];
            }
        }
        
        return resultat;
    }
    
    /**
     * Programme de test
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Test 1 : Affichage
        System.out.println("=== Test 1 : Affichage ===");
        double[][] t1 = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
        System.out.println("Tableau t1 :");
        affiche(t1);
        
        // Test 2 : Test de régularité
        System.out.println("\n=== Test 2 : Test de régularité ===");
        double[][] t2 = {{1.0, 2.0}, {3.0, 4.0}, {5.0, 6.0}};
        double[][] t3 = {{1.0, 2.0}, {3.0, 4.0, 5.0}};
        System.out.println("t2 est régulier : " + regulier(t2));
        System.out.println("t3 est régulier : " + regulier(t3));
        
        // Test 3 : Somme des lignes
        System.out.println("\n=== Test 3 : Somme des lignes ===");
        double[] sommes = sommeLignes(t1);
        System.out.print("Sommes des lignes de t1 : ");
        for (int i = 0; i < sommes.length; i++) {
            System.out.print(sommes[i]);
            if (i < sommes.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        
        // Test 4 : Somme de deux tableaux
        System.out.println("\n=== Test 4 : Somme de deux tableaux ===");
        double[][] t4 = {{1.0, 2.0}, {3.0, 4.0}};
        double[][] t5 = {{5.0, 6.0}, {7.0, 8.0}};
        System.out.println("Tableau t4 :");
        affiche(t4);
        System.out.println("Tableau t5 :");
        affiche(t5);
        double[][] somme = somme(t4, t5);
        if (somme != null) {
            System.out.println("Somme t4 + t5 :");
            affiche(somme);
        } else {
            System.out.println("Erreur : les tableaux ne peuvent pas être additionnés.");
        }
        
        // Test avec tableaux incompatibles
        System.out.println("\n=== Test 5 : Tableaux incompatibles ===");
        double[][] resultat = somme(t1, t2);
        if (resultat == null) {
            System.out.println("t1 et t2 ne peuvent pas être additionnés (dimensions différentes).");
        }
        
        scanner.close();
    }
}

