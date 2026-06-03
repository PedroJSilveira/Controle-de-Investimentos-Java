# Investment API

API REST desenvolvida em Java com Spring Boot para gerenciamento de investimentos.  
O projeto permite realizar operações básicas de CRUD, seguindo uma estrutura baseada em Arquitetura Limpa.

## 📌 Sobre o projeto

Este projeto foi criado com o objetivo de praticar conceitos de desenvolvimento backend com Java e Spring Boot, aplicando uma organização mais desacoplada através da Arquitetura Limpa.

A aplicação permite cadastrar, listar, atualizar, buscar e remover investimentos.

## 🚀 Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Docker
- Swagger / OpenAPI
- Maven

## 🧱 Arquitetura

O projeto foi refatorado para seguir os princípios da Arquitetura Limpa, separando responsabilidades entre as camadas da aplicação, isso foi feito com o objetivo de estudo sobre a arquitetura limpa.

A ideia principal é manter as regras de negócio isoladas de detalhes externos, como banco de dados, frameworks e interfaces de entrada.

Estrutura geral:

```text
src
 └── main
     └── java
         └── ...
             ├── application
             ├── domain
             └── infrastructure
