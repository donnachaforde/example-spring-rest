# Readme: example-spring-rest
An example of a RESTful WebServer developed using Spring & SpringBoot.

This simple server acts a Location-Service - it will return details of a physical location given a valid identifier (in the form of a UUID). 



## Requirements

The fully fledged server uses the following:

*   Spring Framework
*	SpringBoot


## Building the project
You will need:

*	Java JDK 8
*	Maven 3.1.1 or higher
*	Git

Clone the project and use Maven to build the server

	$ mvn clean install

  

## Deploying to the cloud

You can deploy the server to CloudFoundry using:

	$ cf push UUIDLocator -p <jar>
	
	
### Browser URL
Open your browser at the following URL for Swagger UI (giving REST interface details):


https://uuidlocator.cfapps.io or just click [here](https://uuidlocator.cfapps.io)	