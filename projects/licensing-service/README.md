# Licensing Service

---

## Dependencias

````xml
<!--Spring Boot 3.2.5-->
<!--Java 21-->
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
````

Para verificar las dependencias de Spring incorporadas por Spring Boot en nuestro servicio de licencias, podemos usar el
`dependency:tree` de `Maven goal`.

Ubicados en la raíz del microservicio `licensing-service` ejecutamos el siguiente comando:

````bash
$ .\mvnw dependency:tree
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------< dev.magadiflo:licensing-service >-------------------
[INFO] Building licensing-service 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- dependency:3.6.1:tree (default-cli) @ licensing-service ---
[INFO] dev.magadiflo:licensing-service:jar:0.0.1-SNAPSHOT
[INFO] +- org.springframework.boot:spring-boot-starter-actuator:jar:3.2.5:compile
[INFO] |  +- org.springframework.boot:spring-boot-starter:jar:3.2.5:compile
[INFO] |  |  +- org.springframework.boot:spring-boot:jar:3.2.5:compile
[INFO] |  |  +- org.springframework.boot:spring-boot-autoconfigure:jar:3.2.5:compile
[INFO] |  |  +- org.springframework.boot:spring-boot-starter-logging:jar:3.2.5:compile
[INFO] |  |  |  +- ch.qos.logback:logback-classic:jar:1.4.14:compile
[INFO] |  |  |  |  \- ch.qos.logback:logback-core:jar:1.4.14:compile
[INFO] |  |  |  +- org.apache.logging.log4j:log4j-to-slf4j:jar:2.21.1:compile
[INFO] |  |  |  |  \- org.apache.logging.log4j:log4j-api:jar:2.21.1:compile
[INFO] |  |  |  \- org.slf4j:jul-to-slf4j:jar:2.0.13:compile
[INFO] |  |  +- jakarta.annotation:jakarta.annotation-api:jar:2.1.1:compile
[INFO] |  |  \- org.yaml:snakeyaml:jar:2.2:compile
[INFO] |  +- org.springframework.boot:spring-boot-actuator-autoconfigure:jar:3.2.5:compile
[INFO] |  |  +- org.springframework.boot:spring-boot-actuator:jar:3.2.5:compile
[INFO] |  |  +- com.fasterxml.jackson.core:jackson-databind:jar:2.15.4:compile
[INFO] |  |  |  +- com.fasterxml.jackson.core:jackson-annotations:jar:2.15.4:compile
[INFO] |  |  |  \- com.fasterxml.jackson.core:jackson-core:jar:2.15.4:compile
[INFO] |  |  \- com.fasterxml.jackson.datatype:jackson-datatype-jsr310:jar:2.15.4:compile
[INFO] |  +- io.micrometer:micrometer-observation:jar:1.12.5:compile
[INFO] |  |  \- io.micrometer:micrometer-commons:jar:1.12.5:compile
[INFO] |  \- io.micrometer:micrometer-jakarta9:jar:1.12.5:compile
[INFO] |     \- io.micrometer:micrometer-core:jar:1.12.5:compile
[INFO] |        +- org.hdrhistogram:HdrHistogram:jar:2.1.12:runtime
[INFO] |        \- org.latencyutils:LatencyUtils:jar:2.0.3:runtime
[INFO] +- org.springframework.boot:spring-boot-starter-web:jar:3.2.5:compile
[INFO] |  +- org.springframework.boot:spring-boot-starter-json:jar:3.2.5:compile
[INFO] |  |  +- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:jar:2.15.4:compile
[INFO] |  |  \- com.fasterxml.jackson.module:jackson-module-parameter-names:jar:2.15.4:compile
[INFO] |  +- org.springframework.boot:spring-boot-starter-tomcat:jar:3.2.5:compile
[INFO] |  |  +- org.apache.tomcat.embed:tomcat-embed-core:jar:10.1.20:compile
[INFO] |  |  +- org.apache.tomcat.embed:tomcat-embed-el:jar:10.1.20:compile
[INFO] |  |  \- org.apache.tomcat.embed:tomcat-embed-websocket:jar:10.1.20:compile
[INFO] |  +- org.springframework:spring-web:jar:6.1.6:compile
[INFO] |  |  \- org.springframework:spring-beans:jar:6.1.6:compile
[INFO] |  \- org.springframework:spring-webmvc:jar:6.1.6:compile
[INFO] |     +- org.springframework:spring-aop:jar:6.1.6:compile
[INFO] |     +- org.springframework:spring-context:jar:6.1.6:compile
[INFO] |     \- org.springframework:spring-expression:jar:6.1.6:compile
[INFO] +- org.projectlombok:lombok:jar:1.18.32:compile
[INFO] \- org.springframework.boot:spring-boot-starter-test:jar:3.2.5:test
[INFO]    +- org.springframework.boot:spring-boot-test:jar:3.2.5:test
[INFO]    +- org.springframework.boot:spring-boot-test-autoconfigure:jar:3.2.5:test
[INFO]    +- com.jayway.jsonpath:json-path:jar:2.9.0:test
[INFO]    |  \- org.slf4j:slf4j-api:jar:2.0.13:compile
[INFO]    +- jakarta.xml.bind:jakarta.xml.bind-api:jar:4.0.2:test
[INFO]    |  \- jakarta.activation:jakarta.activation-api:jar:2.1.3:test
[INFO]    +- net.minidev:json-smart:jar:2.5.1:test
[INFO]    |  \- net.minidev:accessors-smart:jar:2.5.1:test
[INFO]    |     \- org.ow2.asm:asm:jar:9.6:test
[INFO]    +- org.assertj:assertj-core:jar:3.24.2:test
[INFO]    |  \- net.bytebuddy:byte-buddy:jar:1.14.13:test
[INFO]    +- org.awaitility:awaitility:jar:4.2.1:test
[INFO]    +- org.hamcrest:hamcrest:jar:2.2:test
[INFO]    +- org.junit.jupiter:junit-jupiter:jar:5.10.2:test
[INFO]    |  +- org.junit.jupiter:junit-jupiter-api:jar:5.10.2:test
[INFO]    |  |  +- org.opentest4j:opentest4j:jar:1.3.0:test
[INFO]    |  |  +- org.junit.platform:junit-platform-commons:jar:1.10.2:test
[INFO]    |  |  \- org.apiguardian:apiguardian-api:jar:1.1.2:test
[INFO]    |  +- org.junit.jupiter:junit-jupiter-params:jar:5.10.2:test
[INFO]    |  \- org.junit.jupiter:junit-jupiter-engine:jar:5.10.2:test
[INFO]    |     \- org.junit.platform:junit-platform-engine:jar:1.10.2:test
[INFO]    +- org.mockito:mockito-core:jar:5.7.0:test
[INFO]    |  +- net.bytebuddy:byte-buddy-agent:jar:1.14.13:test
[INFO]    |  \- org.objenesis:objenesis:jar:3.3:test
[INFO]    +- org.mockito:mockito-junit-jupiter:jar:5.7.0:test
[INFO]    +- org.skyscreamer:jsonassert:jar:1.5.1:test
[INFO]    |  \- com.vaadin.external.google:android-json:jar:0.0.20131108.vaadin1:test
[INFO]    +- org.springframework:spring-core:jar:6.1.6:compile
[INFO]    |  \- org.springframework:spring-jcl:jar:6.1.6:compile
[INFO]    +- org.springframework:spring-test:jar:6.1.6:test
[INFO]    \- org.xmlunit:xmlunit-core:jar:2.9.1:test
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.500 s
[INFO] Finished at: 2024-05-01T18:45:30-05:00
[INFO] ------------------------------------------------------------------------
````

**NOTA**
> Estas dependencias las podemos ver con nuestro propio IDE de IntelliJ IDEA, pero se muestra aquí una manera de cómo
> ver las dependencias que estamos usando actualmente en nuestro proyecto a través de la línea de comandos apoyándonos
> de maven.

