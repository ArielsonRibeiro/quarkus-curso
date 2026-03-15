# Projeto de exemplo de utilização do quarkus framework

Este projeto tem como base o curso de quarkus do professor Vinícius Pereira de Oliveira, sendo que a partir dele foram feitas mais exemplos de implementações incluindo a utilização de solução com multiplos projetos, geração de Rest Client a partir do swagger, implantação no docker com configuração de variaveis de ambiente em .env em um volume.

## Passo a passo para rodar o projeto

### Compilar o projeto org.br.mineradora.library
```shell script
cd library/org.br.mineradora.library
```
```shell script
mvn clean install
```

## para compilar os projetos em nativos usando windows para nativo linux
```shell script
./mvnw clean install -Pnative "-Dquarkus.native.container-build=true"
```



### Compilar o projeto org.br.mineradora.cotacao
```shell script
cd cotacao/org.br.mineradora.cotacao
```
```shell script
mvn clean install
```
Criando imagem docker
```shell script
docker build -f src/main/docker/Dockerfile.jvm -t quarkus/org.br.mineradora.cotacao-jvm .
```
Criando imagem docker com nativo
```shell script
docker build -f src/main/docker/Dockerfile.native -t quarkus/org.br.mineradora.cotacao .
```

### Compilar o projeto org.br.mineradora.proposta
```shell script
cd proposta/org.br.mineradora.proposta
```
```shell script
mvn clean install
```
Criando imagem docker
```shell script
docker build -f src/main/docker/Dockerfile.jvm -t quarkus/org.br.mineradora.proposta-jvm .
```

### Compilar o projeto org.br.mineradora.report
```shell script
cd report/org.br.mineradora.report
```
```shell script
mvn clean install
```
Criando imagem docker
```shell script
docker build -f src/main/docker/Dockerfile.jvm -t quarkus/org.br.mineradora.report-jvm .
```

### Compilar o projeto org.br.mineradora.singleton
```shell script
cd singleton/org.br.mineradora.singleton
```
```shell script
mvn clean install
```
Criando imagem docker
```shell script
docker build -f src/main/docker/Dockerfile.jvm -t quarkus/org.br.mineradora.singleton-jvm .
```

Criando imagem docker com nativo
```shell script
docker build -f src/main/docker/Dockerfile.native -t quarkus/org.br.mineradora.singleton .
```

### Compilar o projeto org.br.mineradora.gateway-bff
```shell script
cd gateway-bff/org.br.mineradora.gateway-bff
```
```shell script
mvn clean install
```
Criando imagem docker
```shell script
cd ../org.br.mineradora.gateway-bff.run
```

Criando imagem docker
```shell script
docker build -f src/main/docker/Dockerfile.jvm -t quarkus/org.br.mineradora.gateway-bff-jvm .
```
Criando imagem docker com nativo
```shell script
docker build -f src/main/docker/Dockerfile.native -t quarkus/org.br.mineradora.gateway-bff .
```

### Instação de dependências para funcionar

Para o funcionamento pleno da aplicação será necessário instalar postgresql, kafka, jaeger e keycloack.
```shell script
$ docker run --name postgres-container -e POSTGRES_PASSWORD=postgres -d 1234
```

```shell script
docker run -d --name jaeger -p 5775:5775/udp -p 6831:6831/udp -p 6832:6832/udp -p 5778:5778 -p 16686:16686 -p 14268:14268 -p 14250:14250 -p 9411:9411 -p 4317:4317 -p 4318:4318 jaegertracing/all-in-one:latest
```

```shell script
cd config\kafka
docker compose up -d
```

```shell script
cd config\keycloak
docker compose up -d
```

Feito isso criar um volume no docker com nome org_br_mineradora e adicionar a conteudo dentro da pasta config\variaveis_ambiente

depois na pasta inicial do projeto rodar o comando 

```shell script
cd config\keycloak
docker compose up -d
```

com as dependências instaladas, ir na raiz do projeto e executar

```shell script
docker compose up -d
```

com isso será iniciado a aplicação inteira via docker, para acessar usar a porta 8443.
Na pasta collections tem uma collection do Bruno que pode ser utilizada para testes.