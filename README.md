# ⛏️ Projeto Mineradora — Ecossistema Quarkus

Este projeto é um ecossistema de microserviços baseado no framework **Quarkus**, desenvolvido originalmente a partir do curso do professor Vinícius Pereira de Oliveira. A solução foi expandida para demonstrar cenários reais e avançados de arquitetura de software.

## 🚀 Evoluções Aplicadas ao Projeto
* **Multi-Project:** Estrutura baseada em múltiplos projetos interconectados.
* **Contratos OpenAPI:** Geração automatizada de *Rest Client* a partir de arquivos Swagger.
* **Compilação Nativa:** Suporte a builds nativos Linux a partir de ambientes Windows.
* **DevOps & Infra:** Conteinerização completa com Docker, injeção de variáveis via arquivos `.env` e persistência por volumes.

---

## 📊 Diagramas de Arquitetura

### 1. Diagrama Geral do Ecossistema
Abaixo está a representação da topologia dos componentes, centralizados no Gateway BFF para comunicação externa e barramento de eventos interno.

```
                                            [ Cliente / Bruno API ]
                                                    │
                                                    ▼ (Porta 8443)
┌────────────────────────┐┌────────────────────────────────────────────────────────┐
│    Internet            ││                      Gateway BFF                       │
│    awesomeapi.com.br   │└──────┬───────────────────────┬──────────┬──────────────┘
└────┬───────────────────┘       │                       │          │    
     │ (REST)                    │ (REST)                │ (REST)   │
     ▼                           ▼                       ▼          │
┌──────────┐                 ┌──────────┐          ┌──────────┐     │
│ Cotacao  │                 │ Proposta │          │  Report  │     │
└────┬─────┘                 └────┬─────┘          └────┬─────┘     │
     │                            │                     │           │
     └──────────────────┐         │             ┌───────┘           │   
                        ▼         ▼             ▼                   │
                    ┌─────────────────────────────────┐             │
                    │     Apache Kafka (Mensageria)   │             │
                    └─────────────────────────────────┘             │
                                                                    │
                                                                    ▼  (Padrão de Criação)
                                                            ┌────────────┐
                                                            │ Singleton  │
                                                            └────────────┘

[ Infraestrutura de Apoio Comum ]
 ├── 🗄️ MySQL (Camada de Persistência Relacional)
 ├── 🔑 Keycloak (Identity & Access Management - IAM)
 └── 🔍 Jaeger (Distributed Tracing / Rastreamento)
```

### 2. Fluxo de Integração Assíncrona (Apache Kafka)
O ecossistema utiliza mensageria orientada a eventos para garantir o desacoplamento e a resiliência no processamento de dados.

```
┌───────────┐                ┌────────────────┐                ┌─────────────┐
│  Cotacao  │───────────────>│  Tópico Kafka  │───────────────>│  Proposta   │
│  Service  │  (Publica as   │ "cotacao-pool" │  (Consome e    │   Service   │
└───────────┘  cotações)     └────────────────┘   processa)    └──────┬──────┘
                                                                      │
                                                                      │ (Gera evento de
                                                                      │  atualização)
                                                                      ▼
┌───────────┐                ┌────────────────┐                ┌──────┴──────┐
│  Report   │<───────────────│  Tópico Kafka  │<───────────────│  Tópico de  │
│  Service  │  (Consome e    │ "report-topic" │                │  Propostas  │
└───────────┘  consolida)    └────────────────┘                └─────────────┘
```

---

## 🛠️ Stack Tecnológica e Dependências

A arquitetura é composta por serviços que dependem de componentes de infraestrutura integrados. Certifique-se de inicializar os contêineres abaixo antes de rodar os microserviços.

### 1. Inicialização da Infraestrutura Básica
Execute os comandos abaixo para subir o banco de dados e a ferramenta de rastreamento distribuído:

```shell script
# Banco de dados MySQL
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=mysql -e MYSQL_DATABASE=mineradora -p 3306:3306 -d mysql:latest

# Rastreamento distribuído (Jaeger Tracing)
docker run -d --name jaeger \
  -p 5775:5775/udp -p 6831:6831/udp -p 6832:6832/udp \
  -p 5778:5778 -p 16686:16686 -p 14268:14268 -p 14250:14250 \
  -p 9411:9411 -p 4317:4317 -p 4318:4318 \
  jaegertracing/all-in-one:latest
```

