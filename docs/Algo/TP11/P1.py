import pickle
from typing import Optional


class Auteur:
    prenom: str
    nom: str
    natio: str
    anneeN: int
    anneeD: Optional[int]


class Livre:
    titre: str
    auteur: Auteur
    date: str
    pages: int


def afficherBib(biblio: list[Livre], nlivre: int):
    """Affiche tous les livres de la bibliothèque

    Args:
        biblio (list[Livre]): Bibliothèque
        nlivre (int): Nombre de livres dans la bibliothèque
    """
    i: int
    for i in range(0, nlivre):
        afficherLivre(biblio, i)
        print()


def afficherLivre(biblio: list[Livre], pos: int):
    """Affiche un livre à partir de son index

    Args:
        biblio (list[Livre]): Bibliothèque
        pos (int): indexe
    """
    a: Auteur = biblio[pos].auteur

    print(biblio[pos].titre)
    print(a.prenom, a.nom)
    print(biblio[pos].date)
    print(str(biblio[pos].pages))


def ajouterLivre(biblio: list[Livre], nlivre: int, nlivremax: int, auteurset: set):
    """Permet d'ajouter un livre à la bibliothèque

    Args:
        biblio (list[Livre]): Bibliothèque
        nlivre (int): Nombre de livres dans la bibilothèque
        nlivremax (int): Taille de la bibliothèque
    """
    livre: Livre
    livre = Livre()
    a: Auteur
    anp: str
    avalide: bool = False

    if nlivre < nlivremax:
        if len(auteurset) != 0:
            livre.titre = input("Titre : ")
            for a in auteurset:
                print(a.prenom, a.nom)
            while not avalide:
                anp = (input("Prenom de l'auteur : ") +
                       input("Nom de l'auteur : "))
                for a in auteurset:
                    if anp == (a.prenom+a.nom):
                        livre.auteur = a
                        avalide = True
                if not avalide:
                    print("Auteur inconnu")
            livre.date = input("Année de parution : ")
            livre.pages = int(input("Nombre de pages : "))
            biblio.append(livre)
        else:
            print("Aucun auteur n'est disponible\n")
    else:
        print("Impossible d'ajouter un livre, la bibliothèque est complète\n")


def rechercherLivre(mabiblio: list[Livre], nlivre: int, stitre: str) -> int:
    """Permet la recherche d'un livre par son titre

    Args:
        mabiblio (list[Livre]): Bibliothèque
        nlivre (int): Nombre de livres dans la bibliothèque
        stitre (str): Titre du livre à rechercher

    Returns:
        int: Index du livre trouvé. [-1 si le livre est absent de la bibliothèque]
    """
    pos: int = -1
    i: int = 0

    while (i < nlivre):
        if mabiblio[i].titre == stitre:
            pos = i
            break
        i += 1
    return pos


def ajouterAuteur(auteurset: set):
    """Permet d'ajouter un auteur

    Args:
        auteurset (set): ensemble des auteurs existants
    """
    auteur: Auteur
    auteur = Auteur()

    auteur.prenom = input("Prenom de l'auteur : ")
    auteur.nom = input("Nom de l'auteur : ")
    auteur.natio = input("Nationalité de l'auteur : ")
    auteur.anneeN = int(input("Année de naissance de l'auteur : "))
    ad = input("Année de décès de l'auteur (vide si l'auteur est en vie) : ")
    if (ad != ""):
        auteur.anneeD = int(ad)

    auteurset.add(auteur)


def exporterLivre(bib: list[Livre]):
    with open("export_livre.txt", "w") as f:
        for i in range(0, len(bib)):
            f.write(bib[i].titre + ";" + bib[i].auteur.prenom +" "+ bib[i].auteur.nom + ";" + bib[i].date +
                    ";" + str(bib[i].pages)+"\n")


if __name__ == "__main__":
    auteurs: set = set()
    nlivremax: int = 10
    biblio: list[Livre] = []
    choix: str = ''
    stitre: str
    pos: int

    try:
        with open("livres.dat", "rb") as f:
            biblio = pickle.load(f)
    except FileNotFoundError:
        biblio = []

    try:
        with open("auteurs.dat", "rb") as f:
            auteurs = pickle.load(f)
    except FileNotFoundError:
        auteurs = set()

    while choix != '5':
        print()
        print("1. Afficher tous les livres")
        print("2. Ajouter un livre")
        print("3. Rechercher un livre")
        print("4. Ajouter un auteur")
        print("5. Quitter")
        print("6. Exporter Livres")

        choix = input("\nSélectionner une opération : ")
        print()

        match choix:
            case '1': afficherBib(biblio, len(biblio))
            case '2': ajouterLivre(biblio, len(biblio), nlivremax, auteurs)
            case '3':
                stitre = input("Entrer le titre à rechercher : ")
                pos = rechercherLivre(biblio, len(biblio), stitre)
                if pos == -1:
                    print("Le livre n'existe pas")
                else:
                    afficherLivre(biblio, pos)
            case '4': ajouterAuteur(auteurs)
            case '5': print("Au revoir !")
            case '6': exporterLivre(biblio)
            case _: print("Erreur lors de la saisie")
    with open("livres.dat", "wb") as f:
        pickle.dump(biblio, f)
    with open("auteurs.dat", "wb") as f:
        pickle.dump(auteurs, f)