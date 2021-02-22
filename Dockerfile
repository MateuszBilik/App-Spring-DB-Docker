FROM openjdk:14
WORKDIR /app
COPY target/mateusz-exchange.jar target/mateusz-exchange.jar
COPY DAT_MT_EURUSD_M1_202011.csv DAT_MT_EURUSD_M1_202011.csv
EXPOSE 8085
CMD ["java", "-jar", "target/mateusz-exchange.jar"]