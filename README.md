<div align="center">

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/jnorgini/dslist/blob/master/LICENSE) 
</div>

<div align="center">

# Full Stack game list web application
<div align="center">

![ezgif-3-5a2ece833fc4-1](https://github.com/jnorgini/dslist/assets/114461353/e8693c5f-68ad-47be-9f1d-8d13bde57bdc)

</div>
</div>

<div align="center">

## Sobre

> Projeto criado durante o intensivão Spring Boot do [Devsuperior](https://github.com/devsuperior/).
> Back-End com Spring Boot, database com H2 (teste) e Postgresql. Front-End com TypeScript, Vite e React.JS. Trata-se de uma aplicação web que permite aos usuários criar e gerenciar uma lista personalizada de jogos.
> [Link de acesso](https://dslist.vercel.app/) <

</div>

##  Pré -requisitos

- [ `Java 17` ](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [ `Apache Maven 3.9.2` ](https://maven.apache.org/download.cgi)
- [ `Spring Boot - STS 4` ](https://spring.io/tools)
- [ `Postgresql - pgAdmin 4` ](https://www.postgresql.org/download/)
- [`Visual Studio Code`](https://code.visualstudio.com/)
- [ `Node.js`](https://nodejs.org/en)
- [`Postman`](https://www.postman.com/)
- [`GIT`](https://git-scm.com/download/win)

## Back-End
- **Spring Data JPA** 
- **Spring Boot Starter Web** 
- **H2 Database Engine**
- **PostgreSQL JDBC Driver**
- **Postman** - testes de endpoints 
- **CrossOrigin** - config
- **Dockerfile**
- **Render** - deploy
- **Mockito e JUnit** - cobertura de testes unitários

## Front-End
- **Vite** 
- **TypeScript**
- **React.js**
- **Node.js**
- **npm**
- **Vercel** deploy

## Mobile

![Screenshot_1](https://github.com/jnorgini/dslist/assets/114461353/00a66cb4-4b7c-4c4b-b6f2-48cdf125cb25)
![Screenshot_2](https://github.com/jnorgini/dslist/assets/114461353/c3dad200-6610-487e-958c-8e680b890769)
![Screenshot_3](https://github.com/jnorgini/dslist/assets/114461353/4ca5ab30-d348-493a-b4bc-a2112d14777f)
![Screenshot_4](https://github.com/jnorgini/dslist/assets/114461353/20ad4289-b941-4378-8a98-afbe415d5f4c)


## Web

![Screenshot_1](https://github.com/jnorgini/dslist/assets/114461353/76bec705-d79f-4f5b-9dfc-f8a398e095e1)
![Screenshot_2](https://github.com/jnorgini/dslist/assets/114461353/e903af71-f3b1-4219-92d6-f5f3f7f92474)
![Screenshot_3](https://github.com/jnorgini/dslist/assets/114461353/7f233bc2-8f32-47b5-b2ea-bf5ddf2d50c8)
![Screenshot_4](https://github.com/jnorgini/dslist/assets/114461353/50bc0b63-21f3-4c76-9bf2-cf8aa0393439)


## Deploy


| Back-End  | [``Render``](https://render.com/)                                                        |
|-----------|-----------------------------------------------------------------------|
| Front-End | [``Vercel``](https://vercel.com/)                                                        |


## Setup

- ### Variáveis de ambiente

| Variável de Ambiente  | Descrição                                                                      |
|-----------------------|--------------------------------------------------------------------------------|
| `APP_PROFILE`          | test `H2`, dev `postgresql` e prod `postgresql - cloud` |
| `DB_URL`          | Configurado especificamente para deploy     |
| `DB_USERNAME`         | Configurado especificamente para deploy               |
| `DB_PASSWORD`         | Configurado especificamente para deploy                   |

## Testes unitários

![Screenshot_1](https://github.com/jnorgini/dslist/assets/114461353/96a7b543-451f-46bb-84af-84286eea0da1)

### Start da aplicação via Spring Boot
- `git clone` https://github.com/jnorgini/dslist.git
- `STS 4` File - import... - Existing Maven Projects - dslist - backend
- selecione a pasta do projeto - Run As - Maven build... no campo Goals digite `clean package` e run
- `Boot Dashboard` dslist Start
- Navegador - [`H2 console`](http://localhost:8080/h2-console/)
- Postman - teste os endpoints `http://localhost:8080` `/games` -> `games/{id}` -> `/lists/{listId}/games`

### Start da aplicação via VS Code
- File - Open Folder... - dslist - frontend
- Vá em src/components/util/system.ts e mude o `BACKEND_URL` para `http://localhost:8080`
- ctrl + ' para abrir o terminal
- No terminal:
  ```
  npm install typescript --save-dev
  ```

  ```
  npm run dev
  ```
- No navegador:
  [``http://localhost:5173/``](http://localhost:5173/)

### Contato
[![Linkedin Badge](https://img.shields.io/badge/-LinkedIn-6633cc?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/juliana-norgini)](https://www.linkedin.com/in/juliana-norgini)
[![Gmail Badge](https://img.shields.io/badge/-jnorgini@gmail.com-6633cc?style=flat-square&logo=Gmail&logoColor=white&link=mailto:jnorgini@gmail.com)](mailto:jnorgini@gmail.com)
