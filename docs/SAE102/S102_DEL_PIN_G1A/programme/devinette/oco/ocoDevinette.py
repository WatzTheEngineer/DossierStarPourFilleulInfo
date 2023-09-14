from programme.devinette.jcj.jeuDevinette import saisieBorne
from programme.devinette.jcj.tourDeJeu import nbTrouve
from programme.devinette.jco.difficile.tourOrdiDifficile import ordiDifficile
from programme.devinette.jco.facile.tourOrdiFacile import ordiFacile
from programme.joueur.joueur import Joueur
from programme.utile.ConfirmRetour import confirmRetour
from programme.utile.colorfull import TEXTCOLOR
from programme.utile.mrPropre import mrPropre


def ocoDevinette(joueur: Joueur):
    """Procedure qui permet de se faire s'affronter deux ordinateur à Devinette

    Args:
        joueur: Joueur saisissant la borne pour les deux bots

    """

    nb_coupbot1: int
    nb_coupbot2: int
    borne: int = saisieBorne(joueur)
    nombre_a_trouver: int = nbTrouve(joueur, borne)

    print("Au tour de l'ordinateur 1")
    nb_coupbot1 = tourOco(nombre_a_trouver, borne, ordiFacile)
    print("L'ordinateur 1 à trouvé en ", nb_coupbot1, "coups")

    print("Au tour de l'ordinateur 2")
    nb_coupbot2 = tourOco(nombre_a_trouver, borne, ordiDifficile)
    print("L'ordinateur 2 à trouvé en ", nb_coupbot2, "coups")

    if nb_coupbot1 < nb_coupbot2:
        print(TEXTCOLOR.GREEN + "L'ordinateur 1 à gagné en ", nb_coupbot1, "coups" + TEXTCOLOR.DEFAULT)
    elif nb_coupbot1 > nb_coupbot2:
        print(TEXTCOLOR.GREEN + "L'ordinateur 2 à gagné en ", nb_coupbot2, "coups" + TEXTCOLOR.DEFAULT)
    else:
        print("Egalité")

    confirmRetour()
    mrPropre()


def tourOco(nb_a_trouver, maxi, ordi):
    """Fonction gérant un tour de Devinette en OcO

    Args:
        nb_a_trouver: Nombre caché
        maxi: Nombre maximum limite
        ordi: Ordinateur jouant ce tour

    Returns:

    """
    nb_coup: int = 0
    mini: int = 1
    prop: int = 0

    while prop != nb_a_trouver:
        nb_coup += 1
        prop = ordi(mini, maxi)

        print("L'ordinateur à choisit ", prop)

        if prop > nb_a_trouver:
            print(prop, "est trop grand")
            maxi = prop - 1
        elif prop < nb_a_trouver:
            print(prop, "est trop petit")
            mini = prop + 1
        confirmRetour()
        mrPropre()
    return nb_coup
