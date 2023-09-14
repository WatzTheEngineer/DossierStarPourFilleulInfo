from programme.morpion.fonctionMorpion import *
from programme.morpion.tourMorpion import tourMorpion
from programme.utile.colorfull import *


def jeuMorpion(joueur1: Joueur, joueur2: Joueur):
    """Procédure gérant une partie de Morpion

    Args:
        joueur1 (Joueur): Joueur 1
        joueur2 (Joueur): Joueur 2
    """
    pseudo: str = ""

    while pseudo != joueur1.pseudo and pseudo != joueur2.pseudo:
        pseudo = input("Entrez le pseudo du joueur qui commence : ")

        if pseudo != joueur1.pseudo and pseudo != joueur2.pseudo:
            print(TEXTFORM.WARNING + "Pseudo inconnu" + TEXTFORM.DEFAULT)

    if pseudo == joueur1.pseudo:
        tourMorpion(joueur1, joueur2)
    else:
        tourMorpion(joueur2, joueur1)
