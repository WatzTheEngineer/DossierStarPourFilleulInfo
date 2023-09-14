from time import sleep

from programme.allumette.jcj.jcjAllumette import affichageAllumette
from programme.utile.ConfirmRetour import confirmRetour
from programme.utile.mrPropre import mrPropre


def ocoAllumette(bot1, bot2):
    """Fonction qui fait jouer deux bots à Allumette

    Args:
        bot1: Premier bot
        bot2: Second bot

    """

    nb_allumette: int = 20
    gagnant: bool = False

    while nb_allumette > 0:
        mrPropre()
        print(affichageAllumette(20, nb_allumette))
        print("Il reste", nb_allumette, "allumettes")
        print("C'est au tour du bot 1 de jouer")
        nb_allumette -= bot1(nb_allumette)
        gagnant = False
        # sleep(1)
        confirmRetour()

        if nb_allumette > 0:
            mrPropre()
            print(affichageAllumette(20, nb_allumette))
            print("Il reste", nb_allumette, "allumettes")
            print("C'est au tour du bot 2 de jouer")
            nb_allumette -= bot2(nb_allumette)
            gagnant = True
            # sleep(1)
            confirmRetour()

    if gagnant:
        print("Bot 1 à gagné")
    else:
        print("Bot 2 à gagné")

    confirmRetour()


