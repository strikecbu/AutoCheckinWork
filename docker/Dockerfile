FROM openjdk:8-jre
RUN mkdir /usr/src/myapp
COPY auto-checkin-0.0.1-SNAPSHOT.jar /usr/src/myapp
WORKDIR /usr/src/myapp
CMD ["java", "-jar", "auto-checkin-0.0.1-SNAPSHOT.jar"]