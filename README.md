# ea-test
Prerequisite:
You must have the below install on you machine
1. Java 1.8
2. Gradle 4.5 or above
3. Wildfly 11 or above
4. Accessibility to internet 

Build Instruction:
1. Copy the code from root (ea-test) and place it wherever you like it to be on your hard drive (e.g. c:\ea-test)
2. Go to the gradle.properties and change the jbossHome to wherever you have installed the wildfly
3. Type the command on the proejct root to build the project to compile and deploy to the wildfly server
   C:\ea-test> gradle clean build
   
Run Instruction:
1. Go to any browser and type http://localhost:8080/ea-test/cars which should return/render the output as defined by the requirement


NOTE:
1. build.gradle
   The above file is the build file which defines all the plugins, dependancies and repositories for the dependancies, compile instruction
   and deployment instruction

