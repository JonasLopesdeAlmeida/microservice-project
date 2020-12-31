FROM openjdk:11
VOLUME /tmp
ADD ./target/hr-workers-0.0.1-SNAPSHOT.jar hr-workers.jar
ENTRYPOINT ["java","-jar","/hr-workers.jar"]