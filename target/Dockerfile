
From maven:3.8.5-openjdk-8 AS BUILD_STAGE

COPY ./ ./

RUN mvn clean package

FROM openjdk:8-jre

COPY --from=BUILD_STAGE  /target/Reimbursment-0.0.1-SNAPSHOT-jar-with-dependencies.jar /Reimbursement_NO_ERV.jar

CMD ["java","-jar","Reimbursement_NO_ERV.jar"]

