TP 14 CRUD DAO/
├── bin/
└── src/
    └── ma/
        └── projet/
            ├── bean/
            │   ├── Identifiable.java   // Contrat d'accès à la clé primaire
            │   ├── Profile.java        // Entité rôle/profil utilisateur
            │   └── Utilisateur.java    // Entité utilisateur avec référence vers Profile
            ├── dao/
            │   ├── Dao.java            // Interface CRUD générique (T extends Identifiable)
            │   └── ListDao.java        // Implémentation en mémoire basée sur ArrayList
            ├── service/
            │   ├── ProfileService.java // Couche métier Profile
            │   └── UserService.java    // Couche métier Utilisateur (filtres par profil)
            └── TestApp.java            // Point d'entrée console (scénario CRUD)

1. Découpage en Couches (Séparation des Responsabilités)

Couche Bean / Modèle : Représente les données métier. Chaque entité implémente le contrat Identifiable et gère l'unicité de son identifiant grâce à un compteur statique incrémental privé.

Couche DAO (Data Access Object) : Abstraction totale du stockage. Le service interagit uniquement avec l'interface Dao<T>, rendant le remplacement de l'implémentation en mémoire (ListDao) par une base de données relationnelle (JDBC/JPA) transparent pour le reste de l'application.

Couche Service : Centralise les règles de gestion et la logique applicative (ex. filtrage des utilisateurs par profil). Elle délègue systématiquement les écritures/lectures atomiques au DAO.

Couche Présentation (TestApp) : Orchestre les scénarios fonctionnels sans manipuler directement les collections internes de stockage.

2. Généricité Bornée (<T Identifiable extends>)

L'interface générique contraint le type manipulé à exposer la méthode getId().

Cette contrainte permet d'écrire des algorithmes de recherche, de mise à jour et de suppression uniformes dans ListDao<T> sans connaître le type concret de l'entité.




https://github.com/user-attachments/assets/da3b8fa8-a3af-4165-b137-7d28763fca0e



