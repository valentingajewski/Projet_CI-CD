# Projet de gestion de menu

### Dépendances du Projet

- Springboot :
  - spring-boot-starter-data-jpa
  - spring-boot-starter-web
  - spring-boot-starter-test 
- Maven

### Plugins maven

- spring-boot-starter-test
- maven-failsafe-plugin

## Lancer le projet
```bash
./
```

## Test de création de Menu"
```bash
# Créer un nouveau menu avec un plat dedans
curl -H "Content-Type: application/json" --data-raw '{"name": "Plat principal", "dishes": [{"name": "Ecrasé de pommes de terre"},{"name": "Purée"}]}' localhost:8080/menus

### Get the menus

`java -cp "{}Chemin vers le jar}/MenuCli-jar-with-dependencies.jar" Menucli --server-url https://tdbm-menu-server.herokuapp.com list-menus`

### Delete a menu

`java -cp "{}Chemin vers le jar}/MenuCli-jar-with-dependencies.jar" Menucli --server-url https://tdbm-menu-server.herokuapp.com -i {Id du Menu a Delete} delete-menu`
```