### 2. Inicialização dos Serviços de Mensageria e IAM
Acesse as respectivas pastas de configuração para subir o ecossistema do **Kafka** e o gerenciador de identidade **Keycloak**:

```shell script
# Iniciar Apache Kafka
cd config/kafka
docker compose up -d

# Iniciar Keycloak IAM
cd ../keycloak
docker compose up -d
```

---

## 📦 Passos para Compilação e Build dos Microserviços

Siga a ordem de compilação abaixo para garantir que todas as dependências locais compartilhadas sejam resolvidas.

### 📑 Biblioteca Base (Library)
Este componente deve ser o primeiro a ser compilado por fornecer recursos comuns aos demais projetos.
```shell script
cd library/org.br.mineradora.library
mvn clean install
```
### 📑 Biblioteca de Proxy para acesso das API
Este projeto consome APIs REST utilizando um Rest Client gerado automaticamente a partir da especificação OpenAPI (Swagger), o que elimina a necessidade de escrita manual de código de integração e mitiga erros de digitação de endpoints.

```shell script
cd library/org.br.mineradora.rsproxy
mvn clean install
```

##
💡 *Para realizar compilações nativas Linux utilizando um ambiente host Windows, utilize o comando:*
```shell script
./mvnw clean install -Pnative "-Dquarkus.native.container-build=true"
```

### 📊 Guia de Build dos Microserviços
Navegue até a pasta de cada módulo para compilar o código e gerar a imagem Docker correspondente (JVM ou Nativa):

| Microserviço | Comando de Compilação | Docker Build (JVM) | Docker Build (Nativo) |
| :--- | :--- | :--- | :--- |
| **Cotacao** | `cd cotacao/org.br.mineradora.cotacao && mvn clean install` | `docker build -f src/main/docker/Dockerfile.jvm -t quarkus/org.br.mineradora.cotacao-jvm .` | `docker build -f src/main/docker/Dockerfile.native -t quarkus/org.br.mineradora.cotacao .` |
| **Proposta** | `cd proposta/org.br.mineradora.proposta && mvn clean install` | `docker build -f src/main/docker/Dockerfile.jvm -t quarkus/org.br.mineradora.proposta-jvm .` | `docker build -f src/main/docker/Dockerfile.native -t quarkus/org.br.mineradora.proposta .` |
| **Report** | `cd report/org.br.mineradora.report && mvn clean install` | `docker build -f src/main/docker/Dockerfile.jvm -t quarkus/org.br.mineradora.report-jvm .` | `docker build -f src/main/docker/Dockerfile.native -t quarkus/org.br.mineradora.report .` |
| **Singleton** | `cd singleton/org.br.mineradora.singleton && mvn clean install` | `docker build -f src/main/docker/Dockerfile.jvm -t quarkus/org.br.mineradora.singleton-jvm .` | `docker build -f src/main/docker/Dockerfile.native -t quarkus/org.br.mineradora.singleton .` |
| **Gateway BFF** | `cd gateway-bff/org.br.mineradora.gateway-bff && mvn clean install` | `cd ../org.br.mineradora.gateway-bff.run && docker build -f src/main/docker/Dockerfile.jvm -t quarkus/org.br.mineradora.gateway-bff-jvm .` | `docker build -f src/main/docker/Dockerfile.native -t quarkus/org.br.mineradora.gateway-bff .` |

---

## 🐋 Inicialização Completa via Docker Compose

Após a geração das imagens e configuração da infraestrutura base, realize os passos finais para a orquestração completa da aplicação:

1. Crie um volume gerenciado no Docker com o nome `org_br_mineradora`:
   ```shell script
   docker volume create org_br_mineradora
   ```
2. Copie os arquivos de configuração contidos na pasta `config/variaveis_ambiente` para dentro do volume criado.
3. Vá até a raiz do projeto e inicialize toda a aplicação unificada:
   ```shell script
   docker compose up -d
   ```

---

## 🚦 Testes e Consumo da API

* **Porta de Acesso Principal:** A aplicação completa estará disponível e exposta através da porta **`8443`**.
* **Collection para Testes:** Na pasta `collections`, você encontrará um arquivo pronto com a suíte de testes mapeada para o cliente de API **Bruno**. Basta importá-lo para começar a disparar as requirições.