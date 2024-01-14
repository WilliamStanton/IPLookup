# **IP Lookup Service by William Stanton**
The IP Lookup Service is my first Web Application which aims to serve users with 
information pertaining to their IP Address as well as any other IP Address.

## **Technologies Utilized**
```
Java
Spring Framework
Thymeleaf
Html/Css
Ip2Location API
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
  
