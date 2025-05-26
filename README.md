# **🎉 Gestão de Eventos e Participantes**
API desenvolvida com Spring Boot e Java, com o objetivo de gerenciar eventos e participantes, permitindo o cadastro, associação entre eles e a consulta via endpoints documentados com Swagger.

## ✨ Descrição do Projeto
API desenvolvida com Spring Boot e Java, com o objetivo de gerenciar eventos e participantes, permitindo o cadastro, edição, exclusão e consulta de ambos. Também é possível realizar a associação entre participantes e eventos, representando uma relação muitos-para-muitos.

A aplicação segue os padrões RESTful e utiliza **Spring Data JPA, MySQL Driver, Validation, Spring Web e Dev Tools**. O banco de dados utilizado é o **MySQL** (gerenciado via MySQL Workbench). A documentação dos endpoints é gerada automaticamente com Swagger, permitindo testes interativos e fácil visualização da API.

## 🎯 Visão Geral
**Back - end:** API RESTful desenvolvida em Java + MYSQL


## 🌳 Estrutura de Pastas (Árvore do Projeto)
```
src/
└── main/
    ├── java/
    │   └── com/
    │       └── gestao/
    │           └── eventos/
    │               ├── controllers/       ← Camada de entrada (REST APIs)
    │               │   └── EventoController.java
    │               │   └── ParticipanteController.java
    │               │
    │               ├── dtos/              ← Objetos de transferência de dados
    │               │   └── EventoDTO.java
    │               │   └── ParticipanteDTO.java
    │               │
    │               ├── entities/          ← Entidades JPA (modelo do banco)
    │               │   └── Eventos.java
    │               │   └── Participantes.java
    │               │
    │               ├── repository/        ← Interfaces que acessam o banco
    │               │   └── EventoRepository.java
    │               │   └── ParticipanteRepository.java
    │               │
    │               ├── services/          ← Lógica de negócio
    │               │   └── EventoService.java
    │               │   └── ParticipanteService.java
    │               │
    │               └── SeuprojetoApplication.java  ← Classe principal do Spring Boot
    │
    └── resources/
        ├── application.properties         ← Configurações da aplicação
        └── static/                        ← (opcional) arquivos estáticos (html, css)
```
## 🔧 Tecnologias Utilizadas
- Java 21
- Spring Boot
- Spring Data JPA
- MYSQL Driver
- Validation
- Spring Web
- Dev Tools
- MYSQL Workbench
- Swagger (Documentação dos endpoints)

## 🚀 Funcionalidades
Tanto no app quanto na API o sistema permite
- ❌ Excluir um evento/participante
- 📖 Documentação interativa com Swagger (API)
- ✏️ Editar dados de um evento/participante
- ➕ Cadastrar um novo evento/participante
