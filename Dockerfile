#FROM gradle:5.4.1-jdk8

FROM docker.io/eclipse-temurin:17

WORKDIR /tmp
ADD . /tmp

RUN gradle build

CMD ["gradle", "clean", "bootRun"]
EXPOSE 3010
