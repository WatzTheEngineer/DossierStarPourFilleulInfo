from programme.joueur.joueur import Joueur
from programme.puissance4.fonctionPuissance4 import tourPuissance4
from programme.utile.colorfull import TEXTCOLOR


def jeuPuissance4(joueur1: Joueur, joueur2: Joueur, ):
    """Fonction gérant une partie de puissance 4 entre deux joueurs

    Args:
        joueur1 (Joueur): Premier joueur
        joueur2 (Joueur): Second joueur
    """

    pseudo: str = ''

    print(TEXTCOLOR.CYAN + "Jeu Puissance 4" + TEXTCOLOR.DEFAULT)

    while pseudo != joueur1.pseudo and pseudo != joueur2.pseudo:
        pseudo = input("Entrez le pseudo du joueur qui commence : ")

    if pseudo == joueur1.pseudo:  # Tour du premier joueur
        tourPuissance4(joueur1, joueur2)

    if pseudo == joueur2.pseudo:  # Tour du second joueur
        tourPuissance4(joueur2, joueur1)
