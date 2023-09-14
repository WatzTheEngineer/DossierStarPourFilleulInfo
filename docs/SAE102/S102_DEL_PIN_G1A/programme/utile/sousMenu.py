from programme.allumette.jcj.jcjAllumette import jeuAllumette
from programme.allumette.jco.jcoAllumette import tourOrdi, ordiFacile, ordiDifficile
from programme.allumette.oco.ocoAllumette import ocoAllumette
from programme.devinette.jcj.jeuDevinette import jeuDevinette
from programme.devinette.jco.difficile.tourOrdiDifficile import tourOrdiDifficile
from programme.devinette.jco.facile.tourOrdiFacile import tourOrdiFacile
from programme.devinette.oco.ocoDevinette import ocoDevinette
from programme.joueur.joueur import Joueur
from programme.morpion.jeuMopion import jeuMorpion
from programme.morpion.jeuOrdiMorpion import ordiMorpion
from programme.puissance4.JeuPuissance4 import jeuPuissance4
from programme.utile.ConfirmRetour import confirmRetour
from programme.utile.colorfull import TEXTFORM
from programme.utile.enumJeu import Jeux
from programme.utile.enumRegles import Regles
from programme.utile.mrPropre import mrPropre


def sousMenu(jeu: str, joueur1: Joueur, joueur2: Joueur):
    """Affiche le sous-menu du jeu sélectionné

    Args:
        joueur1: Premier joueur
        joueur2: Second joueur
        jeu (str): Nom du jeu
    """

    choix: str = ""

    while choix != "q":

        mrPropre()

        print("Sous-menu de " + jeu)
        print("1. Jouer")
        print("2. Règles")
        print("q. Retour au menu principal")

        choix = input("Votre choix: ")

        if jeu == Jeux.DEVINETTE.value:
            if choix == "1":
                sousSousMenu(jeu, joueur1, joueur2)
            elif choix == "2":
                print("\n" + Regles.DEVINETTE.value)
                confirmRetour()
            elif choix == "q":
                return
            else:
                print("Choix invalide")

        elif jeu == Jeux.ALLUMETTES.value:
            if choix == "1":
                sousSousMenu(jeu, joueur1, joueur2)
            elif choix == "2":
                print("\n" + Regles.ALLUMETTES.value)
                confirmRetour()
            elif choix == "q":
                return
            else:
                print("Choix invalide")

        elif jeu == Jeux.MORPION.value:
            if choix == "1":
                sousSousMenu(jeu, joueur1, joueur2)
            elif choix == "2":
                print("\n"+Regles.MORPION.value)
                confirmRetour()
            elif choix == "q":
                return
            else:
                print("Choix invalide")

        elif jeu == Jeux.P4.value:
            if choix == "1":
                sousSousMenu(jeu, joueur1, joueur2)
            elif choix == "2":
                print("\n" + Regles.P4.value)
                confirmRetour()
            elif choix == "q":
                return
            else:
                print("Choix invalide")


def sousSousMenu(jeu: str, joueur1: Joueur, joueur2: Joueur):
    """Affiche le sous-sous-menu du jeu sélectionné

    Args:
        joueur1: Premier joueur
        joueur2: Second joueur
        jeu (str): Nom du jeu
    """
    choix: str = ""

    while choix != "q":

        mrPropre()

        print("A quel mode jeu souhaitez-vous jouer ?")
        print("1. Joueur contre joueur")
        print("2. Joueur contre ordinateur")
        print("3. Ordinateur contre ordinateur")
        print("q. Retour")

        choix = input("Votre choix: ")

        if jeu == Jeux.DEVINETTE.value:
            match choix:
                case "1":
                    jeuDevinette(joueur1, joueur2)
                case "2":
                    menuJoueurVsOrdi(joueur1, jeu)
                case "3":
                    ocoDevinette(joueur1)

        elif jeu == Jeux.ALLUMETTES.value:
            match choix:
                case "1":
                    jeuAllumette(joueur1, joueur2)
                case "2":
                    menuJoueurVsOrdi(joueur1, jeu)
                case "3":
                    ocoAllumette(ordiFacile, ordiDifficile)

        elif jeu == Jeux.MORPION.value:

            match choix:

                case "1":

                    jeuMorpion(joueur1, joueur2)

                case "2":

                    menuJoueurVsOrdi(joueur1, jeu)

                case "3":

                    ordiMorpion(None, 40)

                case "4":

                    sousMenu(jeu, joueur1, joueur2)

        elif jeu == Jeux.P4.value:
            match choix:
                case "1":
                    jeuPuissance4(joueur1, joueur2)
                case "2":
                    print(TEXTFORM.WARNING+"\nCette fonctionalité n'est pas encore disponible\n"+TEXTFORM.DEFAULT)
                    confirmRetour()
                case "3":
                    print(TEXTFORM.WARNING + "\nCette fonctionalité n'est pas encore disponible\n" + TEXTFORM.DEFAULT)
                    confirmRetour()
    mrPropre()


def menuJoueurVsOrdi(joueur: Joueur, jeu: str):
    """Affiche le menu pour le mode joueur contre ordinateur

    Args:
        joueur: Joueur affrontant un ordinateur
        jeu (str): Nom du jeu
    """
    choix: str = ""

    while choix != "q":

        mrPropre()

        print("Quel difficulte choisissez-vous ?")
        print("1. Facile")
        print("2. Difficile")
        print("q. Retour")

        choix = input("Votre choix: ")

        if jeu == Jeux.DEVINETTE.value:
            match choix:
                case "1":
                    mrPropre()
                    tourOrdiFacile(joueur)
                case "2":
                    mrPropre()
                    tourOrdiDifficile(joueur)
                case "q":
                    return
        elif jeu == Jeux.ALLUMETTES.value:
            match choix:
                case "1":
                    mrPropre()
                    tourOrdi(joueur, ordiFacile)
                case "2":
                    mrPropre()
                    tourOrdi(joueur, ordiDifficile)
                case "q":
                    return
        elif jeu == Jeux.MORPION.value:
            match choix:
                case "1":
                    mrPropre()
                    ordiMorpion(joueur, 40)
                case "2":
                    mrPropre()
                    ordiMorpion(joueur, 80)
                case "q":
                    return
