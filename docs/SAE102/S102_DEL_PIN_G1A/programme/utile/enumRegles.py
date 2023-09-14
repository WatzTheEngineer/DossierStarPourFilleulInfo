from enum import Enum
from programme.utile.colorfull import TEXTCOLOR

class Regles(Enum):
    """Enumération des jeux disponibles
    """
    DEVINETTE: str = TEXTCOLOR.PINK+"Le joueur 1 choisit un nombre entre 1 et une limite à décider. " \
                                    "Le joueur 2 doit deviner ce nombre. A chacune de ses propositions, " \
                                    "le joueur 1 répond : Trop grand / Trop petit / Egal\n"+TEXTCOLOR.DEFAULT
    ALLUMETTES: str = TEXTCOLOR.PINK+"On dispose d’un tas de 20 allumettes. Chaque joueur à tour de " \
                      "rôle peut prélever 1, 2 ou 3 allumettes. Le perdant est " \
                      "celui qui pioche la dernière allumette.\n"+TEXTCOLOR.DEFAULT
    MORPION: str = TEXTCOLOR.PINK+"On dispose d’un plateau de 3 cases par 3 cases. Chaque joueur pose " \
                   "tour à tour un pion X ou O sur la grille. Le premier à aligner 3 pions " \
                   "de la même sorte gagne la partie. En cas de plateau rempli, il y a égalité.\n"+TEXTCOLOR.DEFAULT
    P4: str = TEXTCOLOR.PINK+"Les joueurs font tomber un jeton chacun leur tour dans une grille de 7x6. " \
                             "Le premier à aligner 4 jetons de sa couleur remporte la partie\n"+TEXTCOLOR.DEFAULT
