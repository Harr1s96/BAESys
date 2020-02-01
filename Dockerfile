# build from the Maven image
# which has a maven environment configured already
FROM maven:latest

# copy our application in
COPY . /UniversalApp

# change the working directory to where we are building
# the application
WORKDIR /UniversalApp

# use maven to build the application
RUN mvn clean package

# create a new build stage from the Java image
# which has java installed already
FROM java:8

# change the working directory to where the application
# is going to be installed
WORKDIR /UniversalApp

# copy the JAR file that was created in the previous
# build stage to the application folder in this build stage
COPY --from=0 /UniversalApp/target/UniversalApp-0.0.1-SNAPSHOT.jar app.jar

# create an entrypoint to run the application
ENTRYPOINT ["/usr/bin/java", "-jar", "app.jar"]
