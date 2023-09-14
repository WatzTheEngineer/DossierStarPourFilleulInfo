from programme.devinette.jcj.tourDeJeu import tourDeJeu
from programme.joueur.joueur import Joueur
from programme.utile.ConfirmRetour import confirmRetour
from programme.utile.colorfull import *
from programme.utile.mrPropre import mrPropre
from programme.utile.saisieNombre import saisieInt
from programme.utile.score import incrementScore


def jeuDevinette(joueur1: Joueur, joueur2: Joueur):
    """Procédure gérant le jeu Devinette en JcJ

    Args:
        joueur1 (Joueur): Premier joueur
        joueur2 (Joueur): Second joueur
    """
    compt_j1: int
    compt_j2: int

    mrPropre()
    print(TEXTFORM.BOLD + "Bienvenue dans le jeu de la devinette\n" + TEXTFORM.DEFAULT)

    borne: int = saisieBorne(joueur1)
    compt_j2 = tourDeJeu(joueur1, joueur2, borne)

    print("\n" + joueur1.pseudo + ", à vous de deviner le nombre que", joueur2.pseudo, "a choisi\n")

    compt_j1 = tourDeJeu(joueur2, joueur1, borne)

    if compt_j1 < compt_j2:
        print("\n" + TEXTCOLOR.GREEN + joueur1.pseudo + ", vous avez gagné !" + TEXTCOLOR.DEFAULT + "\n")
        incrementScore(joueur1, "devinette")  # Ajout d'un point
    elif compt_j1 > compt_j2:
        print("\n" + TEXTCOLOR.GREEN + joueur2.pseudo + ", vous avez gagné !" + TEXTCOLOR.DEFAULT + "\n")
        incrementScore(joueur2, "devinette")  # Ajout d'un point
    else:
        print("\n" + TEXTCOLOR.YELLOW + "Match nul" + TEXTCOLOR.DEFAULT + "\n")

    confirmRetour()


def saisieBorne(joueur):
    """Fonction gérant la saisie de la borne maximale

    Args:
        joueur: Joueur fixant la borne

    Returns:
        Borne choisie par le joueur
    """
    borne: int = 0
    while borne <= 1:  # Saisie et vérification de la borne
        borne = saisieInt(joueur.pseudo + " entrez la borne superieure à 1 : ",
                          "Erreur de saisie\n Le nombre doit etre superieur à 1.")

    return borne
