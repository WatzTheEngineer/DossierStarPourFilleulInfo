from programme.joueur.joueur import Joueur
from programme.utile.colorfull import *
from programme.utile.enumJeu import Jeux
from programme.utile.mrPropre import mrPropre
from programme.utile.score import menuScore
from programme.utile.sousMenu import sousMenu

if __name__ == '__main__':
    choix: str = ""
    joueur1: Joueur
    joueur2: Joueur
    pseudo: str
    mrPropre()
    pseudo = input("Entrez le pseudo du joueur 1 : ")
    joueur1 = Joueur(pseudo)
    while pseudo == joueur1.pseudo:
        pseudo = input("Entrez le pseudo du joueur 2 : ")
        if pseudo == joueur1.pseudo:  # Le premier pseudo doit être différent du second
            print(TEXTFORM.ERROR + "Ce pseudo est déjà utilisé par le joueur 1" + TEXTFORM.DEFAULT)
    joueur2 = Joueur(pseudo)

    mrPropre()

    while choix != "6":
        print("\n" + TEXTCOLOR.PURPLE + MAINTEXTS.MP + TEXTCOLOR.DEFAULT)
        print("""
    1. Devinette
    2. Allumette
    3. Morpion
    4. Puissance 4
    5. Scores
    6. Quitter
        """)

        choix = input("Faites votre choix : ")

        match choix:
            case "1":
                sousMenu(Jeux.DEVINETTE.value, joueur1, joueur2)
                mrPropre()
            case "2":
                sousMenu(Jeux.ALLUMETTES.value, joueur1, joueur2)
                mrPropre()
            case "3":
                sousMenu(Jeux.MORPION.value, joueur1, joueur2)
                mrPropre()
            case "4":
                sousMenu(Jeux.P4.value, joueur1, joueur2)
                mrPropre()
            case "5":
                menuScore(joueur1, joueur2)
            case "6":
                print("Au revoir\n")
            case _:
                mrPropre()
