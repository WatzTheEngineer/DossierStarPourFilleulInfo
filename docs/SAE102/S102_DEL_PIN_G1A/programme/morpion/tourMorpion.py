from programme.joueur.joueur import Joueur
from programme.morpion.fonctionMorpion import pionAligne, affichePlateau, saisieX, saisieY, plateauPlein
from programme.utile.ConfirmRetour import confirmRetour
from programme.utile.colorfull import *
from programme.utile.mrPropre import mrPropre
from programme.utile.score import incrementScore


def tourMorpion(joueur1: Joueur, joueur2: Joueur):
    """Procédure gérant un tour de morpion

    Args:
        joueur1 (Joueur): Joueur 1
        joueur2 (Joueur): Joueur 2
    """

    mrPropre()

    plateau: list[list[str]] = [  # Définition du plateau
        ["-", "-", "-"], ["-", "-", "-"], ["-", "-", "-"]]
    x: int
    y: int
    pion: str
    aligne: bool
    plein: bool
    boolstate: str

    affichePlateau(plateau)  # Premier affichage

    while True:
        while True:  # On joue tant qu'il n'y a pas de victoire ou d'égalité
            x = saisieX(joueur1)
            y = saisieY(joueur1)
            if plateau[x][y] == "-":
                break
            else:
                print("Case déjà prise")
        plateau[x][y] = "X"
        boolstate, pion = pionAligne(plateau)
        aligne = eval(boolstate)
        plein = plateauPlein(plateau)
        affichePlateau(plateau)
        if aligne or plein:
            break
        while True:
            x = saisieX(joueur2)
            y = saisieY(joueur2)
            if plateau[x][y] == "-":
                break
            else:
                print(TEXTFORM.WARNING + "Case déjà prise" + TEXTFORM.DEFAULT)
        plateau[x][y] = "O"
        boolstate, pion = pionAligne(plateau)
        aligne = eval(boolstate)
        plein = plateauPlein(plateau)
        affichePlateau(plateau)
        if aligne or plein:
            break

    if pion == "X":
        print(TEXTCOLOR.GREEN + "\n" + joueur1.pseudo +
              " a gagné !" + TEXTCOLOR.DEFAULT + "\n")
        incrementScore(joueur1, "morpion")
    elif pion == "O":
        print(TEXTCOLOR.GREEN + "\n" + joueur2.pseudo +
              " a gagné !" + TEXTCOLOR.DEFAULT + "\n")
        incrementScore(joueur2, "morpion")
    elif plein:
        print("\n" + TEXTCOLOR.YELLOW + "Match nul" + TEXTCOLOR.DEFAULT + "\n")

    confirmRetour()
