# primenumber-rest-service
RESTful service which calculates and returns all the prime numbers up to and including a number provided

Technology/API Used : Spring Boot, Jersey, Java8, Cucumber JVM

How to Run it:

1. clone the repository (primenumber-rest-service)

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

primenumber-rest-service/cucumber-report/

Run index.html file in any browser.
