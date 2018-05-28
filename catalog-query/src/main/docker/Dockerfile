FROM java:8
VOLUME /tmp
ADD *.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 10091
ENTRYPOINT ["java","-jar","/app.jar"]