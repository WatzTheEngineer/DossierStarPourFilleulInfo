from enum import Enum

from programme import puissance4


class Jeux(Enum):
    """Enumération des jeux disponibles
    """
    DEVINETTE: str = "devinette"
    ALLUMETTES: str = "allumettes"
    MORPION: str = "morpion"
    P4: str = "puissance 4"
