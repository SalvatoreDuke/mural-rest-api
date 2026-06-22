# Mural de Recados — API RESTful

API REST para gerenciamento de um Mural de Recados, construída com Spring Boot, JPA/H2 e autenticação JWT.

* Especificação OpenAPI (Swagger) em: http://localhost:8080/swagger-ui/index.html

## Endpoints do Mural de Recados

Os endpoints do mural são **públicos** (não exigem autenticação JWT).

### Listar todas as mensagens
```bash
curl -s http://localhost:8080/api/mensagens | python3 -m json.tool
```

### Buscar mensagem por ID
```bash
curl -s http://localhost:8080/api/mensagens/1 | python3 -m json.tool
```

### Criar nova mensagem
```bash
curl -s -X POST http://localhost:8080/api/mensagens \
  -H "Content-Type: application/json" \
  -d '{"autor": "João", "texto": "Olá, Mural!"}' | python3 -m json.tool
```

### Atualizar mensagem existente
```bash
curl -s -X PUT http://localhost:8080/api/mensagens/1 \
  -H "Content-Type: application/json" \
  -d '{"autor": "João Silva", "texto": "Mensagem atualizada!"}' | python3 -m json.tool
```

### Remover mensagem
```bash
curl -s -X DELETE http://localhost:8080/api/mensagens/1 -w "\nHTTP Status: %{http_code}\n"
```

## Códigos HTTP

| Endpoint | Sucesso | Erro |
|---|---|---|
| `GET /api/mensagens` | `200 OK` | — |
| `GET /api/mensagens/{id}` | `200 OK` | `404 Not Found` |
| `POST /api/mensagens` | `201 Created` | `400 Bad Request` |
| `PUT /api/mensagens/{id}` | `200 OK` | `404` / `400` |
| `DELETE /api/mensagens/{id}` | `204 No Content` | `404 Not Found` |

## Como executar

```bash
./mvnw spring-boot:run
```