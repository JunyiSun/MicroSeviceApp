mvn clean install
mvn package -P start-servers -pl run-app
mvn package -P stop-servers -pl run-app

localhost:5064
