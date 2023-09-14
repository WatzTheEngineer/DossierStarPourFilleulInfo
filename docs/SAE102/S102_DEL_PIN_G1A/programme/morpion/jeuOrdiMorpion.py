from random import randint
from typing import Optional

from programme.joueur.joueur import Joueur
from programme.morpion.fonctionMorpion import pionAligne, affichePlateau, saisieX, saisieY, plateauPlein
from programme.utile.ConfirmRetour import confirmRetour
from programme.utile.colorfull import *
from programme.utile.mrPropre import mrPropre
from programme.utile.score import incrementScore


def ordiMorpion(joueur1: Optional[Joueur], precision: int):  # Code similaire au morpion JcJ
    """Procédure gérant un tour de morpion avec au moins un ordinateur

    Args:
        precision (int): Précision du bot de base en %
        joueur1 (Optional[Joueur]): Joueur 1
    """

    mrPropre()

    plateau: list[list[str]] = [  # Définition du plateau
        ["-", "-", "-"], ["-", "-", "-"], ["-", "-", "-"]]
    x: int
    y: int
    pion: str
    aligne: bool
    plein: bool
    bool_state: str

    affichePlateau(plateau)  # Premier affichage

    while True:
        while True:  # On joue tant qu'il n'y a pas de victoire ou d'égalité
            if joueur1 is not None:  # Si l'on à entrer un joueur, il joue
                x = saisieX(joueur1)
                y = saisieY(joueur1)
            else:  # Sinon le 2e bot prend la relève
                casebot: tuple[int, int] = choixCase(plateau, casesLibres(plateau), precision * 2, "X", "O")
                x = casebot[0]
                y = casebot[1]
            if plateau[x][y] == "-":
                break
            else:
                print("Case déjà prise")
        plateau[x][y] = "X"
        bool_state, pion = pionAligne(plateau)
        aligne = eval(bool_state)
        plein = plateauPlein(plateau)
        affichePlateau(plateau)
        if aligne or plein:
            break
        elif joueur1 is None:
            confirmRetour()
        casebot2: tuple[int, int] = choixCase(plateau, casesLibres(plateau), precision, "O", "X")
        plateau[casebot2[0]][casebot2[1]] = "O"
        bool_state, pion = pionAligne(plateau)
        aligne = eval(bool_state)
        plein = plateauPlein(plateau)
        affichePlateau(plateau)
        if aligne or plein:
            break

    if pion == "X" and joueur1 is not None:
        print(TEXTCOLOR.GREEN + "\n" + joueur1.pseudo + " a gagné !" + TEXTCOLOR.DEFAULT + "\n")
        incrementScore(joueur1, "morpion")
    elif pion == "X":
        print(TEXTCOLOR.GREEN + "\nL'ordinateur 1 a gagné !" + TEXTCOLOR.DEFAULT + "\n")
    elif pion == "O":
        print(TEXTCOLOR.GREEN + "\nL'ordinateur 2 a gagné !" + TEXTCOLOR.DEFAULT + "\n")
    elif plein:
        print("\n" + TEXTCOLOR.YELLOW + "Match nul" + TEXTCOLOR.DEFAULT + "\n")

    confirmRetour()


def casesLibres(plateau: list[list[str]]) -> list[tuple[int, int]]:
    """Vérifie quelles cases sont libres

    Args:
        plateau (list[list[str]]): Plateau de jeu

    Returns:
        list[tuple[int, int]]: Liste des coordonées des cases du plateau vides
    """
    cases: list[tuple[int, int]] = []
    coords: tuple[int, int]
    for i in range(len(plateau)):
        for j in range(len(plateau[i])):
            if plateau[i][j] == "-":
                coords = (i, j)
                cases.append(coords)
    return cases


def choixCase(plateau: list[list[str]], caseslibres: list[tuple[int, int]], precision: int, pional: str, pionen: str) \
        -> tuple[int, int]:
    """Choisit la case sur laquelle le bot joue

    Args:
        plateau (list[list[str]]): Plateau de jeu
        caseslibres (list[tuple[int, int]]): Liste des coordonées des cases libres
        precision (int): % de chance d'effectuer le meilleur coup
        pional (str): Caractère du pion allié
        pionen (str): Caractère du pion ennemi

    Returns:
        tuple[int, int]: Coordonées de la case choisie par le bot
    """

    coords: tuple[int, int]

    coords = caseslibres[randint(0, len(caseslibres) - 1)]
    if randint(1, 100) < precision:
        if (1, 1) in caseslibres:  # Si milieu libre
            coords = (1, 1)
        else:
            coords = finPossible(plateau, caseslibres, pional, pionen, coords)
    return coords


def finPossible(plateau: list[list[str]], caseslibres: list[tuple[int, int]], pional: str,
                pionen: str, ccase: tuple[int, int]) -> tuple[int, int]:
    """Vérifie où jouer en fonction du plateau

    Args:
        plateau (list[list[str]]): Plateau de jeu
        pional (str): Caractère du pion allié
        pionen (str): Caractère du pion ennemi
        ccase:
        caseslibres:

    Returns:
        tuple[int, int]: coordonées de jeu
    """

    meilleurcoup: tuple[int, int] = parcourirCases(plateau, pional)
    if meilleurcoup is not None:
        return meilleurcoup
    else:
        meilleurblocage: tuple[int, int] = parcourirCases(plateau, pionen)
    if meilleurblocage is not None:
        return meilleurblocage

    for t in {(0, 0), (0, 2), (2, 0), (2, 2)}:
        if t in caseslibres:
            return t

    return ccase


def parcourirCases(plateau: list[list[str]], pion: str) -> Optional[tuple[int, int]]:
    """Vérifie si une case est en état critique (jouer dessus est décisif)

    Args:
        plateau (list[list[str]]): Plateau de jeu
        pion (str): Caractère du pion recherché

    Returns:
        Optional[tuple[int, int]]: Coordonées d'une case où il est critique de jouer | None si aucune
        case n'est dans un état critique
    """

    # Vérifications horizontales
    for i in range(len(plateau)):
        ligne: list[str] = plateau[i]
        contenuligne: str = ""
        for j in ligne:
            contenuligne = contenuligne + j
        if contenuligne.count(pion) > 1 and "-" in contenuligne:
            # Possibilité de gagner
            return i, contenuligne.find("-")

    # Vérifications verticales
    for k in range(len(plateau)):
        contenucolonne: str = plateau[0][k] + plateau[1][k] + plateau[2][k]
        if contenucolonne.count(pion) > 1 and "-" in contenucolonne:
            # Possibilité de gagner
            return contenucolonne.find("-"), k
