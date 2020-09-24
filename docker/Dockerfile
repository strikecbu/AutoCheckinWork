FROM openjdk:8-jre
RUN mkdir /usr/src/myapp
COPY auto-checkin-0.0.1-SNAPSHOT.jar /usr/src/myapp
USER root
ENV TZ=Asia/Taipei
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
WORKDIR /usr/src/myapp
CMD ["java", "-jar", "auto-checkin-0.0.1-SNAPSHOT.jar"]