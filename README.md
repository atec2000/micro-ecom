# micro-ecom
Spring cloud based E-commerce project 

Add maven settings.xm file with following docker hub authentication information to ~/.m2
```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                          https://maven.apache.org/xsd/settings-1.0.0.xsd">
  <servers>
    <server>
      <id>docker-hub</id>
      <username>atec2000</username>
      <password>Shenzhen16</password>
      <configuration>
        <email>atec2000@gmail.com</email>
      </configuration>
    </server>
  </servers>
</settings>
```

```bash
mvn clean package docker:build -DskipTests
(mvn clean package docker:build -DskipTests -DpushImage  #If need push to docker-hub)
cd docker
docker-compose up
docker-compose rm -v
cd ..
```

```bash
docker exec -it order-mysql mysql -h localhost -u root -p
mysql> use order
mysql> source /var/lib/mysql/initdata/schema.sql
(Copy schema.sql from order-command/src/main to execution path before executing "source schema.sql")
```

```bash
<!-- create iPhone product and Huawei product -->
$ curl -v --header "Content-Type: application/json" --header "Accept: */*" "http://127.0.0.1:10081/products" -d '[{"id":"1","name":"iPhone X","quantity":"200","unitPrice":"1500.00"},{"id":"2","name":"Huawei Mate Pro 10","quantity":"200","unitPrice":"1300.00"}]'
<!-- search iPhone product from elasticsearch -->
$ curl -v "http://127.0.0.1:9200/product/generic/_search?q=name:iphone&size=5&from=0&pretty=true"
<!-- search product by id from elasticsearch -->
$ curl -v "http://127.0.0.1:9200/product/generic/1"
<!-- search product by id from catalog query #### A microservice can be called by other microservices ##### -->
$ curl -v "http://127.0.0.1:10091/products/1"
<!-- create an order #### A microservice will call catalog query service #### -->
$ curl -v --header "Content-Type: application/json" --header "Accept: */*" "http://127.0.0.1:10061/orders" -d '{"comment":"order comment 1", "lineItems":[{"productId":"1","quantity":"5"},{"productId":"2","quantity":"8"}]}'
```

Check rabbitmq with browser
http://localhost:15672

Check eureka server with browser
http://localhost:8761