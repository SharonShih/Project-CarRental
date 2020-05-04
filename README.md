# Project-CarRental

### CMPE 172 Group Project

- Clone this repo on your terminal, using command:
```terminal
git clone https://github.com/SharonShih/Project-CarRental.git
```
- Open file and go to file `application.properties`
> File Directory: `demo_car_rental/src/main/resources/application.properties`

- Change the following info to your local MySQL username & password
```html
spring.datasource.username= <your username>
spring.datasource.password= <your password>
```
- Make sure you have a Schema name `Car` under your database
- Run the Spring boot file `DemoCarRentalApplication` using Maven (import Pom.xml in your IDE)
- After Spring boot running successfully, go to the server port(on the `application.properties`)
- Typically, it's `9234`. Go to the first page:
```http
localhost:9234/welcome
```
