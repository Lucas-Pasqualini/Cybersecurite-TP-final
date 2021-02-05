# Securite-TP-final

<h1 align="center">Bienvenue sur le TP de concessionnaire 👋</h1>

## Description  
Je vais reprendre un TP fait en *programmation par composant* pour éviter de perdre du temps sur le développement du projet.  
Le TP permettait de lier des voitures à des clients, lister les voitures ou les marques disponibles chez un concessionnaire.  


## Test  
Importez le fichier *test.json* à la racine du projet dans Insomnia ou Postman. Toutes les routes y sont appelées.  
Il y a aussi des tests de vulnérabilités ou j'essaye de faire une injection xss et sql.  


## Analyse  
Pour ce projet j'utilise comme fonctionnalité de sécurité :
```
# Type champs base de données
    - Le type de chaque données est typé cela limite les injections.
# Repository
    - J'utilise le repository de spring boot pour faire mes requêtes.
    Cela limite les injections et sécurise l'application.
# Controller
    - J'ai fait un controller pour chaque classe ce qui permet de personnaliser chaque enpoint et de limiter l'accès à certaines requêtes du repository.
```


## Classe
```
# Brand
(id,name)

# Car
(id,name)

# Customer
(id,name)

# Adress
(id,adress)

# Concessionary
(id,name)
```


## Api  
Pour chaque classe, vous pouvez récupérer tous les objets de ce type dans la base de données, les ajouter, les supprimer ou les modifier.
```
# add
/add

# delete
delete/{id}

# update
/update/{id}
```


## Run  
Vous devez au préalable avoir installé Docker sur votre machine.  
L'image docker utilisée pour lancer le projet est sur DockerHub.
```
# Récupérer et lancer image docker
docker pull pasqualini/carsale:latest
docker run -p 8080:8080 pasqualini/carsale

# url
localhost:8080

# Si vous souhaitez récupérer tous les objets d'une classe. Ajoutez la classe à la fin de l'URL.
Par exemple : localhost:8080/car
Cette requête permet de récupérer toutes les voitures

# Si vous souhaitez apporter des modifications à la base de données.
Par exemple : localhost:8080/car/delete/1
Cette requête supprime la voiture qui a l'ID 1.
```


## Objectif de sécurité (C I D T)  
Confidentialité : 2/5 L'accès à la base de données est protégé par une URL et un espace d'authentification mais les informations de
connexion sont dans le code en clair.  
Intégrité : 5/5 les données sont stockées dans une base de données.  
Disponibilité : 0/5 On peut accéder à tout, il n'y a pas de compte, de gestion de permission.  
Traçabilité : 4/5 Nous avons les logs du serveur.


