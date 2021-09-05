# CryptoCurrencyRouter
# Instruction to run the project
  - Install JDK 8 or higher on your machine
  - Install Maven on your machine
  - Install any IDE Tool ( IntelliJ)
  - Install any Header extension on your browser 

# Steps to run the service
  - apply command (maven clean install)
  - Start the server from the IDE , Server will be up and running on port 9090 , you can view the swagger through this URL
         http://localhost:8081/swagger-ui/index.html#/
# How This Router work 

This is Gateway project that mainly use Zuul to handle the versioning of our service
Zuul Router Differntiate between which service swagger will open based on Request Header Param ( Version ) it either take version1 or version2 
this value represent the service Id of each service based on this value there is a Pre-filter that will intercept the request and add the correct service Id based on value came from header or it will add version2 by default 
