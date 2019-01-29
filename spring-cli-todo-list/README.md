# Spring CLI Todo List

Spring CLI version of [php-samples/todo-list](https://github.com/JahnelGroup/php-samples/tree/master/todo-list).

## Todo List Sample Circut

This application is part of the Todo List sample circut. References to other implementations of a Todo List can be found in [JahnelGroup/challenges/todo-list](https://github.com/JahnelGroup/challenges/tree/master/todo-list).

## Structure 

### File Structure 

The overall file structure is as follows:

```text
/spring-cli-todo-list/
├── templates
│   └── *.html
└── app.groovy
```

### Build Dependencies

Spring CLI uses a technique called [Deduced “grab” Dependencies](https://docs.spring.io/spring-boot/docs/current/reference/html/cli-using-the-cli.html#cli-deduced-grab-annotations) that provide convinent functionality that simplifies and automates the incluction of dependencies in your application. No seperate build or dependency management tools are needed - the **spring** is your build/run tool the **@Grab** annotation is how you define dependencies. 

### Database: H2

This sample uses an H2 in-memory database and hiberante to auto-generate the DDL. 

## Run 

### Prerequisites

The best way to install the Spring Boot CLI is with [SDKMAN!](https://sdkman.io/). First [install SDKMAN!](https://sdkman.io/install) and then [install Spring Boot](https://sdkman.io/sdks#springboot).

### Start

Build the JAR and then run it:

```bash
$ spring jar app.jar *.groovy templates
$ java -jar app.jar
```

Then navigate to http://localhost:8080
