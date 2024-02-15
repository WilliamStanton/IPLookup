# **IP Lookup Service by William Stanton**
The IP Lookup Service is my first Web Application which aims to serve users with 
information pertaining to their IP Address as well as any other IP Address, featuring a REST API.

## **Technologies Utilized**
```
Java:
- Spring Framework:
  - Spring Boot
  - Spring MVC (Web/REST)
  - Spring Cloud (Feign Client)

HTML:
- HTML/CSS
  - Thymeleaf
```

## Setup
1) Obtain an IP2Location API Key (https://www.ip2location.io/)
2) Create an env file in the project directory, like so:
```api_key=xxxx```
3) Set desired PORT in application.properties (default 81):
```server.port:81```
4) Run project:
```
mvn clean package
mvn exec:java -Dexec.mainClass="iplookup.IpLookupApplication"
```
  
