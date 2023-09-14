from programme.utile.colorfull import *


def saisieInt(message: str, erreur: str = "Erreur de saisie") -> int:
    """

    Args:
        message: Message demandant le nombre à l'utilisateur
        erreur: Message à afficher en cas d'erreur

    Returns:
        Nombre saisi par l'utilisateur
    """
    nombre: int
    while True:
        try:
            nombre = int(input(message))
            return nombre
        except ValueError:
            print(TEXTFORM.WARNING + erreur + TEXTFORM.DEFAULT)


def saisieFloat(message: str, erreur: str) -> float:
    """

    Args:
        message: Message demandant le nombre à l'utilisateur
        erreur: Message à afficher en cas d'erreur

    Returns:
        Nombre saisi par l'utilisateur
    """
    nombre: float
    while True:
        try:
            nombre = float(input(message))
            return nombre
        except ValueError:
            print(TEXTFORM.WARNING + erreur + TEXTFORM.DEFAULT)
