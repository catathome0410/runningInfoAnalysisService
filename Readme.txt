
1. setup mysql data base on local host with the name     runningInformation
2. change the settings in applications.properties to the corresponding properties of mysql on local host,
    IP address, user name and password should match the one specified in application.properties
3. run mvn clean install
4. go to target folder and run fat-JAR
5. use post-man to visit the api

6. implemented API method.GET, POST, DELETE
6.1. deleteByRunningId:  localhost:8080/runningInfo/"runningId"