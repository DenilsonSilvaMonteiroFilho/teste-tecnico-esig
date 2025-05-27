# Teste Tecnico ESIG

Este projeto eh uma aplicacao web baseada em Java que utiliza JSF (PrimeFaces) no front-end e Spring Boot no back-end, conectando-se a um banco de dados PostgreSQL.

## ✅ Requisitos para execucao

Antes de iniciar o projeto, eh necessario garantir que os seguintes requisitos estejam atendidos:

- **Java 17** instalado
- **Maven** instalado
- **Banco de Dados PostgreSQL** configurado
- **Arquivo `application.properties`** ajustado com as configuracoes do seu banco de dados

## 🔧 Configuracao do Banco de Dados

Crie um banco de dados no PostgreSQL com o nome desejado e ajuste o arquivo:

```properties
# src/main/resources/application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/nomedobanco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

> ⚠️ Certifique-se de que o banco esteja criado e acessivel antes de executar o sistema.

---

## ▶️ Como executar

1. Clone o projeto:
```bash
git clone https://github.com/DenilsonSilvaMonteiroFilho/teste-tecnico-esig.git
cd teste-tecnico-esig
```

2. Compile o projeto:
```bash
mvn clean install
```

3. Execute o JAR gerado:
```bash
java -jar target/teste-tecnico-esig-0.0.1-SNAPSHOT.jar
```

4. Acesse o sistema no navegador:
```
http://localhost:8080/views/consolidar.xhtml
```

---

## 🧠 O que foi desenvolvido

### ✔ API REST com Spring Boot
Foram utilizadas as seguintes dependencias e tecnologias:

- Spring Boot (Web, JPA, H2 para testes)
- PostgreSQL (producao)
- JSF (JavaServer Faces)
- PrimeFaces (componentes visuais)
- Maven

### ✔ Consolidacao de Salario

Foi implementado um metodo para calcular e consolidar os salarios dos funcionarios com base nos vencimentos associados aos seus cargos.

#### Logica:

- Busca todas as pessoas cadastradas
- Para cada pessoa, busca os vencimentos do cargo correspondente
- Para cada vencimento:
  - Se for **credito**, adiciona ao salario
  - Se for **debito**, subtrai do salario
- Gera uma lista com o nome da pessoa, nome do cargo e salario consolidado
- Apaga os dados antigos de consolidacao e salva os novos no banco

#### Metodo utilizado:

---

## 🖥️ Funcionalidades implementadas

- CRUD completo para as entidades do sistema (Pessoa, Cargo, Vencimento, etc.--Backend--)
- **Tela funcional apenas para CRUD de Pessoa e consolidacao**
- Nas demais telas (placeholder disponivel)

---

## 📄 Licenca

Projeto para fins de teste tecnico. Livre para uso educacional e demonstracoes.
