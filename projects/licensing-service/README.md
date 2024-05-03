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

## 1. Implementar una clase de controlador Spring Boot para mapear un punto final para exponer los puntos finales del servicio de licencias

Antes de empezar a codear nuestro controlador y servicio, necesitamos definir nuestro modelo:

````java

@ToString
@Getter
@Setter
public class License {
    private Integer id;
    private String licenseId;
    private String description;
    private String organizationId;
    private String productName;
    private String licenseType;
}
````

Ahora, crearemos nuestra clase de servicio. Por lo pronto solo retornaremos mensajes desde cada método implementado:

````java

@Service
public class LicenseService {

    public License getLicense(String licenseId, String organizationId) {
        License license = new License();
        license.setId(new Random().nextInt(1000));
        license.setLicenseId(licenseId);
        license.setOrganizationId(organizationId);
        license.setDescription("Software product");
        license.setProductName("Ostock");
        license.setLicenseType("full");
        return license;
    }

    public String createLicense(License license, String organizationId) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = "Este es el POST y el objeto es: %s".formatted(license.toString());
        }
        return responseMessage;
    }

    public String updateLicense(License license, String organizationId) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = "Este es el PUT y el objeto es: %s".formatted(license.toString());
        }
        return responseMessage;
    }

    public String deleteLicense(String licenseId, String organizationId) {
        return "Eliminando licencia con id %s para la organización %s".formatted(licenseId, organizationId);
    }

}
````

Finalmente, implementamos nuestro controlador:

````java
/**
 * {organizationId} es un marcador de posición que indica cómo espera que se parametrice la URL con un
 * OrganizationId pasado en cada llamada. El uso de OrganizationId en la URL le permite diferenciar
 * entre los diferentes clientes que podrían utilizar su servicio.
 */

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/organization/{organizationId}/license")
public class LicenseController {

    private final LicenseService licenseService;

    @GetMapping(path = "/{licenseId}")
    public ResponseEntity<License> getLicense(@PathVariable String organizationId, @PathVariable String licenseId) {
        License license = this.licenseService.getLicense(licenseId, organizationId);
        return ResponseEntity.ok(license);
    }

    @PutMapping
    public ResponseEntity<String> updateLicense(@PathVariable String organizationId, @RequestBody License license) {
        return ResponseEntity.ok(this.licenseService.updateLicense(license, organizationId));
    }

    @PostMapping
    public ResponseEntity<String> createLicense(@PathVariable String organizationId, @RequestBody License license) {
        return ResponseEntity.ok(this.licenseService.createLicense(license, organizationId));
    }

    @DeleteMapping(path = "/{licenseId}")
    public ResponseEntity<String> deleteLicense(@PathVariable String organizationId, @PathVariable String licenseId) {
        return ResponseEntity.ok(this.licenseService.deleteLicense(licenseId, organizationId));
    }

}
````

### Ejecutando implementación

Ejecutamos nuestra aplicación para probar los endpoints implementados. Podemos usar nuestro ide, pero para variar
utilizaré la línea de comando ejecutando la siguiente instrucción de maven en la raíz de nuestro
microservicio `licensing-service`:

````bash
$ .\mvnw spring-boot:run

[INFO] Scanning for projects...
[.....]
[INFO] Attaching agents: []

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.5)

