# REST API for Acme-Fresh

Application used to generate REST Api for Acme Fresh.In this application user can register either as Grower or Buyer.


<br />

- **Services Offered**

1. User can Register.
2. User can Login and Logout.
3. Can add,update,delete the products.
4. Can list the Products.


<br />


# Tech Stack

<img align="left" src="https://1000logos.net/wp-content/uploads/2020/09/Java-Logo.png" alt="drawing" width="100"/>
<img align="left"  src="https://download.logo.wine/logo/Spring_Framework/Spring_Framework-Logo.wine.png" alt="drawing" width="100"/>
<img src="https://download.logo.wine/logo/MySQL/MySQL-Logo.wine.png" alt="drawing" width="100"/>


<img align = "left" src="https://www.dariawan.com/media/images/tech-spring-boot.width-1024.png" alt="drawing" width="100"/>
<img align="left"  src="https://upload.wikimedia.org/wikipedia/commons/2/22/Hibernate_logo_a.png" alt="drawing" width="100"/>
<img  align="left" src="https://miro.medium.com/max/818/1*zc-LgogGtr7fFHF9e1M8wA.png" alt="drawing" width="100"/>

<img src="https://maven.apache.org/images/maven-logo-white-on-black.purevec.svg" alt="drawing" width="100"/>


<img src="https://zooz.github.io/predator/images/restapi.png" alt="drawing" width="100"/>



<br />


# Spring Security Details

This application requests user login. After launching the application open it in on the browser with http://localhost:8080/swagger-ui/#/ and enter below crediantles.

- User:  user123
- Password:  password123

- **Steps to use the Acme Fresh Api**

- Need to register.
- Need to login.
- while login a Uuid key will be generated. Use this key as entire api's.




# Modules

- Grower
- Buyer


<br />

## Grower Features

- Grower can register.
- Can Login and Logout.
- Can add,update,delete the products.


## Buyer Features

- Grower can register.
- Can Login and Logout.
- Can view list of products.


<br />

# Installation & Run
 - Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```
    server.port=8080

    spring.datasource.url=jdbc:mysql://localhost:3306/acmefresh;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```






