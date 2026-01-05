# TP 3 : Boucles & Tableaux en Java

Ce projet contient 6 exercices sur les boucles et les tableaux en Java.

## Structure du projet

- `Exercice1.java` : Calcul de la somme de la série harmonique
- `Exercice2.java` : Affichage d'un triangle isocèle d'étoiles
- `Exercice3.java` : Tableau des carrés des nombres impairs
- `Exercice4.java` : Classe utilitaire pour tableaux 2D
- `Exercice5.java` : Rotation en place d'une matrice N×N
- `Exercice6.java` : Fenêtre glissante - valeurs distinctes

## Compilation et exécution

Pour compiler un exercice :
```bash
javac ExerciceX.java
```

Pour exécuter un exercice :
```bash
java ExerciceX
```

## Exercice 1 : Série harmonique

**Objectif** : Calculer la somme des n premiers termes de la série harmonique.

**Formule** : 1 + 1/2 + 1/3 + 1/4 + ... + 1/n

**Exemple d'utilisation** :
```
Entrez la valeur de n : 5
La somme des 5 premiers termes de la série harmonique est : 2.283333333333333
```

## Exercice 2 : Triangle isocèle

**Objectif** : Afficher un triangle isocèle formé d'étoiles.

**Exemple d'utilisation** (pour 4 lignes) :
```
Entrez la hauteur du triangle (nombre de lignes) : 4
*
***
*****
*******
```

## Exercice 3 : Carrés des nombres impairs

**Objectif** : Créer un tableau contenant les carrés des n premiers nombres impairs.

**Exemple d'utilisation** :
```
Combien de valeurs : 5
1 a pour carre 1
3 a pour carre 9
5 a pour carre 25
7 a pour carre 49
9 a pour carre 81
```

## Exercice 4 : Classe utilitaire tableaux 2D

**Objectif** : Réaliser une classe utilitaire avec des méthodes statiques pour manipuler des tableaux 2D de `double`.

**Méthodes disponibles** :
- `affiche(double[][] t)` : Affiche les valeurs du tableau 2D
- `regulier(double[][] t)` : Teste si le tableau est régulier (toutes les lignes ont la même taille)
- `sommeLignes(double[][] t)` : Renvoie un tableau contenant les sommes des différentes lignes
- `somme(double[][] t1, double[][] t2)` : Renvoie la somme de deux tableaux réguliers de mêmes dimensions, ou `null` sinon

**Exemple d'utilisation** :
Le programme de test inclus dans la classe démontre l'utilisation de toutes les méthodes.

## Exercice 5 : Rotation en place d'une matrice

**Objectif** : Faire pivoter une matrice carrée N×N de 90° dans le sens horaire, sans utiliser de second tableau (mémoire O(1)).

**Contraintes** :
- N ∈ [2, 200]
- Uniquement des boucles et des tableaux
- Pas de listes, pas de Maps, pas de récursion

**Méthodes implémentées** :
- `rotate90ClockwiseInPlace(int[][] A)` : Rotation 90° horaire (méthode conseillée : transposition + renversement)
- `rotate90ClockwiseInPlaceByLayers(int[][] A)` : Rotation 90° horaire (méthode bonus : par couches)
- `rotate90CounterClockwiseInPlace(int[][] A)` : Rotation 90° anti-horaire (bonus)
- `rotate180InPlace(int[][] A)` : Rotation 180° (bonus)

**Exemple d'utilisation** :
```
Entrez la taille de la matrice (N) : 4
Entrez les 4 lignes de 4 entiers :
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

Matrice originale :
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

Matrice après rotation 90° horaire :
13 9 5 1
14 10 6 2
15 11 7 3
16 12 8 4
```

## Exercice 6 : Fenêtre glissante - valeurs distinctes

**Objectif** : Pour un tableau d'entiers T de taille n et une fenêtre de taille k, calculer pour chaque position de la fenêtre le nombre d'éléments distincts dans cette fenêtre, en O(n).

**Contraintes** :
- 1 ≤ k ≤ n ≤ 100000
- Les valeurs de T sont dans [0..100000]
- Uniquement des boucles et des tableaux (pas de Set/Map)

**Complexité** : O(n + MAXV) pour l'initialisation + balayage

**Exemple d'utilisation** :
```
8 4
1 2 2 3 2 1 4 2
3 2 4 4 3
```

**Explication** :
- Fenêtre [1 2 2 3] → 3 distincts (1, 2, 3)
- Fenêtre [2 2 3 2] → 2 distincts (2, 3)
- Fenêtre [2 3 2 1] → 4 distincts (1, 2, 3, 4)
- Fenêtre [3 2 1 4] → 4 distincts (1, 2, 3, 4)
- Fenêtre [2 1 4 2] → 3 distincts (1, 2, 4)

## Notes techniques

- Tous les exercices utilisent uniquement des boucles et des tableaux
- Aucune structure de données avancée (Set, Map, List) n'est utilisée
- Les exercices incluent des validations d'entrée de base
- Les exercices 5 et 6 sont optimisés pour la complexité temporelle et spatiale

## Auteur

TP 3 - MLIAEdu - S3

