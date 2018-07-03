[![Build Status](https://travis-ci.com/bnc-projects/spring-boot-java-base.svg?branch=master)](https://travis-ci.com/bnc-projects/spring-boot-java-base)
[![codecov](https://codecov.io/gh/bnc-projects/spring-boot-java-base/branch/master/graph/badge.svg)](https://codecov.io/gh/bnc-projects/spring-boot-java-base)
[![Known Vulnerabilities](https://snyk.io/test/github/bnc-projects/spring-boot-java-base/badge.svg)](https://snyk.io/test/github/bnc-projects/spring-boot-java-base)
# Spring Boot Java Base

## How tos

### Build and Test
For IDEs run one of the following commands before importing into your IDE.

#### IntelliJ
```bash
./gradlew idea
```

#### Eclipse
```bash
./gradlew eclipse
```

#### Build & Test
```bash
./gradlew clean assemble check
```

### How to: Build and run locally on Docker
1. `./gradlew clean assemble check docker -PREPOSITORY_URI=spring-boot-java-base`
2. `docker run -p 8080:8080 -i -t "spring-boot-java-base"`

#### Debug / Profiling
To debug the container locally, add the following line in to the ENTRYPOINT line after `java` and before `-jar`.
```bash
"-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"
```
Once this has been added build and run the docker container locally.

### How to: Build production equivalent container
```bash
./gradlew clean assemble check docker dockerTag -PTAG=$(git rev-parse --verify HEAD --short) -PBRANCH=$(git rev-parse --abbrev-ref HEAD) \
  -PREPOSITORY_URI=${DOCKER_REPO}${IMAGE_NAME}
```

### How to: Override application context
The docker build stage in Gradle accepts a parameter called APPLICATION_CONTEXT, which is passed to Spring boot and used in the Docker container
Healthcheck.

```bash
./gradlew clean assemble check docker \
  -PAPPLICATION_CONTEXT="your-app-context"
```

## For more tasks run
```bash
./gradlew tasks
```
