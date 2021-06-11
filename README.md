
# AlgaFood API - Projeto REST/API - Utilizando Spring Boot

<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://">
  </a>
  <h3 align="center">AlgaFood API (REST)</h3>
</p>



<!-- TABLE OF CONTENTS -->

## Tabela de Conteúdo

- [Tabela de Conteúdo](#tabela-de-conte%C3%BAdo)
- [Sobre o Projeto](#sobre-o-projeto)
    - [Feito Com](#feito-com)
- [Começando](#come%C3%A7ando)
    - [Pré-requisitos](#pr%C3%A9-requisitos)
    - [Instalação](#instala%C3%A7%C3%A3o)
    - [Edição](#edi%C3%A7%C3%A3o)
    - [Publicação](#publica%C3%A7%C3%A3o)
- [Contribuição](#contribui%C3%A7%C3%A3o)
- [Licença](#licen%C3%A7a)
- [Contato](#contato)

<!-- ABOUT THE PROJECT -->

## Sobre o Projeto

Projeto AlgaFood API - uma API (REST) para delivery de comida.
Curso: AlgaWorks - Especialista em Spring REST - https://cafe.algaworks.com/lista-espera-spring-rest/

### Feito Com

Tecnologias utilizadas no projeto

- [JAVA](https://www.java.com/pt_BR/download/) - Java é uma linguagem de programação e plataforma computacional lançada pela primeira vez pela Sun Microsystems em 1995. Existem muitas aplicações e sites que não funcionarão, a menos que você tenha o Java instalado, e mais desses são criados todos os dias;
- [Spring Boot](https://spring.io/projects/spring-boot) - O Spring Boot é um projeto da Spring que veio para facilitar o processo de configuração e publicação de nossas aplicações. A intenção é ter o seu projeto rodando o mais rápido possível e sem complicação;
- [Flyway DB](https://flywaydb.org/getstarted/) - Flyway é uma dentre as várias ferramentas que se propõem a trazer ordem e organização para os scripts SQL que são executados no banco de dados, funcionando como um controle de versão do mesmo;


<!-- GETTING STARTED -->

## Começando

Para reproduzir o exemplo, é necessário seguir os requisitos mínimos.

### Pré-requisitos

- Você vai precisar de uma IDE como por exemplo: IntelliJ IDEA, Eclipse, VSCode.
- Instale a JDK 11+
- Instale o Apache Maven 3.5.3+ ou o Gradle

#### Docker
- Escolha um cliente para conectar com o Banco de dados, exemplo: DBeaver
- Cliente para realizar requisições REST: Postman ou o Insomnia.
- Instruções Adicionais:
- Instalação do Docker (Documentação oficial)
- Instalando Docker no windows: (Youtube, ESR)
- Instalando o Docker no Linux: (Youtube: LinuxTips)
- Instalando o Docker no Mac: (Youtube: Wellington Rogati)


#Documentação do Bean Validator

https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#section-builtin-constraints

Dica 1:
```java
@NotBlank - Trata Strings Nulas, Vazias e/ou com espaços em branco

Dica 2: 
```
Validação na variável do Path

```java
Para validar o tipo PathVariable: 
 1 - Anotar o seu controller com @Validated.
2 - Adicionar a validação antes da variável.

@GetMapping("/{id}")
public ResponseEntity<?> obter(@PathVariable @Size(max = 99) Long id) {
//...
}
```
Dica 3: Para validar em cascata, é necessário adicionar a anotação @Valid no objeto do relacionamento.

Dica 4:

Você pode criar grupos de validação. (Exemplo: Id não é obrigatório na inclusão, porém é obrigatório na edição)

```java
@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Restaurante adicionar(
			@RequestBody @Validated(Groups.CadastroRestaurante.class) Restaurante restaurante) {

		try {
			return cadastroRestaurante.salvar(restaurante);
```
Dica 5: Para simplificar, é possível utilizar o ConvertGroup

Dica 6:
A validação ocorre primeiro no message.properties, depois do ValidationsMessage.properties (do Validator)
```java
Restaurante.java

@Valid
	@ConvertGroup(from = Default.class, to = Groups.CozinhaId.class)
	@NotNull
	@ManyToOne
	@JoinColumn(name = "cozinha_id", nullable = false)
	private Cozinha cozinha

```

# Testes de Integração:

para executar os testes de integraçao: mvn verify


# Instalando o plugin do Lombok
Link: https://projectlombok.org/download

## Executando a instância do MariaDB via Docker
```shell
docker run --name algafood-mariadb -it -v ~/Developer/Database_Docker/MariaDB/algafood:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -p 3306:3306 -d mariadb
```


## Para fazer um dump (backup dos dados) do database "algafood" no MySQL, use o seguinte comando:
```sh
mysqldump --host localhost --user root --password --databases algafood > dump.sql
```
## Para criar o database "algafood" a partir do dump, execute o comando:

```sh
mysql --host localhost --user root --password < dump.sql
```

#### Executando a Instância do MySql no Docker

Para iniciar o MySql, basta rodar o comando abaixo (O Docker precisa estar instalado):

```sh
docker run --name algafood-mysql -it -v ~/Developer/Database_Docker/MySQL/algafood:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -p 3306:3306 -d mysql
```

### Dica como customizar os parâmetros de paginação
```
Para fazer isso é simples, no seu application.properties faça:
spring.data.web.pageable.size-parameter: pageSize
```

<!-- CONTRIBUTING -->

## Contribuição

Fique a vontade para contribuir com o projeto.

1. Faça um Fork do projeto
2. Crie uma Branch para sua Feature (`git checkout -b feature/newFeature`)
3. Adicione suas mudanças (`git add .`)
4. Comite suas mudanças (`git commit -m 'Nova funcionalidade para facilitar ...`)
5. Faça o Push da Branch (`git push origin feature/newFeature`)
6. Abra um Pull Request

<!-- LICENSE -->

## Licença

Distribuído sob a licença MIT. Veja `LICENSE` para mais informações.

<!-- CONTACT -->

## Contato

Marcus Paulo - [Github](https://github.com/marcuspaulo)