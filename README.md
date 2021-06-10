# ProjektMaj2021 - SpringBootHellProject
individual solo project for school. 
Basic Web-forum-application based on java Spring Boot MVC


## How to open this project - Start here
This program is structured after Model-View-Controller,
where View here is HTML(frontend)

OBS: branch named "InteMaster" is, contrary to its name, the main branch.

Deploy the App locally:

* Clone Repository to desired local destination directory
* Create a Database with MySQL (DATABASE, USERNAME and PASSWORD)
* In application.properties enter the DATABASE, USERNAME and PASSWORD:
```Java
spring.datasource.url=jdbc:mysql://localhost:3306/DATABASE?useSSL=false&serverTimezone=UTC
spring.datasource.username=USERNAME
spring.datasource.password=PASSWORD
```
* Run the project using IntelliJ (IDE) and, in your browser, navigate to URL: localhost:8080


## Technology Stack
* MySQL - Database used

* Java 11 - Java/JDK version used

* Maven - Dependency Management

* Spring Boot - Back-End Framework used with the following dependencies:
    * Spring Boot Starter Data JPA
    * Spring Boot Starter Thymeleaf
    * Spring Boot Starter Web (uses Spring MVC)
    * Spring Boot DevTools
    * MySql Connector Java
    * Spring Boot Starter Test

jQuery - JavaScript Library

IntelliJ - IDE used

## Versioning
* GitHub Desktop for versioning

### Author
Erik Johnsson
___________________________________
* special thanks M.Mobark for providing much help.

