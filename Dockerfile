FROM openjdk:14-alpine

COPY ./build/libs/mycode.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]