FROM amazoncorretto:21

WORKDIR /app

COPY build/libs/project-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "project-0.0.1-SNAPSHOT.jar"]