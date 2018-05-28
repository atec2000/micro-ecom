FROM java:8
VOLUME /tmp
ADD *.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 10061 20061
ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,address=20061,server=y,suspend=n","-jar","/app.jar"]