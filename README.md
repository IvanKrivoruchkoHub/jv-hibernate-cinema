# Cinema
# Table of Contents
* [Project purpose](#purpose)
* [Project structure](#structure)
* [For developer](#developer-start)
* [Authors](#authors)
# <a name="purpose"></a>Project purpose

This is a template for creating an e-cinema.
<hr>
It is a REST application that implements typical functions for an online service for buying tickets to the cinema. 

Available functions for all not authenticated users : 
* registration
* log in
* log out

Available functions for all authenticated users : 
* get all cinema halls
* get all movies
* get all available movie sessions by date
  
Available functions for users with a USER role only: 
* complete order
* get order history
* add ticket to shopping cart 
* get a lists of tickets in user's shopping cart

Available functions for users with an ADMIN role only:
* add cinema halls, movies and movie sessions to database

<hr>

# <a name="structure"></a>Project Structure
* Java 11
* Maven 4.0.0
* Spring 5.2.3.RELEASE
* Spring Security 5.2.2.RELEASE
* Hibernate 5.4.5.Final
* log4j 1.2.17
* maven-checkstyle-plugin 3.1.1
* mysql-connector-java 8.0.19
* Jackson-databind 2.10.2
<hr>

# <a name="developer-start"></a>For developer
Open the project in your IDE.

Add it as maven project.

Configure Tomcat:
* add artifact
* add sdk 11.0.3

Add sdk 11.0.3 in project struсture.

Change a db.url, db.username and db.password in /cinema-project/src/main/resources/db.properties on your own properties.

Change a path in /cinema-project/src/main/resources/log4j.properties. It has to reach your logFile.

Run the project.

You can use Postman for testing it.

By default there are one user with an USER role (login = "user@gmail.com", password = "user") 
and one with an ADMIN role (login = "admin@gmail.com", password = "admin"). 
<hr>

# <a name="authors"></a>Authors
[Ivan Krivoruchko](https://github.com/IvanKrivoruchkoHub)
