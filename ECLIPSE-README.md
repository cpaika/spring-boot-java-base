# How-to setup Eclipse Java IDE
- version: oxygen 3.a

## Howto Checkout projects from Git
- Welcome screen shows option: *Checkout projects from Git*
- Clone URI
  - You can get the URI from GitHub, it seems that Eclipse can only handle the HTTPS version:
    - [GitHub URI](https://github.com/bnc-projects/spring-boot-java-base.git)
  - Select HTTPS from type
  - Ignore port
  - Enter your username and password
  - Save credentials (unless you want to enter them frequently)
- In *Branch Selection*
  - Deselect all (you don't need any lingering remote branches)
  - Select *master*
- In *Local Destination*
  - Choose local directory destination

## Howto import a Gradle project
- Goto File \> Import
- In *Select*
  - Open Gradle and choose *Existing Gradle Project*
- In *Import Gradle Project*
  - Find the project root directory

_Found that the test directories were not correctly configured on import of Gradle into Eclipse_
* This is problematic, but the Gradle plugin can be run from eclipse.

## Howto run Gradle (bootRun) from Eclipse
- Open service / src/main/java/com.bnc.sbjb
- Right click on Application.java
- Navigate to Run As -> Run Configurations
- Right click on Java Application -> Select New
- Select the arguments tag and under VM options put in `-Djavax.net.ssl.trustStore=security/keystore.jks -Dspring.profiles.active=default,localhost`
- Click Run
