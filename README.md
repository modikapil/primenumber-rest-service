# primenumber-rest-service
RESTful service which calculates and returns all the prime numbers up to and including a number provided

Technology/API Used : Spring Boot, Jersey, Java8, Cucumber JVM, JUnit 5, Maven

How to Run it:

1. clone the repository (primenumber-rest-service) -> git clone https://github.com/modikapil/primenumber-rest-service.git

2. GoTo Project (cd primenumber-rest-service/)

3. Run Spring Boot to launch Prime Numbers REST APIs on Embedded Tomcat
   
   mvn spring-boot:run
   
   E.g

   http://localhost:8080/v1/primeNumbers/10000

   http://localhost:8080/v1/primeNumbers/multiThreaded/10000
   
4. Run Acceptance Test:

	mvn test  (will run both unit-tests and acceptance-tests)
	
	Note: Acceptance-test assumes that REST APIs are running on localhost and on port 8080.
	
Also, you can import this project on Eclipse or any IDE.

--------------------------------------------------------

Acceptance-test report also added in the repository (primenumber-rest-service)

primenumber-rest-service/cucumber-pretty.html

Run cucumber-pretty.html file in any browser.


--------------------------------------------------------

## Requirements

- The project must be written in Java 8 or 11; - **Achived**
- The project must use Maven OR Gradle to build, test and run; - **Achived** (Used Maven)
- The project must have unit and integration tests; - **Achived**
- The project must be built upon Spring Boot; **Achived**
- The API must respond with valid JSON; **Achived**
- The API must be appropriately (to your discretion) documented; **Achived**
- You may use any other frameworks or libraries for support e.g. Lombok, Rest Assured etc.; **Achived** (Used Lombok)

## Optional Extensions Achieved
- I have implemented an extra API for better performance using multi threading.
- I have also added acceptance test using cucumber JVM and attached the report as well in html.

## Future Plan
 - I want to deploy this sservice to AWS.

