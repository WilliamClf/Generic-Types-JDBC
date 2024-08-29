# Criação e Implementação de tipos genéricos

## Descrição

Este projeto é uma aplicação Java desenvolvida como parte de uma atividade da disciplina de Desenvolvimento Web, no quarto período do curso de Sistemas de Informação da Unimater. O objetivo principal é demonstrar a implementação de um sistema CRUD (Create, Read, Update, Delete) utilizando JDBC para gerenciar informações sobre tipos de produtos e vendas. A aplicação inclui um servidor HTTP simples e classes DAO (Data Access Object) para manipulação de dados.

## Estrutura do Projeto

### 1. `GenericDAOImpl`

A classe `GenericDAOImpl` é uma implementação genérica de DAO que fornece operações básicas para qualquer entidade que estenda a interface `Entity`. Ela é responsável por gerenciar as operações CRUD para qualquer tipo de entidade.

#### Métodos Implementados:
- **`findById(int id)`**: Recupera uma entidade pelo seu ID.
- **`upsert(T entity)`**: Insere uma nova entidade ou atualiza uma existente.
- **`delete(int id)`**: Deleta uma entidade pelo seu ID.

### 2. Extensões da `GenericDAOImpl`

#### 2.1 `ProductDAO`

A classe `ProductDAO` estende `GenericDAOImpl` e é responsável pelas operações CRUD para a entidade `Product`.

#### 2.2 `SaleDAO`

A classe `SaleDAO` estende `GenericDAOImpl` e gerencia as operações CRUD para a entidade `Sale`.

#### 2.3 `SaleItemDAO`

A classe `SaleItemDAO` estende `GenericDAOImpl` e manipula as operações CRUD para a entidade `SaleItem`.

### 3. `App`

A classe `App` contém o método `main` que inicializa o servidor HTTP e conecta-se ao banco de dados. Ela também executa operações CRUD básicas utilizando as classes DAO.

#### Funcionalidades:
- Cria um servidor HTTP na porta 8080 com um contexto para a rota `/helloWorld`, que responde com "Hello World".
- Estabelece uma conexão com o banco de dados MySQL.
- Executa operações CRUD (Create, Read, Update, Delete) nas tabelas `product_type`, `sale_type`, `sale_item_type`, e `product`.

### 4. Estrutura do Banco de Dados

O banco de dados `jdbc2608` contém as seguintes tabelas:

- **`product_type`**: Armazena tipos de produtos.
- **`product`**: Armazena produtos com uma referência para `product_type`.
- **`sale`**: Registra vendas.
- **`sale_type`**: Armazena tipos de venda.
- **`sale_item_type`**: Armazena tipos de itens de venda.
- **`sale_item`**: Armazena itens de venda com referências para `product` e `sale`.

### 5. Scripts SQL

O projeto inclui um script SQL para criar o banco de dados, tabelas e inserir dados de exemplo. O script pode ser usado para configurar o banco de dados necessário para a aplicação.
