from random import randint
from time import sleep

from programme.devinette.jcj.jeuDevinette import saisieBorne
from programme.devinette.jcj.tourDeJeu import nbTrouve
from programme.joueur.joueur import Joueur
from programme.utile.mrPropre import mrPropre
from programme.utile.saisieNombre import saisieInt


def ordiFacile(mini: int, maxi: int) -> int:
    """Fonction qui permet à l'ordinateur de choisir un nombre entre mini et maxi

    Args:
        mini: minimum
        maxi: maximum

    Returns:
        Nombre choisi par l'ordinateur
    """
    return randint(mini, maxi)


def tourOrdiFacile(joueur: Joueur):
    """Procédure qui permet à l'ordinateur de jouer en mode facile à Devinette

    Args:
        joueur: Joueur jouant contre le bot
    """

    nb_coup_joueur: int = 0
    nb_coup_ordi: int = 0
    prop: int
    choix: int = 0
    mini: int = 0
    maxi: int

    borne: int = saisieBorne(joueur)
    maxi = borne

    nb_a_trouver: int = nbTrouve(joueur, borne)

    mrPropre()

    while choix != 3:
        prop = ordiFacile(mini, maxi)
        nb_coup_ordi += 1

        print("\n" + "L'ordinateur à choisit ", prop, "à vous de jouer")
        print(prop, "est :")
        print("1. Trop grand")
        print("2. Trop petit")
        print("3. Egal")

        choix = saisieInt(joueur.pseudo +
                          " faites votre choix : ", "Erreur de saisie")

        match choix:
            case 1:
                mrPropre()
                if prop < nb_a_trouver:
                    print(joueur.pseudo, "n'essaye pas de tricher !")
                    print(prop, "est trop petit")
                    mini = prop - 1

                elif prop == nb_a_trouver:
                    print(joueur.pseudo, "n'essaye pas de tricher !")
                    choix = 3
                else:
                    print(prop, "est trop grand")
                    maxi = prop - 1
            case 2:
                mrPropre()
                if prop > nb_a_trouver:
                    print(joueur.pseudo, "n'essaye pas de tricher !")
                    print(prop, "est trop petit")
                    maxi = prop + 1
                elif prop == nb_a_trouver:
                    print(joueur.pseudo, "n'essaye pas de tricher !")
                    choix = 3
                else:
                    print(prop, "est plus petit")
                    mini = prop + 1
            case 3:
                mrPropre()
                if prop > nb_a_trouver:
                    print(joueur.pseudo, "Fais attention !")
                    print(prop, "est trop grand")
                    maxi = prop
                    choix = 0
                elif prop < nb_a_trouver:
                    print(joueur.pseudo, "Fais attention !")
                    print(prop, "est trop petit")
                    mini = prop
                    choix = 0

    mrPropre()
    print("L'ordinateur à trouvé le nombre en", nb_coup_ordi, "coups")

    prop = 0

    nb_a_trouver = randint(1, borne)

    print(joueur.pseudo, "à vous de trouver le nombre que l'ordinateur a choisis entre 1 et", borne)

    while prop != nb_a_trouver:
        nb_coup_joueur += 1

        prop = saisieInt(joueur.pseudo + " entrez un nombre : ",
                         "Erreur de saisie")

        mrPropre()

        if prop > nb_a_trouver:
            print(prop, "est trop grand")
        elif prop < nb_a_trouver:
            print(prop, "est trop petit")

    print(joueur.pseudo, "à trouvé le nombre en", nb_coup_joueur, "coups")

    if nb_coup_joueur < nb_coup_ordi:
        print(joueur.pseudo, "à gagné")
    elif nb_coup_joueur == nb_coup_ordi:
        print("Match nul")
    else:
        print("L'ordinateur à gagné")

    sleep(3)
