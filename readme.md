# Jeu de la vie

## Description
Ce projet à été réalisé sous maven avec Java 17 dans le cadre des études en M1 à Sup de Vinci.


> Le jeu de la vie est un automate cellulaire imaginé par John Horton Conway en 1970. Il est composé d'une grille de cellules carrées, qui peuvent être soit vivantes, soit mortes. L'état de chaque cellule évolue à chaque itération en fonction de l'état des cellules voisines. Le jeu de la vie est un exemple de jeu à zéro joueur, c'est-à-dire qu'il ne nécessite aucune interaction de la part de l'utilisateur.

## Règles du jeu

Le jeu de la vie se joue sur une grille de cellules carrées, qui peuvent être soit vivantes, soit mortes, chaque cellule ayant exactement huit voisins. Les cellules interagissent entre elles selon quatre règles simples, qui se répètent à chaque itération :

-Toute cellule vivante ayant exactement deux ou trois voisines vivantes survit pour la génération suivante.
* Toute cellule morte ayant exactement trois voisines vivantes devient une cellule vivante.
* Toute cellule vivante ayant moins de deux voisines vivantes meurt, en sous-population.
* Toute cellule vivante ayant plus de trois voisines vivantes meurt, en surpopulation.

## Installation
### Prérequis
- Java 17
- Junit 5
- Maven
- IDE (IntelliJ, Eclipse, Netbeans, etc.)

### Mise en place

1. Cloner le projet
2. Ouvrir le projet dans l'IDE
3. Lancer le projet à partir de la classe JeuDeLaVie.java

### Tests
Plusieurs tests unitaires ont été réalisés pour vérifier le bon fonctionnement du programme. Pour les lancer, il suffit de lancer la commande suivante dans le terminal :
```bash
mvn test
```

## Auteurs
- [Raphaël Saint-Alme](https://github.com/RaphaelStAlme)

## License
[GPL-3.0](https://choosealicense.com/licenses/gpl-3.0/)





