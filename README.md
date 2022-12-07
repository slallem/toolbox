
# Toolbox

Useful networking tools for the web.

### Build JAR

```
./gradlew build
```
### Run from java command line

```
java -Dserver.port=8080 -jar build/libs/toolbox-0.0.1-SNAPSHOT.jar
```

### Build (then run) docker image 

```
docker build -t toolbox .
docker run -p 80:80 toolbox
```