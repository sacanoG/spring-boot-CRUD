FROM java:8
WORKDIR /
ADD ./build/libs/calculator-salary-1.0.0.jar calculator-salary-1.0.0.jar
EXPOSE 8080
CMD java -jar calculator-salary-1.0.0.jar
