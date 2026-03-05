# Projeto de exemplo de utilização do quarkus framework

Este projeto tem como base o curso de quarkus do professor X, sendo que a partir dele foram feitas mais exemplos de implementações
incluindo a utilização de solução com multiplos projetos, geração de Rest Client a partir do swagger, implantação no docker
com configuração de variaveis de ambiente em .env em um volume.

## Passo a passo para rodar o projeto

### Compilar o projeto org.br.mineradora.library
```shell script
cd library\org.br.mineradora.library
```
```shell script
mvn clean install
```

### Compilar o projeto cotacao\org.br.mineradora.cotacao
```shell script
cd cotacao\org.br.mineradora.cotacao
```
```shell script
mvn clean install
```
Criando imagem docker
```shell script
docker build -f src/main/docker/Dockerfile.jvm -t quarkus/org.br.mineradora.cotacao-jvm .
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/org.br.mineradora.proposta-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
- JDBC Driver - PostgreSQL ([guide](https://quarkus.io/guides/datasource)): Connect to the PostgreSQL database via JDBC

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)

[Related Hibernate with Panache section...](https://quarkus.io/guides/hibernate-orm-panache)


### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
