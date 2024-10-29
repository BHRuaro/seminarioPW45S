# Seminario PW45S
- Este projeto foi desenvolvido para a disciplina de Tópicos Avançados em Programação Web, Curso de Tecnologia em Análise e Desenvolvimento de Sistema da Universidade Técnológica Federal do Paraná - Campus Pato Branco.
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
    - RESTEasy Classic Jackson
    - Hibernate Validator
    - Hibernate ORM
    - JDBC Driver - PostgreSQL
    - Flyway
    - Quarkus Extension for Spring Data JPA API
- Após gerar o projeto, descompactar o arquivo e abrir o projeto no IntelliJ IDEA.
- Adicionar a dependência do Lombok no arquivo `pom.xml`:
```
<dependencies>
	<dependency>
		<groupId>org.projectlombok</groupId>
		<artifactId>lombok</artifactId>
		<version>1.18.34</version>
		<scope>provided</scope>
	</dependency>
</dependencies>
```
- Criar um banco de dados no PostgreSQL com o nome `seminario_pw45s`. Pode ser utilizado um gerenciador de banco de dados como o DBeaver ou PGAdmin.
- Configurar o arquivo `application.properties` com as informações do banco de dados:
```
# datasource configuration
quarkus.datasource.db-kind=postgresql
quarkus.datasource.username=postgres
quarkus.datasource.password=admin
quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5432/seminario_pw45s
quarkus.hibernate-orm.database.generation=update

# flyway configuration
quarkus.flyway.migrate-at-start=true
quarkus.flyway.baseline-on-migrate=true
quarkus.flyway.baseline-version=1.0.0
quarkus.flyway.schemas=public
quarkus.flyway.table=flyway_quarkus_history
quarkus.flyway.validate-migration-naming=true
quarkus.flyway.out-of-order=true
```

## Desenvolvimento

A entidade Pessoa terá os seguintes atributos: nome, cpf, telefone, rua, numero, complemento, bairro, cep, cidade, estado.
Para ser criada a  tabela no banco de dados, deve ser criado o pacote `db/migration`, dentro do pacote resources, e o arquivo `V1__create_table_pessoa.sql` no pacote recém criado, com o seguinte conteúdo:
```
CREATE TABLE pessoa (
                        id SERIAL PRIMARY KEY,
                        nome VARCHAR(255) NOT NULL,
                        cpf VARCHAR(11) NOT NULL,
                        telefone VARCHAR(11),
                        rua VARCHAR(255),
                        numero VARCHAR(10),
                        complemento VARCHAR(255),
                        bairro VARCHAR(255),
                        cep VARCHAR(8),
                        cidade VARCHAR(255),
                        estado VARCHAR(2)
);
``` 
Para a entidade Pessoa, será criado o pacote `model` e a classe `Pessoa` com os atributos e métodos getters e setters.

## Execução