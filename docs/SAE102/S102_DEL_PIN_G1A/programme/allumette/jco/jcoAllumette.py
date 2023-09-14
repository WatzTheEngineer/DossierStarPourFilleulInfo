from random import randint

from programme.allumette.jcj.jcjAllumette import affichageAllumette, saisieAllumette
from programme.joueur.joueur import Joueur
from programme.utile.ConfirmRetour import confirmRetour
from programme.utile.colorfull import TEXTCOLOR
from programme.utile.mrPropre import mrPropre


def ordiFacile(nb_allumette) -> int:
    """Choisit combien d'allumettes seront retirées par le bot niveau facile

    Args:
        nb_allumette: Nombnre d'allumettes restantes

    Returns:
        Entier choisi par le bot
    """
    if nb_allumette >= 3:
        return randint(1, 3)
    elif nb_allumette <= 2:
        return randint(1, nb_allumette)


def ordiDifficile(nb_allumette) -> int:
    """Choisit combien d'allumettes seront retirées par le bot niveau difficile

    Args:
        nb_allumette: Nombnre d'allumettes restantes

    Returns:
        Entier choisi par le bot
    """
    if nb_allumette == 20:
        return 3
    elif 1 < nb_allumette <= 4:
        return nb_allumette - 1
    else:
        for i in range(1, 4):
            if ((nb_allumette - i) % 4) == 1:
                return i
        return 1


def tourOrdi(joueur: Joueur, ordi):
    """Procédure gérant une partie d'Allumette en JcO

    Args:
        joueur: Joueur jouant contre l'ordinateur
        ordi: Ordinateur jouant contre le joueur

    """
    nb_allumette: int = 20
    gagnant: bool = False

    while nb_allumette > 0:
        print(affichageAllumette(20, nb_allumette))
        print("Il reste", nb_allumette, "allumettes\n")
        print(TEXTCOLOR.BLUE+"C'est au tour de l'ordi de jouer"+TEXTCOLOR.DEFAULT)
        nb_allumette -= ordi(nb_allumette)
        gagnant = False

        if nb_allumette > 0:
            print(affichageAllumette(20, nb_allumette))
            print("Il reste", nb_allumette, "allumettes\n")
            print(TEXTCOLOR.BLUE+"C'est à votre tour de jouer"+TEXTCOLOR.DEFAULT)
            nb_allumette -= saisieAllumette(joueur)
            gagnant = True
            mrPropre()
        mrPropre()

    if gagnant:
        print(TEXTCOLOR.GREEN+"L'ordinateur à gagné"+TEXTCOLOR.DEFAULT)
    else:
        print(TEXTCOLOR.GREEN+"Vous avez gagné"+TEXTCOLOR.DEFAULT)

    confirmRetour()
