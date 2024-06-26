# Projeto de Exemplo: Arquitetura Hexagonal

Este projeto é um exemplo de arquitetura hexagonal, também conhecida como Arquitetura de Portas e Adaptadores. A arquitetura hexagonal promove a separação de preocupações e facilita a manutenção e evolução do sistema ao longo do tempo.

## Descrição

O projeto consiste em um sistema de CRUD para a gestão de produtos (products) e pedidos (orders), com as seguintes funcionalidades:

- CRUD de Produtos (Product): Permite a criação, leitura, atualização e exclusão de produtos.
- CRUD de Pedidos: (Order): Permite a criação, leitura, atualização e exclusão de pedidos, incluindo a associação de itens de pedido aos produtos correspondentes.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

- **Adapters:**
  - **in:**
    - **controller:** Classes com os endpoins de POST, PUT, DELETE E GET
    - **request:** Classes utilizadas nas requisições de product e order.
  - **out:**
      - **mapper:** Conversão de request para entity e entity para response.
      - **order:** Adapters que implementam as interfaces definidas em application/ports/out/order
      - **product:** Adapters que implementam as interfaces definidas em application/ports/out/product
      - **response:** Classes de resposta para as operações CRUD de product e order.
      - **repository:** Interfaces que implementam JpaRepository ou CrudRepository.
          - **entity:** Classes de entidade mapeadas.

- **Application:**
    - **core:**
      - **domain:** Classes de domínio.
      - **usecase:** Classes com as regras de negócio.
  - **ports:**
  - - **in:**
      - **order:** Interfaces de entrada de order (implementadas pelos usecases de order)
      - **product:** Interfaces de entrada de product (implementadas pelos usecases de product)
    - **out:**
      - **order:** Interfaces de saída de orders (implementadas pelos adpters de order para operações CRUD)
      - **product:** Interfaces de saída de pruducts (implementadas pelos adpters de product para operações CRUD)
- **config:** Configuração dos beans para cada use case.
- **exception:** Exceções customizadas e globais do projeto que respondem a possíveis falhas nas operações CRUD.
 
## Tecnologias Utilizadas

- **Spring Boot:** Framework principal para a construção do aplicativo.
- **Spring Web:** Para construção de aplicações web.
- **Spring Data JPA:** Para a persistência de dados.
- **Lombok:** Para reduzir o código boilerplate.
- **H2 Database:** Banco de dados em memória utilizado para desenvolvimento e testes.
- **Maven:** Gerenciador de dependências e ferramenta de construção do projeto.

## Configuração e Execução

### Pré-requisitos

- Java 8 ou superior
- Maven

### A aplicação estará disponível em http://localhost:8080.

### Exemplos de Endpoints

#### Product
- POST /api/v1/product: Cria um novo produto. 
- GET /api/v1/product: Lista todos os produtos.
- GET /api/v1/product/{id}: Obtém um produto pelo ID.
- PUT /api/v1/product/{id}: Atualiza um produto pelo ID.
- DELETE /api/v1/product/{id}: Exclui um produto pelo ID.

#### Order
- POST api/v1/order: Cria um novo pedido.
- GET api/v1/order: Lista todos os pedidos.
- GET /api/order/{id}: Obtém um pedido pelo ID.
- PUT /api/order/{id}: Atualiza um pedido pelo ID.
- DELETE /api/order/{id}: Exclui um pedido pelo ID.

### Exemplos de JSON para criação e alteração de product:

#### Criar product: (não esqueça de definir o verbo HTTP como POST)
#### BODY:
```
{
  "name": "Geladeira",
  "price": 3250.90
}
```
#### Alterar product: (não esqueça de definir o verbo HTTP como PUT)
http://localhost:8080/api/v1/product/{id}
#### BODY:

```
{
  "name": "Geladeira",
  "price": 3500.00
}
```

#### Criar order: (não esqueça de definir o verbo HTTP como POST)
#### BODY:
```
{
  "customerName": "Cliente 001",
  "items": [
    {
      "product": {
        "id": 1
      },
      "quantity": 2
    },
    {
      "product": {
        "id": 2
      },
      "quantity": 1
    }

  ]
}
```

#### Alterar order: (não esqueça de definir o verbo HTTP como PUT)
http://localhost:8080/api/v1/order/1
#### BODY:
```
{
  "customerName": "Cliente XYZ",
  "items": [
    {
      "product": {
        "id": 1
      },
      "quantity": 5
    } 
  ]
}
```

### Arquivo application.properties
```
spring.application.name=Orders
# ConfiguraÃ§Ã£o do banco de dados H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

### Banco de Dados

O banco de dados H2 é inicializado automaticamente na memória quando a aplicação é executada. Para acessar a console do H2, 
acesse http://localhost:8080/h2-console e utilize as seguintes credenciais:

- JDBC URL: jdbc:h2:mem:testdb
- Username: sa
- Password: (deixe em branco eu informe a senha que você configurou na aplicação)

### Considerações 
Sinta-se à vontade para contribuir com o projeto. Para isso, siga os passos abaixo:

Faça um fork do projeto.
Crie uma branch para sua feature (git checkout -b minha-feature).
Commit suas mudanças (git commit -am 'Adiciona minha feature').
Faça um push para a branch (git push origin minha-feature).
Crie um novo Pull Request.

### Passos para Executar

1.Clone o repositório:
```
   cd seu-repositorio
   git clone https://github.com/birapcampos/springboot-hexagonal-architecture.git
```   
2.Compilação e Execução:
```
mvn clean install
mvn spring-boot:run  
```