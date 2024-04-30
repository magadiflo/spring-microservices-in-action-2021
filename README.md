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