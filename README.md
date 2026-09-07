# Mural REST API

API REST para um mural de publicações, desenvolvida em Java com Maven.

## Endpoints

| Método | Rota | Descrição |
|---|---|---|
| GET | `/posts` | Lista as publicações |
| POST | `/posts` | Cria uma publicação |
| GET | `/posts/{id}` | Busca uma publicação |
| DELETE | `/posts/{id}` | Remove uma publicação |

## Conceitos aplicados

- Arquitetura em camadas (controller / service / repository)
- Modelagem de entidades e persistência
- Padrão REST para desenho das rotas

## Como executar

Requisitos: JDK 17+ (ajuste para a sua versão).

```bash
git clone https://github.com/SalvatoreDuke/mural-rest-api.git
cd mural-rest-api
./mvnw spring-boot:run
```

A aplicação sobe em `http://localhost:8080`.

## Tecnologias

Java · Maven · Spring Boot
