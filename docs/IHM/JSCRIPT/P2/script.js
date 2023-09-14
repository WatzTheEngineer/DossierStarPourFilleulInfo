console.log("Démarrage de la page web"); //Produit un message dans la console de commande du navigateur

/*console.log(mavariablepasset);*/ //Plante car la variable n'est pas définie

let nombre1 = 10;
console.log(nombre1);

console.log(document); //affiche dans la console l'ojet correspondant au document, ses attributs et valeurs

e = document.getElementById('maDiv'); // contient l'élément portant l'ID 'maDiv'
e.style.visibility = 'hidden'; //passe la propriété de style 'visibility' de 'maDiv' à 'hidden'

e = document.getElementById('test');
e.style.color = "red"; //fonctionne

e = document.getElementById('suite');

t = document.createTextNode('coucou'); //Crée un texte 'coucou'
p = document.createElement('p'); //Crée un noeud de type <p>
p.appendChild(t); //Ajoute le texte comme enfant de l'élément p
e.appendChild(p); //Ajoute l'élément p comme un noeud à l'intérieur de la div #suite
console.log("ajout de p")

// createTextNode crée un noeud de type Text, l'autre un noeud de type Element

for (let i = 0; i < 5; i++) {
    e.appendChild(document.createElement('div'));
}

// e.childNodes.length 
// 6    // Nombre de noeuds enfants de e
// e.childNodes
// NodeList(6) [p, div, div, div, div, div] // Tableau contenant les noeuds enfants de e

e.removeChild(e.childNodes[0]); //Doit retirer le p
console.log("supression de p");

// e.innerHTML permet de lire les balises html contenues par e
// e.innerHTML = "" retire tous les enfants de e