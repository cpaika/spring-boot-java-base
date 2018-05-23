FROM alphafoobar/open:8u151-jre-alpine3.7

ARG APPLICATION_CONTEXT
ARG JAR_FILE
COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENV APP_CONTEXT "http://localhost/${APPLICATION_CONTEXT}"

CMD ["ntpd", "-s"]
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap","-jar","/app.jar"]

HEALTHCHECK --start-period=90s \
  CMD wget --quiet --tries=1 --spider --timeout=30 ${APP_CONTEXT}1/ping || exit 1
