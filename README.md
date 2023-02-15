# Parking SB

## Table of Contents

1. [Information](#information)
2. [Technologies](#technologies)
3. [Execution](#execution)
4. [Collaboration](#collaboration)
5. [FAQs](#faqs)

## Information

This is a project created with Spring Initializr.

We're using:

Spring Boot to create a REST API with [Open JDK 19](https://jdk.java.net/19/).

Conventional commits to create a commit message. [Conventional commits](https://www.conventionalcommits.org/en/v1.0.0/).

Git Flow to create a branch strategy. [Git Flow](https://nvie.com/posts/a-successful-git-branching-model/).


## Technologies

A list of technologies used within the project:

- [Spring Boot](https://start.spring.io/): Version 3.0.2

## Execution

A little intro about the installation.

Global installation

```javascript
$ sudo pacman -S nodejs npm
// If you want to run node directly with TS without transpile, install ts-node and tslib
$ sudo npm install -g typescript ts-node tslib @types/node
$ tsc --version // typescript version
$ ts-node --version // typescript node version

// To run typescript directly with ts-node
$ ts-node main.ts
```

Poject installation

```javascript
$ sudo pacman -S nodejs npm
// If you want to run node directly with TS without transpile ts-node main.ts, install ts-node and tslib
$ sudo npm install -D typescript ts-node tslib @types/node
$ npx tsc --version // typescript version
$ npx ts-node --version // typescript node version

// To run typescript directly with ts-node
$ npx ts-node main.ts
```

Install nodemon to watch changes using typescript directly.

```javascript
$ sudo npm i -g nodemon // globaly
$ npm i -D nodemon // locally

// Watch ts changes using the demon
$ nodemon main.ts // globally
$ npx nodemon main.ts // locally
```

For this project just install its dependencies and check examples.

```javascript
$ npm install
```

<!-- Side information: To use the application in a special environment use `lorem ipsum` to start -->

## Collaboration

> Just create a pull request if you want to add a new explain using TS.

## FAQs

---

A list of frequently asked questions

1. **This is a question in bold**
   Answer of the first question with _italic words_.
2. **Second question in bold**
   To answer this question we use an unordered list:
