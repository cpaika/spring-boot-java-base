FROM alphafoobar/open:8u151-jre-alpine3.7

ARG guest_java_opts

# Install app
RUN rm -rf /var/jars/*
ADD service/build/install /var/java

EXPOSE 80

ENV JAVA_OPTS "${guest_java_opts}"

CMD ["ntpd", "-s"]
CMD ["/var/java/service/bin/service", "--server.port=80"]

HEALTHCHECK --start-period=90s \
  CMD wget --quiet --tries=1 --spider --timeout=30 http://localhost/1/ping || exit 1
