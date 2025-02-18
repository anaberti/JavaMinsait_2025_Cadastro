# JavaMinsait_2025_Cadastro

Este projeto é uma API REST para o gerenciamento de cadastro de pessoas e seus respectivos contatos, como telefones, e-mails, endereço e redes sociais.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.4.2**
- **JPA / Hibernate**
- **Banco de Dados:** H2
- **Swagger (OpenAPI)** para documentação da API

## Funcionalidades

A API permite realizar as operações CRUD (Criar, Ler, Atualizar e Deletar) para cadastro de pessoas e seus contatos.

## Como Executar o Projeto

### Pré-requisitos

- JDK 17 ou superior
- Banco de dados H2 configurado

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/anaberti/JavaMinsait_2025_Cadastro.git
   cd JavaMinsait_2025_Cadastro
   ```

2. Compile o projeto usando Maven:
   ```bash
   mvn clean install
   ```

3. Execute o aplicativo:
   ```bash
   mvn spring-boot:run
   ```

## Endpoints

### Pessoas

- **GET /api/pessoas/cpf/{cpf}**  
  Retorna uma pessoa cadastrada de acordo com o CPF informado.

- **GET /api/pessoas/pessoa_id/{pessoa_id}**  
  Retorna uma pessoa cadastrada de acordo com o id informado.

- **GET /api/pessoas**  
  Lista todas as pessoas cadastradas.

  - **GET /api/pessoas/maladireta/{pessoa_id}**  
  Traz informações DTO de uma pessoa com endereço para mala direta.

- **POST /api/pessoas/{pessoa_id}**  
  Cria uma nova pessoa no sistema.

- **PUT /api/pessoas/{pessoa_id}**  
  Atualiza os dados de uma pessoa existente.

- **DELETE /api/pessoas/{pessoa_id}**  
  Deleta uma pessoa do sistema.

### Contatos

- **GET /api/contatos/{contact_id}**  
  Retorna os detalhes de um contato específico por seu id.

- **GET /api/contatos/{pessoa}**  
  Lista os contatos de uma pessoa através da pessoa_id.

- **POST /api/contatos**  
  Cria um novo contato para uma pessoa.

- **PUT /api/contatos/{contact_id}**  
  Atualiza os dados de um contato existente.

- **DELETE /contatos/{contact_id}**  
  Deleta um contato do sistema.


## Documentação da API

Após iniciar o aplicativo, acesse a documentação da API utilizando o Swagger em:

```bash
http://localhost:8080/swagger-ui.html
```


---
