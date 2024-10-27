# Seminario PW45S
- Este projeto foi desenvolvido para a disciplina de Tópicos Avançados em Programção Web, Curso de Tecnologia em Análise e Desenvolvimento de Sistema da Universidade Técnológica Federal do Paraná - Campus Pato Branco.
- O objetivo é desenvolver um sistema de CRUD básico de uma entidade Pessoa utilizando o framework Quarkus.


## Requisitos


- Java versão 18
- Maven versão 3.9.0
- PostgreSQL versão 14.13


## Configurações iniciais


- Para as depencias, a aplicação será criada pela página do [quarkus](https://code.quarkus.io)
- Após informar o groupId e artifactId, selecionar a ferramenta Maven.
- Selecionar as seguintes extensões:
    - RESTeasy Classic
    - Hibernate Validator
    - Hibernate ORM
    - JDBC Driver - PostgreSQL
    - Flyway
- Criar um banco de dados no PostgreSQL com o nome `seminario_pw45s`. Pode ser utilizado um gerenciador de banco de dados como o DBeaver ou PGAdmin.
- Configurar o arquivo `application.properties` com as informações do banco de dados.


## Desenvolvimento


## Execução










# Quarkus Getting Started


# app


This project uses Quarkus, the Supersonic Subatomic Java Framework.


If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.


## Running the application in dev mode


You can run your application in dev mode that enables live coding using:


```shell script
./mvnw compile quarkus:dev
```


> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.


## Packaging and running the application


The application can be packaged using:


```shell script
./mvnw package
```


It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.


The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.


If you want to build an _über-jar_, execute the following command:


```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```


The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.


## Creating a native executable


You can create a native executable using:


```shell script
./mvnw package -Dnative
```


Or, if you don't have GraalVM installed, you can run the native executable build in a container using:


```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```


You can then execute your native executable with: `./target/app-1.0.0-SNAPSHOT-runner`


If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.


## Related Guides


- Hibernate ORM ([guide](https://quarkus.io/guides/hibernate-orm)): Define your persistent model with Hibernate ORM and Jakarta Persistence
- Flyway ([guide](https://quarkus.io/guides/flyway)): Handle your database schema migrations
- Hibernate Validator ([guide](https://quarkus.io/guides/validation)): Validate object properties (field, getter) and method parameters for your beans (REST, CDI, Jakarta Persistence)
- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing Jakarta REST and more
- JDBC Driver - PostgreSQL ([guide](https://quarkus.io/guides/datasource)): Connect to the PostgreSQL database via JDBC


## Provided Code


### Hibernate ORM


Create your first JPA entity


[Related guide section...](https://quarkus.io/guides/hibernate-orm)






### RESTEasy JAX-RS


Easily start your RESTful Web Services


[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)

