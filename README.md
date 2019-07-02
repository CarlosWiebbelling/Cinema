# Cinema
*Make sure you have HSQLDB installed

A project of a cinema in Java, using JavaFX for interface, HSQLDB, iText

Go on /NetBeansProjects/Cinema/dist open a terminal window and run:
   ### Run the server: 
        java -classpath lib/hsqldb.jar org.hsqldb.server.Server &
   ### Run the GUI manager: 
        java -jar lib/hsqldb.jar &

## Enter the following information: 
    Type: HSQL Database Engine Server 
    Driver: org.hsqldb.jdbcDriver 
    URL: jdbc:hsqldb:dsql://localhost/ 
    User: SA Password:
    Run the project;

## Arquivo menu > Sala: Shows the cinema;
    Arquivo menu > Gerar Registro: Create a PDF with the seats in use;
    Arquivo menu > Sair: Close the application;

## Menu cliente > Adicionar: Insert a new user;
    Menu cliente > Deletar: Deletes a user;
    Menu cliente > Atualizar: Updates a user;
    Menu cliente > Procurar: Find a user by CPF;
    Menu cliente > Ver ocupantes: Shows the seats in use;
    Menu cliente > Ver todos: Shows all clients and their information;

## Menu poltronas > Desocupar: Unoccupy the seat;
    Menu poltronas > Ver ocupadas: Shows all seats in use;

## How to use: Create a new user;
    Click on the seat you want to occupy;
    Confirm and tip your CPF;

## Note: 
    A single customer can not occupy two seats. CPF is the primary key;
    To exclude a client, free the seat he occupies;
    The PDF archive is generated in /src directory;