2024-05-02T12:13:52.074-05:00  INFO 8720 --- [licensing-service] [           main] d.m.l.app.LicensingServiceApplication    : Starting LicensingServiceApplication using Java 21.0.1 with PID 8720 (M:\PROGRAMACION\DESARROLLO_JAVA_SPRING\08.book_ms-in-action-2021\spring-microservices-in-action-2021\projects\licensing-service\target\classes started by USUARIO in M:\PROGRAMACION\DESARROLLO_JAVA_SPRING\08.book_ms-in-action-2021\spring-microservices-in-action-2021\projects\licensing-service)
2024-05-02T12:13:52.079-05:00  INFO 8720 --- [licensing-service] [           main] d.m.l.app.LicensingServiceApplication    : No active profile set, falling back to 1 default profile: "default"
2024-05-02T12:13:53.852-05:00  INFO 8720 --- [licensing-service] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-05-02T12:13:53.872-05:00  INFO 8720 --- [licensing-service] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-05-02T12:13:53.873-05:00  INFO 8720 --- [licensing-service] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.20]
2024-05-02T12:13:53.993-05:00  INFO 8720 --- [licensing-service] [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-05-02T12:13:53.994-05:00  INFO 8720 --- [licensing-service] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1843 ms
2024-05-02T12:13:54.955-05:00  INFO 8720 --- [licensing-service] [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint(s) beneath base path '/actuator'
2024-05-02T12:13:55.046-05:00  INFO 8720 --- [licensing-service] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
2024-05-02T12:13:55.064-05:00  INFO 8720 --- [licensing-service] [           main] d.m.l.app.LicensingServiceApplication    : Started LicensingServiceApplication in 3.669 seconds (process running for 4.179)
````

Ahora, usando otra ventana, podemos realizar las llamadas a los endpoints y verificar su funcionamiento:

````bash
$ curl -v http://localhost:8080/v1/organization/optimaGrowth/license/0235431845 | jq
>
< HTTP/1.1 200
< Content-Type: application/json
<
{
  "id": 595,
  "licenseId": "0235431845",
  "description": "Software product",
  "organizationId": "optimaGrowth",
  "productName": "Ostock",
  "licenseType": "full"
}
````

````bash
$ curl -v -X POST -H "Content-Type: application/json" -d "{\"licenseId\": \"0235454846\", \"description\": \"Software product\", \"productName\": \"Teclado\", \"licenseType\": \"full\"}" http://localhost:8080/v1/organization/optimaGrowth/license
>
< HTTP/1.1 200
< Content-Type: text/plain;charset=UTF-8
< Content-Length: 168
< Date: Thu, 02 May 2024 17:27:25 GMT
<
Este es el POST y el objeto es: License(id=null, licenseId=0235454846, description=Software product, organizationId=optimaGrowth, productName=Teclado, licenseType=full)
````

````bash
$ curl -v -X DELETE http://localhost:8080/v1/organization/optimaGrowth/license/0235431845
>
< HTTP/1.1 200
< Content-Type: text/plain;charset=UTF-8
< Content-Length: 72
< Date: Thu, 02 May 2024 17:28:12 GMT
<
Eliminando licencia con id 0235431845 para la organización optimaGrowth
````

## 2. Implementar la internacionalización para que los mensajes se puedan adaptar a diferentes idiomas

La internacionalización conocida como `i18n (abreviatura de "internationalization", ello debido a que entre la primera
i y la última n de dicha palabra hay 18 letras)` es un requisito imprescindible para que tu aplicación pueda adaptarse a
diferentes idiomas. **El objetivo principal aquí es desarrollar aplicaciones que ofrezcan contenido en múltiples
formatos e idiomas.** En esta sección, explicaremos cómo agregar internalización al servicio de licencias que creamos
anteriormente.

[Internacionalización](https://docs.spring.io/spring-boot/reference/features/internationalization.html)

`Spring Boot` admite mensajes localizados para que su aplicación pueda atender a usuarios con diferentes preferencias
de idioma. De forma predeterminada, `Spring Boot` busca la presencia de un `messages` paquete de recursos en la raíz
del `classpath`.

**NOTA**
> La configuración automática se aplica cuando el archivo de propiedades predeterminado para el paquete de recursos
> configurado está disponible (`messages.properties` de forma predeterminada). Si su paquete de recursos contiene solo
> archivos de propiedades específicos del idioma, **deberá agregar el predeterminado**. Si no se encuentra ningún
> archivo de propiedades que coincida con alguno de los nombres base configurados, no habrá ningún `MessageSource`
> configurado automáticamente.

Primero, crearemos una clase de configuración donde agregaremos dos beans: `LocaleResolver` y
un `ResourceBundleMessageSource`.

````java

@Configuration
public class InternationalizationConfig {
    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();   // (1)
        localeResolver.setDefaultLocale(Locale.of("es"));                               // (2)
        return localeResolver;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setUseCodeAsDefaultMessage(true);                                 // (3)
        messageSource.setBasename("i18n/messages");                                     // (4)
        return messageSource;
    }
}
````

**DONDE**

- `(1)`, `AcceptHeaderLocaleResolver` usa el encabezado `Accept-Language` de las solicitudes HTTP para determinar el
  idioma. Este enfoque es más adecuado para servicios REST porque **no depende de sesiones ni de cookies.**
  Los clientes pueden especificar el idioma preferido enviando el encabezado correspondiente.
- `(2)`, establece el idioma español (`es`) como predeterminado.
- `(3)`, como está en `true`, le decimos que no arroje un error si no se encuentra un mensaje, sino que devuelva el
  código del mensaje. Por ejemplo `license.creates.message`.
- `(4)`, establece el nombre base de los archivos de propiedades de idiomas. En este caso estamos indicando que el
  nombre base será `messages` y está ubicado en el classpath dentro del directorio `i18n`.

Ahora, configuraremos los `messages`. Para este ejemplo, usaremos mensajes en inglés y en español.
Para lograr esto, crearemos el directorio `/i18n` donde tendremos agrupados los archivos de mensajes. Este directorio
lo tendremos dentro de la carpeta fuente `/src/main/resources`:

- messages_en.properties
- messages_es.properties

**NOTA**
> Podríamos haber creado también un archivo por defecto `messages.properties`, pero como hemos definido un bean
> llamado `LocalResolver` donde estamos estableciendo nuestro idioma por defecto, entonces ya no es necesario, dado que
> estamos diciendo que por defecto nuestro archivo de idioma será `messages_es.properties`.

Los dos listados siguientes muestran cómo deberían verse los archivos `messages_es.properties`
y `messages_en.properties`.

````properties
license.create.message=¡Licencia creada %s con éxito!
license.update.message=Licencia %s actualizada con éxito!
````

````properties
license.create.message=License created %s successfully!
license.update.message=License %s updated successfully!
````

Ahora que hemos implementado los mensajes y la anotación `@Beans`, podemos actualizar el código en nuestro controlador
o servicio para llamar al recurso del mensaje. La siguiente lista muestra cómo se hace esto.

````java

@RequiredArgsConstructor
@Service
public class LicenseService {

    private final MessageSource message;

    public License getLicense(String licenseId, String organizationId) {
        License license = new License();
        license.setId(new Random().nextInt(1000));
        license.setLicenseId(licenseId);
        license.setOrganizationId(organizationId);
        license.setDescription("Software product");
        license.setProductName("Ostock");
        license.setLicenseType("full");
        return license;
    }

    // Recibe la configuración regional (Locale) como parámetro del método.
    public String createLicense(License license, String organizationId, Locale locale) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);

            // Establece la configuración regional (Locale) recibida para recuperar el mensaje específico.
            responseMessage = this.message.getMessage("license.create.message", null, locale)
                    .formatted(license.toString());
        }
        return responseMessage;
    }

    public String updateLicense(License license, String organizationId) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);

            // Envía una configuración regional (Locale) nula para recuperar el mensaje específico.
            responseMessage = this.message.getMessage("license.update.message", null, LocaleContextHolder.getLocale())
                    .formatted(license.toString());
        }
        return responseMessage;
    }

    public String deleteLicense(String licenseId, String organizationId) {
        // Envía una configuración regional (Locale) nula para recuperar el mensaje específico.
        return this.message.getMessage("license.delete.message", null, LocaleContextHolder.getLocale())
                .formatted(licenseId, organizationId);
    }

}
````

