# API Web de Vendas - Spring Boot & JPA
[![License](https://img.shields.io/github/license/PCantarin/workshop-springboot4-jpa)](https://github.com/PCantarin/workshop-springboot4-jpa/blob/main/LICENSE)

# Sobre o Projeto

Esta é uma API web desenvolvida para simular o backend de um **sistema de vendas**. O projeto foca na implementação da arquitetura em camadas e na persistência de objetos complexos em bancos de dados relacionais.

Desenvolvido durante o curso de Java Completo do professor [Nélio Alves](https://github.com/acenelio), o projeto aplica conceitos avançados de orientação a objetos e mapeamento objeto-relacional (ORM).

##Funcionalidades Principais

### Gestão de Usuários
- **CRUD Completo:** Consulta, inserção, atualização e deleção de usuários.
- **Tratamento de Exceções:** Respostas personalizadas para recursos não encontrados e erros.

### Catálogo e Vendas
- **Produtos e Categorias:** Consulta de produtos com mapeamento muitos-para-muitos.
- **Pedidos (Orders):** Visualização de pedidos, status e itens de pedido.
- **Pagamentos:** Registro e consulta de informações de pagamento associadas aos pedidos.

## Arquitetura do Sistema

O projeto segue o padrão de **Camadas**, garantindo separação de responsabilidades e facilidade de manutenção:

1. **Controller:** Controladores REST que expõem os endpoints da API.
2. **Service:** Camada de lógica de negócio.
3. **Repository:** Camada de acesso a dados (Spring Data JPA).



## Tecnologias Utilizadas

- **Linguagem:** Java 21
- **Framework:** Spring Boot 4
- **Persistência:** Spring Data JPA / Hibernate
- **Banco de Dados:** H2 (Testes/Dev)
- **Gerenciador de Dependências:** Maven

## Modelo de Domínio

![Domain Model](https://github.com/PCantarin/workshop-springboot4-jpa/blob/main/assets/domain_model.png)
