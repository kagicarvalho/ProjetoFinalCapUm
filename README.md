# Projeto Final do Capitulo 1 - Bootcamp DevSuperior

## Introduction

>Projeto Spring Boot 2.4.5 contendo um CRUD completo de web services REST para acessar um recurso de clientes, contendo as cinco operações básicas:

> * Busca paginada de recursos
> * Busca de recurso por id
 >* Inserir novo recurso
 >* Atualizar recurso
> * Deletar recurso


## Code Samples

<h1 align="center">
  Entity
</h1>


<p align="left">
  <a href="https://rahuldkjain.github.io/gh-profile-readme-generator">
    <img alt="Entity Client" src="https://lh6.googleusercontent.com/cVsaNj1RpuBJPn36BX6gqDk32nlEg3rdwtlxii0_vs3Ncp2hJo6NIXbBq6SM-oiL4hsD32hZE2HoCHPFHgfPrgpHiI1OWeH3YoJ73JwkkG9T7CBlbqkROCuRfILbtRMxCsaBs2Cs" width="150"  />
  </a>
</p>

```json

Busca paginada de clientes
GET
{{host}}/clients?page=0&linesPerPage=5&direction=ASC&orderBy=id

{
    "content": [
        {
            "id": 1,
            "name": "Caroline Julia Jennifer Figueiredo",
            "cpf": "75178222172",
            "income": 2780.0,
            "birthDate": "1954-04-20T00:00:00Z",
            "children": 3
        },
        {
            "id": 2,
            "name": "Débora Nicole Raimunda Jesus",
            "cpf": "04472861020",
            "income": 3880.0,
            "birthDate": "1992-02-08T00:00:00Z",
            "children": 1
        },
        {
            "id": 3,
            "name": "Ian Emanuel da Mata",
            "cpf": "07696073907",
            "income": 2080.0,
            "birthDate": "1972-10-24T00:00:00Z",
            "children": 1
        },
        {
            "id": 4,
            "name": "Lavínia Vitória Rezende",
            "cpf": "50152298363",
            "income": 3580.0,
            "birthDate": "1980-11-24T00:00:00Z",
            "children": 0
        },
        {
            "id": 5,
            "name": "Sara Isadora Santos",
            "cpf": "15793451234",
            "income": 4580.0,
            "birthDate": "1941-12-17T00:00:00Z",
            "children": 3
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 5,
        "paged": true,
        "unpaged": false
    },
    "last": false,
    "totalElements": 11,
    "totalPages": 3,
    "size": 5,
    "number": 0,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "first": true,
    "numberOfElements": 5,
    "empty": false
}

--------------------------------------------------------------------------------------------------
Busca de cliente por id
GET
{{host}}/clients/8

{
    "id": 8,
    "name": "Gabriel Nicolas Melo",
    "cpf": "87785985839",
    "income": 1850.0,
    "birthDate": "1995-09-20T00:00:00Z",
    "children": 0
}

--------------------------------------------------------------------------------------------------
Inserção de novo cliente
POST
{{host}}/client

{
  "name": "Letícia Bruna da Mata",
  "cpf": "61002531276",
  "income": 5300.0,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 1
}

--------------------------------------------------------------------------------------------------
Atualização de cliente
PUT
{{host}}/clients/11

{
    "id": 11,
    "name": "Letícia Bruna da Mata",
    "cpf": "61002531276",
    "income": 5300.0,
    "birthDate": "1994-07-20T10:30:00Z",
    "children": 2
}

--------------------------------------------------------------------------------------------------
Deleção de cliente
DELETE
{{host}}/clients/11

```
