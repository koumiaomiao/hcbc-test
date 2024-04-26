FROM adoptopenjdk/openjdk11
MAINTAINER kmj
LABEL app="hcbc" version="0.0.1" by="kmj"
COPY build/libs/hcbc-0.0.1-SNAPSHOT.jar hcbc.jar
CMD java -jar hcbc.jar