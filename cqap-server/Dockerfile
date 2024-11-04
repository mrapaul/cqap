# Use an older Ubuntu version as the base image
FROM ubuntu:14.04

# Install Java 7
RUN apt-get update && \
    apt-get install -y software-properties-common && \
    add-apt-repository ppa:openjdk-r/ppa && \
    apt-get update && \
    apt-get install -y openjdk-7-jdk wget && \
    apt-get clean;

# Install Tomcat 7
RUN wget https://archive.apache.org/dist/tomcat/tomcat-7/v7.0.109/bin/apache-tomcat-7.0.109.tar.gz && \
    tar -xvzf apache-tomcat-7.0.109.tar.gz && \
    mv apache-tomcat-7.0.109 /usr/local/tomcat

# Set environment variables for Tomcat
ENV CATALINA_HOME /usr/local/tomcat
ENV PATH $CATALINA_HOME/bin:$PATH

# The application's WAR file (generated from Maven build)
ARG WAR_FILE=target/cqap-server-test.war

# Copy the WAR file to the Tomcat webapps directory
COPY ${WAR_FILE} $CATALINA_HOME/webapps/cqap-server.war

# Expose the necessary port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
