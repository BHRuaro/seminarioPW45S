<p align="center">
  <a href="https://pt.quarkus.io">
    <img src="https://quarkus.io/assets/images/brand/quarkus_icon_1024px_default.png" alt="Quarkus" width="150"/>
  </a>
</p>


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

### Entidade Pessoa
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
A classe deve conter a anotação `@Entity` para ser mapeada como uma entidade JPA e a anotação `@Table` para definir o nome da tabela no banco de dados, que é "pessoa".
Juntamente às anotações do Lombok, a declaração da classe fica da seguinte forma:
```
@Table(name = "pessoa")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
```
Os atributos da entidade pessoa devem ser criados conforme a tabela do banco de dados, onde cada atributo é referenciado a uma coluna.
Para isso, ao declarar os atributos, deve ser utilizada a anotação `@Column` para definir o nome da coluna no banco de dados.
O `id` deve ser declarado informadno a anotação `@Id` e `@GeneratedValue(strategy = GenerationType.IDENTITY)` para ser gerado automaticamente.
```
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence_id_pessoa", sequenceName = "sequence_pessoa")
    @Column(name = "id")
    private Integer id;
```
Os demais atributos devem ser declarados conforme a tabela do banco de dados. Exemplo:
```
    @Column(name = "nome")
    private String nome;
```

### Repositório Pessoa

Para o repositório da entidade Pessoa será criado o pacote `repository` e a interface `PessoaRepository` que extende a interface 'JPARepository' do Spring Data JPA.
Como o Quarkus é compatível baseado no framework Spring, é possível utilizar o Spring Data JPA e diversas outras funcionalidades do Spring.


### Serviço Pessoa

Para o serviço da entidade Pessoa será criado o pacote `service` e a classe `PessoaService` que contém os métodos de CRUD da entidade Pessoa.
Os métodos de CRUD são:
C - Create: método `salvar` que recebe um objeto Pessoa e retorna um objeto Pessoa.
R - Read: método `listar` que retorna uma lista de objetos Pessoa.
U - Update: método `atualizar` que recebe um objeto Pessoa e retorna um objeto Pessoa.
D - Delete: método `deletar` que recebe um objeto Pessoa e retorna um objeto Pessoa.

A leitura é realizada em dois métodos, onde um retorna uma lista de objetos Pessoa e o outro retorna um objeto Pessoa conforme o id informado.
```
        public Pessoa getById(Long id) {
            return pessoaRepository.findById(id).get();
        }

        public List<Pessoa> getAll() {
            return pessoaRepository.findAll();
        }
```
É necessário adicionar a anotação '@RequestScoped' para definir que o ciclo de vida de um objeto seja limitado a uma requisição.
Os métodos realizam a chamada do repositório para realizar as operações no banco de dados.

### Recurso Pessoa
O pacote de recurso é responsável por receber as requisições HTTP e chamar os métodos do serviço.
Este deve ser anotado novamanete com `@RequestScoped` para definir que o ciclo de vida de um objeto seja limitado a uma requisição.
A classe ainda deve ser anotada com `@Path(/pessoa)` para definir o caminho do recurso.
Deve ser realizada a injeção do serviço PessoaService para que os métodos do serviço sejam chamados.
Os métodos devem ser anotados com `@GET`, `@POST`, `@PUT` e `@DELETE` para definir o tipo de requisição HTTP.
Por fim, ao criar os métodos, deve ser informado o caminho do recurso e preferencialmente os tipos de conteúdos que serão consumidos e produzidos.
```
    @GET
    @Path("/getAll")
    @Produces("application/json")
    public List<Pessoa> getAll() {
        try {
            return pessoaService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
```

## Execução
O IntelliJ IDEA possui um plugin para o Quarkus que permite a execução da aplicação Quarkus, portanto é apenas selecionar o plugin nas configurações de execução.
Ao executar será criada a tabela de pessoa devido ao flyway e a aplicação estará disponível para acesso no endereço `http://localhost:8080` para testes do postman .