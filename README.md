## 1. docker-compose.yaml
Avand instalat dockerul, lansam file'ul docker-compose.yaml pentru a ridica instanta de RabbitMQ

## 2. rulam aplicatia
_src/main/java/org/example/springamqp3/ProducerApplication.java_

## 3. rulam requesturile pentru a trimite mesajele in rabbitMQ
_src/main/resources/requests.http_
>Pe localhost:5672 putem gasi randul numit **rabbit-queue**

## rulam serviciul ApplicationConsumer pentru a prelua (citi) mesajel trimise
_https://github.com/whorudude/spring-amqp-listener_
