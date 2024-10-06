# Check-in-check-out system
This system is made with Springboot to create this project I used Java version 17 the steps:

## [1-SpringBoot Initializr](https://start.spring.io/)

**Install this Dependencies in the section "ADD DEPENDENCIES" to generate the Springboot Proyect**

* [Spring JPA](https://docs.spring.io/spring-data/jpa/reference/index.html) provides support for the [Jakarta Persistence API(JPA)](https://jakarta.ee/learn/docs/jakartaee-tutorial/current/persist/persistence-intro/persistence-intro.html)
* [Spring Web](https://docs.spring.io/spring-framework/reference/web/webmvc.html#page-title) is a web framework and the formal name is "Spring Web" or "Spring MVC"(commonly known)
* [Mysql Driver](https://dev.mysql.com/doc/connector-j/en/) this driver uses a JDBC(Java Database Connectivity) is a driver for communicating with MYSQL servers

## [2-Setup Docker Container ](https://start.spring.io/)
> Install [Docker](https://www.docker.com/)

1. After installing docker we could use it with **Docker compose**

** [Docker compose](https://docs.docker.com/compose/) is a tool inside of the Docker Utility that help us to build containers**

2. Now we need to create our compose.yaml in this scenario I stored it in a directory called  DB due to this file we help us to build our DataBase in this case [MYSQL](https://www.mysql.com/downloads/) the version 8.
> **Be aware of the version of MYSQL beacuse the Syntax is different from other versions and SQL Server is Diferent**
 - If you want to create in the same order you can do it as well
 ```
 |  ├── check-in-check-out repository/
 │  ├── check-in-check-out/
 |  ├── DB/
 |   ├── docker-compose.yaml

 ```
> You can name the **docker-compose.yaml** as you wanted but needs to be [yaml](https://datatracker.ietf.org/doc/html/rfc9512) because that's the configuration media type used in the **Docker CLI**

 - Time to see what's inside our docker-compose you can use a template or take a look at the [mysql image documentation](https://hub.docker.com/_/mysql)because there's an example there.Furthermore, you can use my **Docker compose** :

```
name: check_database
services:
  db:
    image: mysql:8.0
    container_name: check_db
    environment:
      MYSQL_DATABASE: check_db
      MYSQL_USER: user
      MYSQL_PASSWORD: password
      MYSQL_ROOT_PASSWORD : password
    ports:
      - '3306:3306'
    volumes:
      - my-db-data:/var/lib/mysql
volumes:
  my-db-data:

```
> Remember the indentation it's important if you want to create a good file you can create read the [documentation](https://docs.docker.com/compose/gettingstarted/)

- Now it's time to build and run our file with compose
```
docker compose up  -d --build .
```
> [ docker compose up = create and restart containers + --d (run containers in the background) + --build(build images before starting containers) .(all the yaml files as well we can specify if we have different yamls in the directory)] (https://docs.docker.com/reference/cli/docker/compose/up/)




