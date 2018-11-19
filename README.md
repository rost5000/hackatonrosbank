Introduction
------------

This is an example of the interaction of the spring-boot application with the android application.

# Project descriptions

Server:

* Spring Boot 2.0.5

* Spring Cloud Services

* JPA:
    * MongoDB
    * MySQL
    * Oracle
    * PostgreSQL
    * H2

    
Comparable with Android 7.0

Server contain information about bills application display information. Server was tested in Amazon Cloud

#  Build and run

## Serer

```
mvn package

java -jar target/$name_of_jar_file
```

## Deploy to the amazon Cloud

```
eb init

eb create --single --database
```

Move to folder .elastic* and change file config.yml by adding the follow text:
```
deploy:
    airfract: target/name_of_application.jar
```

And final deploy jar file:

```
eb deploy
```

If you want to connet to existing database, you have to set an environments:

| Name of environment | Description |
| ------------------- | ----------- |
| SERVER_PORT         | This is port which server will listen |
| CUSTOM_PROFILE      | If you are not in Cloud Foundry environment, you should choose this one (mysql, postgre, oracle, mongodb) and set the next. In default Application use H2 database |
| HOSTNAME_DB         | URL database, default: localhost |
| PORT_DB             | The Port of DB, default port usual |
| USERNAME_DB         | login in default: none      |
| PASSWORD_DB         | Password, default: none |

## Android

This application was built by Android Studio