Hay tres cosas importantes a resaltar del código anterior. La primera es que podemos recibir la configuración
regional (Locale) desde el propio controlador. La segunda es que podemos llamar
a `message.getMessage("license.create.message",null,locale)` usando la configuración regional que recibimos por
parámetros, y la tercera cosa a tener en cuenta es que
podemos llamar a `message.getMessage("license.update.message", null, LocaleContextHolder.getLocale())` enviándole la
configuración regional que establecimos por defecto.

`LocaleContextHolder.getLocale()`, devuelve la configuración regional (Locale) asociada con el hilo actual, si la hay,
o la configuración regional predeterminada del sistema en caso contrario. Esto es efectivamente un reemplazo de
`Locale.getDefault()`, capaz de respetar opcionalmente una configuración regional a nivel de usuario.

**Nota:** Este método tiene un respaldo a la configuración regional predeterminada compartida, ya sea a nivel de marco
o a nivel de sistema en todo `JVM`. Si desea verificar el contenido `localeContext` sin formato
(que puede indicar que no hay una configuración regional específica a través de null, use `getLocaleContext()` y
llame a `LocaleContext.getLocale()`.

`LocaleContextHolder.getLocale()`, devuelve la configuración regional actual, o la configuración regional
predeterminada del sistema si no se ha asociado ninguna configuración regional específica con el hilo actual.

Ahora actualicemos nuestro método `createLicense()` en el controlador para recibir el idioma en el
encabezado (`Accept-Language`) de la solicitud con este código:

````java

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/organization/{organizationId}/license")
public class LicenseController {

    private final LicenseService licenseService;

    /* other methods */

    @PostMapping
    public ResponseEntity<String> createLicense(@PathVariable String organizationId,
                                                @RequestBody License license,
                                                @RequestHeader(value = "Accept-Language", required = false) Locale locale) {
        return ResponseEntity.ok(this.licenseService.createLicense(license, organizationId, locale));
    }

    /* another method */
}
````

Algunas cosas a tener en cuenta en el código anterior es que aquí usamos la anotación `@RequestHeader`. La
anotación `@RequestHeader` asigna los parámetros del método con los valores del encabezado de la solicitud. En el
método `createLicense()`, recuperamos la configuración regional (Locale) del encabezado de solicitud `Accept-Language`.
Este parámetro de servicio no es obligatorio, por lo que si no se especifica, usaremos la configuración regional
predeterminada.

**NOTA**
> No existe una regla bien definida sobre cómo utilizar la configuración regional. Nuestra recomendación es analizar tu
> arquitectura y seleccionar la opción que más te convenga. Por ejemplo, si la aplicación de front-end maneja la
> configuración regional, la mejor opción es recibir la configuración regional como parámetro en el método del
> controlador. Pero si administra la configuración regional en el backend, puede usar una configuración regional
> predeterminada.

## Probando la configuración Locale

Enviando la configuración en `en` para obtener los mensajes en inglés a través de la cabecera http `Accept-Language`:

````bash
$ curl -v -X POST -H "Content-Type: application/json" -H "Accept-Language: en" -d "{\"licenseId\": \"0235454846\", \"description\": \"Software product\", \"productName\": \"Teclado\", \"licenseType\": \"full\"}" http://localhost:8080/v1/organization/optimaGrowth/license
>
< HTTP/1.1 200
< Content-Type: text/plain;charset=UTF-8
< Content-Length: 166
< Date: Fri, 03 May 2024 01:13:58 GMT
<
License created License(id=null, licenseId=0235454846, description=Software product, organizationId=optimaGrowth, productName=Teclado, licenseType=full) successfully!
````

Enviando la configuración en `es` para obtener los mensajes en español a través de la cabecera http `Accept-Language`:

````bash
$ curl -v -X POST -H "Content-Type: application/json" -H "Accept-Language: es" -d "{\"licenseId\": \"0235454846\", \"description\": \"Software product\", \"productName\": \"Teclado\", \"licenseType\": \"full\"}" http://localhost:8080/v1/organization/optimaGrowth/license
>
< HTTP/1.1 200
< Content-Type: text/plain;charset=UTF-8
< Content-Length: 166
< Date: Fri, 03 May 2024 01:14:29 GMT
<
¡Licencia creada License(id=null, licenseId=0235454846, description=Software product, organizationId=optimaGrowth, productName=Teclado, licenseType=full) con éxito!
````

En esta prueba llamaremos al endpoint de actualización. En esta prueba no le vamos a mandar la configuración del Locale
por cabecera, dado que el método de actualizar del controlador no está esperando ningún Locale, por lo que el método
`updateLicense()` de la clase de servicio usa el `LocaleContextHolder.getLocale()` para obtener el Locale que definimos
por defecto. Por lo tanto, la configuración que se aplicará será el que definimos por defecto, es decir el idioma en
español.

````bash
$ curl -v -X PUT -H "Content-Type: application/json" -d "{\"licenseId\": \"0235454846\", \"description\": \"Software product\", \"productName\": \"Teclado\", \"licenseType\": \"full\"}" http://localhost:8080/v1/organization/optimaGrowth/license
>
< HTTP/1.1 200
< Content-Type: text/plain;charset=UTF-8
< Content-Length: 169
< Date: Fri, 03 May 2024 01:16:40 GMT
<
Licencia License(id=null, licenseId=0235454846, description=Software product, organizationId=optimaGrowth, productName=Teclado, licenseType=full) actualizada con éxito!
````

Por último, llamaremos al endpoint de eliminar. Esta prueba nos debe devolver el código asociado al
mensaje `license.delete.message`, dado que no tenemos dicha configuración en ningún archivo. El comportamiento por
defecto sería lanzar un error, pero como agregamos la configuración `messageSource.setUseCodeAsDefaultMessage(true)`,
en el bean `ResourceBundleMessageSource`, eso nos permite mostrar la clave usada en lugar de lanzar el error.

````bash
$ curl -v -X DELETE http://localhost:8080/v1/organization/optimaGrowth/license/0235431845
>
< HTTP/1.1 200
< Content-Type: text/plain;charset=UTF-8
< Content-Length: 22
< Date: Fri, 03 May 2024 01:19:18 GMT
<
license.delete.message
````
