FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp

EXPOSE 80

RUN mkdir /app
COPY build/libs/toolbox-*-SNAPSHOT.jar /app/toolbox.jar

ENTRYPOINT ["java",\
"-XX:+UseContainerSupport",\
"-Dserver.port=80",\
"-jar",\
"/app/toolbox.jar"\
]
