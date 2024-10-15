# CLIENT HUB
The application allows for the storage and retrieval of information about clients and their associated addresses.

# TECHNOLOGIES/LIBRARIES

* *Java 21*
* *Spring 3.3.4.RELEASE*
* *Lombok*
* *MySQL*
* *Flyway*
* *Feign Client*

# CONFIGURATIONS

The configuration files are located in the directory src/main/resources.

# DATABASE

* Docker Compose has the necessary database configurations. You only need to have Docker installed on your machine and run the command: "docker-compose up". The required image will be downloaded immediately. Flyway is set up to create initial data seeding.

### 3. Test

* The application has unit tests.