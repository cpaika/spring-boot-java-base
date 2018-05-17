[![Build Status](https://travis-ci.com/bnc-projects/spring-boot-java-base.svg?branch=master)]

# Spring Boot Java Base

## How tos

### How to update the base image

See [docker README](config/docker/README.md).

### How to: Build and run locally on Docker
1. `./gradlew check installDist -PTAG=version -PBRANCH=branch`
  - Where version is the string that will be displayed in the info page.
  - This is extracted from Git when built on AWS.
  - This `-PTAG=` program argument can be ignored. If it is the version applied will be: `TAG not provided`
  - If you have git installed you can run `./gradlew check installDist -PTAG=$(git log -n 1 --pretty='format:%h')`
  - If you want to define the branch then add `-PBRANCH=$(git branch 2> /dev/null | sed -e '/^[^*]/d' -e 's/* \(.*\)/\1/')`
2. `docker build -t="sbjb" .`
3. `docker run -p 80:80 -m 1536M -i -t "sbjb"`

### How to: Attach remote debugger to service running inside Docker
The `Dockerfile` has an `ARG` defined that can be used to define the debugger connection.

`guest_java_opts` To use this to attach a debugger, set the variable as a build parameter:

```bash
docker build -t="sbjb" --build-arg guest_java_opts='-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005' .
```

You also need to expose the port when you run the Docker image:
```bash
docker run -p 80:80 -p 5005:5005 -m 1536M  -i -t "sbjb"
```

