# vehicle reservation
 
aplicação do tipo API Web RestFul que permita gerenciar reservas de veículos. 

A aplicação deverá permitir:

Model - 

1. Gerenciar Veículos-CRUD (**Model OK)**
    1. Código
    2. Modelo
    3. Valor diária.
2. Gerenciar Cliente-CRUD  (**Model OK)**
    1. Código
    2. Nome
    3. Endereço
    4. CPF

Controler e Service - 

(Create, Save,  Upade e Delete)

Repository - 

1. Fazer uma reserva de um veículo por um cliente. A reserva deverá ter 
    1. Tem um número - OK
    2. Cliente deverá existir. - OK
    3. Veículo deverá existir. - OK
    4. Data de Início (Deverá ser maior que a data do sistema). Não pode começar no Domingo.
    5. Data de Fim (Deverá ser maiorque a data de Início). Não existe entrega no Domingo.
    6. O total da reserva deverá ser calculado.
    7. Um veículo pode ser reservado várias vezes, porém somente em períodos/datas diferentes.
2. Listar uma reserva pelo número.
3. Listar as reservas de um cliente.
4. Listar as reservas de um veículo


