FROM bncprojects/openjdk:8u171-jre-alpine3.7

ARG guest_java_opts
ARG spring_profiles=default,production
ARG application_context
ARG environment=production
ARG newrelic_enabled=false
ARG jar_file

COPY ${jar_file} app.jar
COPY newrelic-agent-4.1.0.jar newrelic.jar
COPY newrelic.yml newrelic.yml

EXPOSE 8080

ENV APP_CONTEXT "${APPLICATION_CONTEXT}"

ENV APPLICATION_URL "http://localhost:8080${application_context}"

ENV JAVA_OPTS "${guest_java_opts} -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap " + \
"-javaagent:/newrelic.jar -Dnewrelic.config.agent_enabled=${newrelic_enabled} -Dnewrelic.environment=${environment} -Dnewrelic.config.file=/newrelic.yml " + \
 "-Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=${spring_profiles} -Dserver.servlet.context-path=${application_context}"

CMD ["ntpd", "-s"]

ENTRYPOINT ["java", "-jar", "/app.jar"]

HEALTHCHECK --start-period=90s \
  CMD wget --quiet --tries=1 --spider --timeout=30 ${APPLICATION_URL}1/ping || exit 1
