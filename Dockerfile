FROM openjdk:8u171-jre-alpine3.8

ARG guest_java_opts
ARG spring_profiles=default,production
ARG environment=production
ARG newrelic_enabled=false
ARG jar_file

COPY ${jar_file} app.jar
COPY newrelic-agent-*.jar newrelic/newrelic.jar
COPY newrelic.yml newrelic/newrelic.yml

EXPOSE 8080

ENV JAVA_OPTS "${guest_java_opts} -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -javaagent:newrelic/newrelic.jar -Dnewrelic.config.agent_enabled=${newrelic_enabled} -Dnewrelic.environment=${environment} -Dnewrelic.config.file=/newrelic.yml -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=${spring_profiles}"

ENTRYPOINT exec java ${JAVA_OPTS} -jar app.jar

HEALTHCHECK --start-period=90s \
  CMD wget --quiet --tries=1 --spider --timeout=30 http://localhost:8080/actuator/health || exit 1
