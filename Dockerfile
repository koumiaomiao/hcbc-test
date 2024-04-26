FROM 160071257600.dkr.ecr.ap-southeast-2.amazonaws.com/jdk11:latest
MAINTAINER kmj
LABEL app="hcbc" version="0.0.1" by="kmj"
COPY build/libs/hcbc-0.0.1-SNAPSHOT.jar hcbc.jar
CMD java -jar hcbc.jar