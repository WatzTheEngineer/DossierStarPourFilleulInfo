import getpass

from programme.joueur.joueur import Joueur
from programme.utile.mrPropre import mrPropre
from programme.utile.saisieNombre import saisieInt


def tourDeJeu(joueur_choisit: Joueur, joueur_cherche: Joueur, borne: int) -> int:
    """Procédure gérant un tour du jeu Devinette

    Args:
        joueur_choisit (Joueur): Joueur qui choisit la borne
        joueur_cherche (Joueur): Joueur qui joue en 2e
        borne (int): Borne définie par le premier joueur

    Returns:
        int: Nombre de coups pour trouver le nombre
    """

    compt_joueur: int = 0
    nb_a_trouver: int
    choix: int = 0
    proposition: int

    nb_a_trouver = nbTrouve(joueur_cherche, borne)

    while choix != 3:
        proposition = saisieInt(  # proposition par le joueur
            "\n" + joueur_cherche.pseudo + " devine le nombre : ", "Erreur de saisie")
        compt_joueur += 1

        print("\n" + joueur_choisit.pseudo, "à vous de jouer")  # Réponse
        print(proposition, "est :")
        print("1. Plus grand")
        print("2. Plus petit")
        print("3. Egal")

        choix = saisieInt(joueur_choisit.pseudo +
                          " faites votre choix : ", "Erreur de saisie")

        match choix:
            case 1:
                print(proposition, "est plus grand")
            case 2:
                print(proposition, "est plus petit")

        if choix == 1 and proposition < nb_a_trouver:
            print(joueur_choisit.pseudo, "n'essaye pas de tricher !")
            print(proposition, "est plus petit")
        if choix == 2 and proposition > nb_a_trouver:
            print(joueur_choisit.pseudo, "n'essaye pas de tricher !")
            print(proposition, "est plus grand")
        if choix != 3 and proposition == nb_a_trouver:
            print(joueur_choisit.pseudo, "n'essaye pas de tricher !")
            choix = 3
        if choix == 3 and proposition != nb_a_trouver:
            print("Fait attention", joueur_choisit.pseudo)
            choix = 0

    mrPropre()
    print("Bien joué", joueur_cherche.pseudo,
          "vous avez trouvé le nombre en", compt_joueur, "coups")

    return compt_joueur


def nbTrouve(joueur: Joueur, borne: int) -> int:
    """Fonction gérant la saisie du nombre caché

    Args:
        joueur: Joueur cachant le nombre
        borne: Nombre maximal limite

    Returns:
        Nombre caché choisi par le joueur
    """
    nb: int = 0
    while nb <= 0 or nb >= borne:  # Entrée du nombre caché
        try:
            nb = int(getpass.getpass("Entrez le nombre que " +
                                     joueur.pseudo + " doit trouver entre 1 et " + str(borne) + " : "))

            return nb
        except ValueError:
            print("Erreur de saisie")
