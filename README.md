# Parking SB

## Table of Contents

1. [Information](#information)
2. [Technologies](#technologies)
3. [Execution](#execution)
4. [Collaboration](#collaboration)
5. [End Points](#end-points)

## Information

This is a project created with Spring Initializr.

We're using:

Spring Boot to create a REST API with [Open JDK 19](https://jdk.java.net/19/).

Conventional commits to create a commit message. [Conventional commits](https://www.conventionalcommits.org/en/v1.0.0/).

Git Flow to create a branch strategy. [Git Flow](https://nvie.com/posts/a-successful-git-branching-model/).

Semver to create our versioning. [Semver](https://semver.org/).


## Technologies

A list of technologies used within the project:

- [Spring Boot](https://start.spring.io/): Version 3.0.2

## Execution

A little intro about the installation.

1. Clone the repository: `git clone https://github.com/E-AND-L/Parking-SB`
2. Go to the folder: `cd Parking-SB`
3. Run the application: `./mvnw spring-boot:run` or open Intelli J and run the application "remember use Open JDK 19".
4. Test the application: `http://localhost:8080/api`

## End-Points

##### Get vehicles:
`GET: {{url_api}}/vehicles`

##### Add vehicles:
`POST: {{url_api}}/vehicles` body: `{"plate": "abc123","type": "moto"}` Posible type values: `carro, moto`

##### Get records:
`GET: {{url_api}}/records`

##### Add records:
`POST: {{url_api}}/vehicles` body: `{"plate": "123456"}`

##### Update records:
`PUT: {{url_api}}/vehicles` body: `{"plate": "123456"}`

## Collaboration

> Just create a pull request if you want.
