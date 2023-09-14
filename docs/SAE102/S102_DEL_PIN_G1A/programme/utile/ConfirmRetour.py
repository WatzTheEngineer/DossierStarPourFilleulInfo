from programme.utile.mrPropre import mrPropre


def confirmRetour():
    """Demande une l'appui sur la touche 'Entrée' pour continuer
    """
    choix: str = " "
    while choix != "":
        choix = input("Appuyez sur \"Entrée\" pour continuer : ")
    mrPropre()
