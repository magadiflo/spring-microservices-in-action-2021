# (Book) Spring Microservices In Action, Second Edition - 2021

Este repositorio corresponde a los temas tratados en el libro **Spring Microservices In Action, Second Edition - 2021**
cuyos autores son **John Carnell y Illary Huaylupo Sánchez.**

---

## [Pág. 4] ¿Qué es un microservicio?

`Un microservicio es un servicio distribuido pequeño y débilmente acoplado`. Los microservicios le permiten tomar una
aplicación extensa y descomponerla en componentes fáciles de administrar con responsabilidades estrictamente definidas.
Los microservicios ayudan a combatir los problemas tradicionales de complejidad en una gran base de código al
descomponerla en partes pequeñas y bien definidas.

Un microservicio tiene las siguientes características:

- La lógica de la aplicación se divide en componentes pequeños con límites de responsabilidad bien definidos y
  coordinados.


- Cada componente tiene un pequeño ámbito de responsabilidad y se implementa independientemente de los demás. Un único
  microservicio es responsable de una parte de un dominio empresarial.


- Los microservicios emplean protocolos de comunicación ligeros como HTTP y JSON (notación de objetos JavaScript) para
  intercambiar datos entre el consumidor del servicio y el proveedor del servicio.


- Debido a que las aplicaciones de microservicio siempre se comunican con un formato tecnológicamente neutral (JSON es
  el más común), la implementación técnica subyacente del servicio es irrelevante. Esto significa que una aplicación
  creada utilizando un enfoque de microservicio se puede construir con múltiples lenguajes y tecnologías.


- Los microservicios, por su naturaleza pequeña, independiente y distribuida, permiten a las organizaciones tener
  equipos de desarrollo más pequeños con áreas de responsabilidad bien definidas. Estos equipos pueden trabajar para
  lograr un único objetivo, como entregar una aplicación, pero cada equipo es responsable únicamente de los servicios en
  los que está trabajando.

La `Figura 1.3` compara un diseño monolítico con un enfoque de microservicios para una pequeña aplicación típica de
comercio electrónico.

![01.monolitico-vs-microservicio.png](./assets/01.monolitico-vs-microservicio.png)

## [Pág. 9] ¿Qué es lo que vamos a construir?

Este libro ofrece una guía paso a paso sobre cómo crear una arquitectura de microservicios completa utilizando Spring
Boot, Spring Cloud y otras tecnologías útiles y modernas. `La Figura 1.4` muestra una descripción general de alto nivel
de algunos de los servicios e integraciones de tecnología que usaremos a lo largo del libro.

![02.what-are-we-building.png](./assets/02.what-are-we-building.png)

`La Figura 1.4` describe una solicitud de un cliente para actualizar y recuperar la información de la organización en la
arquitectura de microservicio que crearemos. Para iniciar la solicitud, el cliente primero debe autenticarse con
Keycloak para obtener un token de acceso. Una vez que se obtiene el token, el cliente realiza una solicitud a Spring
Cloud API Gateway. El servicio API Gateway es el punto de entrada a toda nuestra arquitectura; este servicio se comunica
con el descubrimiento de servicios Eureka para recuperar las ubicaciones del servicio de organización y del servicio de
licencia y luego llama al microservicio específico.

Una vez que la solicitud llega al servicio de la organización, valida el token de acceso con Keycloak para ver si el
usuario tiene permiso para continuar el proceso. Una vez validado, el servicio de la organización actualiza y recupera
su información de la base de datos de la organización y la envía de vuelta al cliente como un HTTP response. Como ruta
alternativa, una vez que se actualiza la información de la organización, el servicio de la organización agrega un
mensaje al topic de Kafka para que el servicio de licencias esté al tanto del cambio.

Cuando el mensaje llega al servicio de licencias, Redis almacena la información específica en la base de datos en
memoria de Redis. A lo largo de este proceso, la arquitectura utiliza seguimiento distribuido de Zipkin, Elasticsearch y
Logstash para administrar y mostrar los registros y emplea Spring Boot Actuator, Prometheus y Grafana para exponer y
mostrar las métricas de la aplicación.

A medida que avancemos veremos temas como Spring Boot, Spring Cloud, Elasticsearch, Logstash, Kibana, Prometheus,
Grafana y Kafka, entre otros. Todas estas tecnologías pueden parecer complicadas, pero veremos cómo crear e integrar los
diferentes componentes que componen el diagrama de la `figura 1.4` a medida que avancemos en el libro.