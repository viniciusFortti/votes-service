# votes-service

### Desafio técnico sessões de votação;

### Tecnologias Utilizadas:

- JDK 11
- Gradle
- Lombok
- Spring
- MongoDB
- Kafka
- Swagger

## Organização

MultiProjeto, utilizando separação das camadas(controller, impl, integration), com organização de paths 'by feature'.

- *contract*: endpoints.
- *impl*: regras de negócio e persistência em banco.
- *integration*: integração a serviços externos.

### Kafka Job

- A cada 10 minutos é iniciado um job, que verifica sessões fechadas e sem cálculo de resultados, a cada resultado
  calculado é chamado o kafka producer que cria uma mensagem com as informações.

## Cloud

- kafka(cloudKarafka) - duck plan.
- mongodb(Mlabs) - free plan.

# Rodar Projeto

```
 ./gradlew run
```

## Documentação api's (Swagger)

```
 http://localhost:8080/swagger-ui/
 
```
# Api's V1

## Scripts
- Api's responsáveis pela criação e busca de scripts(pautas de votação).

GET - http://localhost:8080/v1/script/{idScript} -- pathVariable

Reponse :
```json
{
  "idScript": "61805c0188972552a5feeeed",
  "description": "descrição teste",
  "title": "titulo teste"
}
```

PUT - http://localhost:8080/v1/script/create


Request :
```json
{ 
  "id : " "string",
  "description": "string",
  "title": "string" *
}
```
Reponse :
```json
{
"idScript": "61805c0188972552a5feeeed",
"description": "descrição teste",
"title": "titulo teste"
}
```


## Sessions
- Api's responsáveis pela criação e busca de session(sessões de votação).

POST - http://localhost:8080/v1/session/create 
- Caso não seja passado horários de início e fim, adota-se a hora atual em abertura e hora (atual+1minuto) em fechamento.
  
  
Request :
```json
{
  "scriptId": "61805c0188972552a5feeeed", *
  "closingTime": "2021/11/30 00:42",
  "openingTime": "2021/10/28 23:59"
}
```
 Response :
```json
{
  "sessionId": "61805eb4b4327c41c7a80a20",
  "openingTime": "2021-10-28T23:59:00",
  "closingTime": "2021-11-30T00:42:00",
  "scriptId": "61805c0188972552a5feeeed"
}
```

GET - http://localhost:8080/v1/session/{idSession} -- pathVariable

Response :
```json
{
    "sessionId": "61805eb4b4327c41c7a80a20",
    "openingTime": "2021-10-28T23:59:00",
    "closingTime": "2021-11-30T00:42:00",
    "scriptId": "61805c0188972552a5feeeed"
}
```


DELETE - http://localhost:8080/v1/session/{idSession} -- pathVariable
- Deletar uma sessão por id.

Response : 204 NO CONTENT


## VOTES

POST - http://localhost:8080/v1/vote/create
  - criar um novo voto na sessão de votação.

Request :

```json
{
"idSession": "61805eb4b4327c41c7a80a20", *
"associateCpf": "04496482061",*
"vote": "NAO" -- SIM/NAO*
}
```
Response : 204 NO CONTENT

GET - http://localhost:8080/v1/vote/result/{idSession} -- pathVariable
- retorna o resultado da sessão.

Reponse :
```json
{
  "idSession": "61805eb4b4327c41c7a80a20",
  "idScript": "61805c0188972552a5feeeed",
  "votesInFavor": 0,
  "votesAgainst": 1
}
```



