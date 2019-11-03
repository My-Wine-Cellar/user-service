# user-service for winecellar-webapp

## General info
> REST service for winecellar-webapp to manage user login, registration, and password reset

## Docker
> You will need to have [Docker Engine](https://docs.docker.com/install/) installed before proceeding

```
$ docker run --name user-service -p 5433:5432 -d -e POSTGRES_USER=winecellar -e POSTGRES_PASSWORD=winecellar -e POSTGRES_DB=user-service postgres
```
> This will pull down the latest PostgreSQL image and run the container with all necessary Spring Boot properties for connection. 

## Project Setup
```
$ git clone https://github.com/My-Wine-Cellar/user-service
$ cd user-service
$ ./mvnw spring-boot:run
```

## License
[![License](https://img.shields.io/badge/License-EPL%202.0-orange.svg)](https://www.eclipse.org/legal/epl-2.0/)
> Wincellar is released under version 2.0 of the Eclipse Public License

## Contact
> Created by [Paul Pearson](mailto:paul.darlington.pearson@gmail.com) & Jesper Pedersen
