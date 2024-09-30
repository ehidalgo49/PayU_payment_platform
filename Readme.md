PayU challenge for Senior Software Engineer
@Author: Edwin Hidalgo
@Role: Senior Software Engineer


Code Challenge:

A new startup wants to implement a payment platform for processing purchases with credit cards, and you have been hired as a Senior Software engineer to design and implement a first version
(MVP).  
The new service needs to receive all payer’s information to execute the validations required, anti-fraud analysis consuming an external service and send it to the Bank service for finishing the
purchase properly.  
The below diagram shows a context about what Product owners want to.  

• Requirements:
o It must process purchases only with Credit Card   
o It must process Refund operations
o It must store the important data for further process or queries
o It must consume both external services (Bank and Anti-fraud service).  
▪ They could be fake services.

• Submissions:
o Code  
o Manual or instruction to execute the services properly on any Local environment

How Execute:

1. Clone repository
2. Create database
#Command to upload the database with docker:
docker-compose up -d
3. Compile project
mvn clean install
4. Running the application with Spring boot
mvn spring-boot:run
5. Running tests
mvn If you want bst

Notes:
If you want to build the Docker image of the application in JAR
mvn docker:build