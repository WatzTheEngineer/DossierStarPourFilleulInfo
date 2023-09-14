# =================================================================
#
# Code support du TP chaine d'entiers
#
# Non redistibuable en dehors du Département Informatique de l'IUT
#
# =================================================================

from typing import Optional


# structure de maillon
class Maillon:
    data: int
    suivant: Optional["Maillon"]


# structure de liste
class ListeChainee:
    tete: Optional[Maillon]


def longueur(li: ListeChainee) -> int:
    """
    Retourne le nombre de maillons
    :param li: Liste Chainée
    :return: entier
    """
    i: int = 0
    if li.tete is not None:
        m = li.tete
        while m.suivant is not None:
            i = i + 1
            m = m.suivant
        i = i + 1
    return i


def afficheLC(li: ListeChainee):
    """Fonction qui affiche les éléments de la liste

    Dans cette version, chaque élément est affiché sur une ligne

    Args:
        li (ListeChainee): la liste que l'on veut afficher
    """
    courant: Maillon = li.tete
    while courant:
        print(courant.data)
        courant = courant.suivant


def ajoutQueue(li: ListeChainee, val: int):
    """
    Ajoute un maillon en queue
    :param li: liste chainée
    :param val: valeur stockée dans le maillon
    """
    m: Maillon = li.tete
    if m is None:
        li.tete = Maillon()
        li.tete.data = val
        li.tete.suivant = None
    else:
        while m.suivant is not None:
            m = m.suivant
        m.suivant = Maillon()
        m.suivant.data = val
        m.suivant.suivant = None


def ajoutTete(li: ListeChainee, val: int):
    """
    Ajoute un maillon en tete
    :param li: liste chainée
    :param val: valeur stockée dans le maillon
    """
    if li.tete is None:
        li.tete = Maillon()
        li.tete.data = val
        li.tete.suivant = None
    else:
        m: Maillon = Maillon()
        m.data = val
        m.suivant = li.tete
        li.tete = m


def ajoutEnPos(li: ListeChainee, indice: int, val: int):
    """
    Ajoute un maillon en indice désiré
    :param li: liste chainée
    :param indice: indice auquel est ajouté le maillon
    :param val: valeur stockée dans le maillon
    """
    if indice == 0:
        ajoutTete(li, val)
    elif indice == longueur(li):
        ajoutQueue(li, val)
    elif 0 < indice < longueur(li):
        m: Maillon = li.tete
        for i in range(1, indice):
            m = m.suivant
        n: Maillon = Maillon()
        n.suivant = m.suivant
        m.suivant = n
        n.data = val
    else:
        print("Impossible d'ajouter hors de la liste")


def suppTete(li: ListeChainee):
    """
    Supprime le maillon de tete
    :param li: liste chainée
    """
    if li.tete is not None:
        if li.tete.suivant is not None:
            m: Maillon = li.tete
            li.tete = li.tete.suivant
            m.suivant = None
        else:
            li.tete = None
    else:
        print("Impossible de supprimer la tete d'une liste vide")


def suppQueue(li: ListeChainee):
    """
        Supprime le maillon de queue
        :param li: liste chainée
        """
    if li.tete is not None:
        if li.tete.suivant is not None:
            m: Maillon = li.tete
            for i in range(1, longueur(li) - 1):
                m = m.suivant
            m.suivant = None
        else:
            li.tete.suivant = None
    else:
        print("Impossible de supprimer la queue d'une liste vide")


def suppEnPos(li: ListeChainee, indice: int):
    """
        Supprime le maillon d'indice désiré
        :param li: liste chainée
        :param indice: indice du mayon à supprimer
        """
    if indice == 0:
        suppTete(li)
    elif indice == longueur(li):
        suppQueue(li)
    elif 0 < indice < longueur(li):
        m: Maillon = li.tete
        for i in range(1, indice):
            m = m.suivant
        m.suivant = m.suivant.suivant
    else:
        print("Impossible d'ajouter hors de la liste")


def recherche(li: ListeChainee, val: int) -> int:
    if li.tete is None:
        return -1
    elif li.tete.data == val:
        return 0
    else:
        m: Maillon = Maillon()
        m = li.tete
        i: int = 0
        while m.suivant is not None:
            i += 1
            m = m.suivant
            if m.data == val:
                return i
        return -1


if __name__ == "__main__":
    maLC = ListeChainee()
    maLC.tete = None
    suppTete(maLC)
    suppQueue(maLC)
    ajoutQueue(maLC, 2)
    ajoutQueue(maLC, 5)
    ajoutTete(maLC, 1)
    ajoutEnPos(maLC, -1, -1)
    ajoutEnPos(maLC, 1, 7)
    ajoutEnPos(maLC, 0, 7)
    ajoutEnPos(maLC, 5, 7)
    ajoutEnPos(maLC, 5, 7)
    suppTete(maLC)
    suppQueue(maLC)
    suppEnPos(maLC, 2)
    afficheLC(maLC)
    print(longueur(maLC))
