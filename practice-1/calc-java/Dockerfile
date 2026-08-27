FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY calc.java .

RUN javac calc.java

CMD ["java", "calc"]