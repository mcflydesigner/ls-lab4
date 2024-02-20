FROM gradle:7.6.1-jdk17 AS build

WORKDIR /usr/tmp/app
COPY --chown=gradle:gradle . /usr/tmp/app

RUN gradle build --no-daemon

FROM openjdk:17-jdk-slim

WORKDIR /usr/src/app

RUN apt-get update && apt-get install -y wget

RUN adduser app && chown -R app /usr/src/app
USER app:app

HEALTHCHECK  --interval=5s --timeout=10s --retries=3 CMD wget --no-verbose --tries=3 --spider http://localhost:8080/actuator/health || exit 1

COPY --from=build --chown=app:app /usr/tmp/app/build/libs/demo-app-0.0.1-SNAPSHOT.jar /usr/src/app/

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./demo-app-0.0.1-SNAPSHOT.jar"]

