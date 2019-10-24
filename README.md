# Invillia recruitment challenge

[![Build Status](https://travis-ci.org/shelsonjava/invillia.svg?branch=master)](https://travis-ci.org/shelsonjava/invillia)

![Invillia Logo](https://invillia.com/public/assets/img/logo-invillia.svg)
[Invillia](https://https://www.invillia.com/) - A transformação começa aqui.

The ACME company is migrating their monolithic system to a microservice architecture and you’re responsible to build their MVP (minimum viable product)  .
https://en.wikipedia.org/wiki/Minimum_viable_product

Your challenge is:
Build an application with those features described below, if you think the requirements aren’t detailed enough please leave a comment (portuguese or english) and proceed as best as you can.

You can choose as many features you think it’s necessary for the MVP,  IT’S NOT necessary build all the features, we strongly recommend to focus on quality over quantity, you’ll be evaluated by the quality of your solution.

If you think something is really necessary but you don’t have enough time to implement please at least explain how you would implement it.

## Tasks

Your task is to develop one (or more, feel free) RESTful service(s) to:
* Create a **Store**
* Update a **Store** information
* Retrieve a **Store** by parameters
* Create an **Order** with items
* Create a **Payment** for an **Order**
* Retrieve an **Order** by parameters
* Refund **Order** or any **Order Item**

Fork this repository and submit your code with partial commits.

## Business Rules

* A **Store** is composed by name and address
* An **Order** is composed by address, confirmation date and status
* An **Order Item** is composed by description, unit price and quantity.
* A **Payment** is composed by status, credit card number and payment date
* An **Order** just should be refunded until ten days after confirmation and the payment is concluded.

## Non functional requirements

Your service(s) must be resilient, fault tolerant, responsive. You should prepare it/them to be highly scalable as possible.

The process should be closest possible to "real-time", balancing your choices in order to achieve the expected
scalability.

## Nice to have features (describe or implement):
* Asynchronous processing
* Database
* Docker
* AWS
* Security
* Swagger
* Clean Code




## Desafio de recrutamento da Invillia

[! [Status da compilação] (https://travis-ci.org/shelsonjava/invillia.svg?branch=master)] (https://travis-ci.org/shelsonjava/invillia)

! [Logotipo da Invillia] (https://invillia.com/public/assets/img/logo-invillia.svg)
[Invillia] (https: // https: //www.invillia.com/) - A transformação começa aqui.

A empresa ACME está migrando o sistema monolítico para uma arquitetura de microsserviço e você é responsável por criar o MVP (produto mínimo viável).
https://en.wikipedia.org/wiki/Minimum_viable_product

Seu desafio é:
Crie um aplicativo com os recursos descritos abaixo. Se você acha que os requisitos não são detalhados o suficiente, deixe um comentário (português ou inglês) e proceda da melhor maneira possível.

Você pode escolher quantos recursos achar necessários para o MVP, NÃO é necessário criar todos os recursos, recomendamos enfatizar a qualidade sobre a quantidade, e você será avaliado pela qualidade da sua solução.

Se você acha que algo é realmente necessário, mas não tem tempo suficiente para implementá-lo, pelo menos explique como o implementaria.

## Tarefas

Sua tarefa é desenvolver um (ou mais, sinta-se à vontade) serviços RESTful para:
* Crie uma ** loja **
* Atualize as informações da ** Store **
* Recuperar um ** Store ** pelos parâmetros
* Crie um ** Pedido ** com itens
* Crie um ** Pagamento ** para um ** Pedido **
* Recuperar um ** Pedido ** pelos parâmetros
* Reembolso ** Pedido ** ou qualquer ** Item do Pedido **

Bifurque este repositório e envie seu código com confirmações parciais.

## Regras do negócio

* A ** Store ** é composta por nome e endereço
* Um ** Pedido ** é composto por endereço, data de confirmação e status
* Um ** Item de Pedido ** é composto por descrição, preço unitário e quantidade.
* A ** Pagamento ** é composto por status, número do cartão de crédito e data do pagamento
* Um ** Pedido ** só deve ser reembolsado até dez dias após a confirmação e o pagamento for concluído.

## Requisitos não Funcionais

Seus serviços devem ser resilientes, tolerantes a falhas e responsivos. Você deve prepará-los para serem altamente escaláveis ​​possível.

O processo deve ser o mais próximo possível do "tempo real", equilibrando suas escolhas para atingir o esperado
escalabilidade.

## É bom ter recursos (descrever ou implementar):
* Processamento assíncrono
* Base de dados
* Docker
* AWS
* Segurança
* Swagger
* Código Limpo