## Surface d'attaque
**UML Général :**  
[![](https://mermaid.ink/img/eyJjb2RlIjoiZ3JhcGggTFJcbiAgQVtcIi9jYXJcIl0gLS0-IEI-Y2FyX3RhYmxlXVxuICBDW1wiL2Nhci9zZWFyY2gve2NhcklkfVwiXSAtLT4gQlxuICBEW1wiL2Nhci9hZGRcIl0gLS0-IEJcbiAgRVtcIi9jYXIvZGVsZXRlL3tjYXJJZH1cIl0gLS0-IEJcbiAgRltcIi9jYXIvdXBkYXRlL3tjYXJJZH1cIl0gLS0-IEJcblxuICBHW1wiL2FkcmVzc1wiXSAtLT4gSD5hZHJlc3NfdGFibGVdXG4gIElbXCIvYWRyZXNzL3NlYXJjaC97YWRyZXNzSWR9XCJdIC0tPiBIXG4gIEpbXCIvYWRyZXNzL2FkZFwiXSAtLT4gSFxuICBLW1wiL2FkcmVzcy9kZWxldGUve2FkcmVzc0lkfVwiXSAtLT4gSFxuICBMW1wiL2FkcmVzcy91cGRhdGUve2FkcmVzc0lkfVwiXSAtLT4gSFxuXG4gIE1bXCIvYnJhbmRcIl0gLS0-IE4-YnJhbmRfdGFibGVdXG4gIE9bXCIvYnJhbmQvc2VhcmNoL3ticmFuZElkfVwiXSAtLT4gTlxuICBQW1wiL2JyYW5kL2FkZFwiXSAtLT4gTlxuICBRW1wiL2JyYW5kL2RlbGV0ZS97YnJhbmRJZH1cIl0gLS0-IE5cbiAgUltcIi9icmFuZC91cGRhdGUve2JyYW5kSWR9XCJdIC0tPiBOXG5cbiAgU1tcIi9jdXN0b21lclwiXSAtLT4gVD5jdXN0b21lcl90YWJsZV1cbiAgVVtcIi9jdXN0b21lci9zZWFyY2gve2N1c3RvbWVySWR9XCJdIC0tPiBUXG4gIFZbXCIvY3VzdG9tZXIvYWRkXCJdIC0tPiBUXG4gIFdbXCIvY3VzdG9tZXIvZGVsZXRlL3tjdXN0b21lcklkfVwiXSAtLT4gVFxuICBYW1wiL2N1c3RvbWVyL3VwZGF0ZS97Y3VzdG9tZXJJZH1cIl0gLS0-IFRcblxuICBZW1wiL2NvbmNlc3Npb25hcnlcIl0gLS0-IFo-Y29uY2Vzc2lvbmFyeV90YWJsZV1cbiAgQUFbXCIvY29uY2Vzc2lvbmFyeS9zZWFyY2gve2NvbmNlc3Npb25hcnlJZH1cIl0gLS0-IFpcbiAgQUJbXCIvY29uY2Vzc2lvbmFyeS9hZGRcIl0gLS0-IFpcbiAgQUNbXCIvY29uY2Vzc2lvbmFyeS9kZWxldGUve2NvbmNlc3Npb25hcnlJZH1cIl0gLS0-IFpcbiAgQURbXCIvY29uY2Vzc2lvbmFyeS91cGRhdGUve2NvbmNlc3Npb25hcnlJZH1cIl0gLS0-IFpcblxuICBCIC0tPiBiZGRbKEJERCldXG4gIEggLS0-IGJkZFxuICBOIC0tPiBiZGRcbiAgVCAtLT4gYmRkXG4gIFogLS0-IGJkZFxuXG4gIEFFW2VuZF91c2VyXSAtLT4gQUZbQVBJXVxuICBBRiAtLT4gQUdbZG9ja2VyXVxuICBBRyAtLT4gTGludXgiLCJtZXJtYWlkIjp7fSwidXBkYXRlRWRpdG9yIjpmYWxzZX0)](https://mermaid-js.github.io/mermaid-live-editor/#/edit/eyJjb2RlIjoiZ3JhcGggTFJcbiAgQVtcIi9jYXJcIl0gLS0-IEI-Y2FyX3RhYmxlXVxuICBDW1wiL2Nhci9zZWFyY2gve2NhcklkfVwiXSAtLT4gQlxuICBEW1wiL2Nhci9hZGRcIl0gLS0-IEJcbiAgRVtcIi9jYXIvZGVsZXRlL3tjYXJJZH1cIl0gLS0-IEJcbiAgRltcIi9jYXIvdXBkYXRlL3tjYXJJZH1cIl0gLS0-IEJcblxuICBHW1wiL2FkcmVzc1wiXSAtLT4gSD5hZHJlc3NfdGFibGVdXG4gIElbXCIvYWRyZXNzL3NlYXJjaC97YWRyZXNzSWR9XCJdIC0tPiBIXG4gIEpbXCIvYWRyZXNzL2FkZFwiXSAtLT4gSFxuICBLW1wiL2FkcmVzcy9kZWxldGUve2FkcmVzc0lkfVwiXSAtLT4gSFxuICBMW1wiL2FkcmVzcy91cGRhdGUve2FkcmVzc0lkfVwiXSAtLT4gSFxuXG4gIE1bXCIvYnJhbmRcIl0gLS0-IE4-YnJhbmRfdGFibGVdXG4gIE9bXCIvYnJhbmQvc2VhcmNoL3ticmFuZElkfVwiXSAtLT4gTlxuICBQW1wiL2JyYW5kL2FkZFwiXSAtLT4gTlxuICBRW1wiL2JyYW5kL2RlbGV0ZS97YnJhbmRJZH1cIl0gLS0-IE5cbiAgUltcIi9icmFuZC91cGRhdGUve2JyYW5kSWR9XCJdIC0tPiBOXG5cbiAgU1tcIi9jdXN0b21lclwiXSAtLT4gVD5jdXN0b21lcl90YWJsZV1cbiAgVVtcIi9jdXN0b21lci9zZWFyY2gve2N1c3RvbWVySWR9XCJdIC0tPiBUXG4gIFZbXCIvY3VzdG9tZXIvYWRkXCJdIC0tPiBUXG4gIFdbXCIvY3VzdG9tZXIvZGVsZXRlL3tjdXN0b21lcklkfVwiXSAtLT4gVFxuICBYW1wiL2N1c3RvbWVyL3VwZGF0ZS97Y3VzdG9tZXJJZH1cIl0gLS0-IFRcblxuICBZW1wiL2NvbmNlc3Npb25hcnlcIl0gLS0-IFo-Y29uY2Vzc2lvbmFyeV90YWJsZV1cbiAgQUFbXCIvY29uY2Vzc2lvbmFyeS9zZWFyY2gve2NvbmNlc3Npb25hcnlJZH1cIl0gLS0-IFpcbiAgQUJbXCIvY29uY2Vzc2lvbmFyeS9hZGRcIl0gLS0-IFpcbiAgQUNbXCIvY29uY2Vzc2lvbmFyeS9kZWxldGUve2NvbmNlc3Npb25hcnlJZH1cIl0gLS0-IFpcbiAgQURbXCIvY29uY2Vzc2lvbmFyeS91cGRhdGUve2NvbmNlc3Npb25hcnlJZH1cIl0gLS0-IFpcblxuICBCIC0tPiBiZGRbKEJERCldXG4gIEggLS0-IGJkZFxuICBOIC0tPiBiZGRcbiAgVCAtLT4gYmRkXG4gIFogLS0-IGJkZFxuXG4gIEFFW2VuZF91c2VyXSAtLT4gQUZbQVBJXVxuICBBRiAtLT4gQUdbZG9ja2VyXVxuICBBRyAtLT4gTGludXgiLCJtZXJtYWlkIjp7fSwidXBkYXRlRWRpdG9yIjpmYWxzZX0)

![schema surface attaque!](/image/surface_attaque.PNG "schéma surface attaque")


## Auteur

👤 **Lucas Pasqualini <lucas.pasqualini@lacatholille.fr>**
