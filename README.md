# xsis-test-movies
Ini adalah test project dari Xsis dengan api Movie

## Preparasi
Install Mysql-server di local PC anda, lalu buat database, username, dan password
```sql
CREATE DATABASE xsis;
CREATE USER 'brian'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'brian'@'localhost';
```

Setelah itu config di src/main/resources ubah db(setelah localhost:3306/), username dan password 
```
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/xsis
spring.datasource.username=brian
spring.datasource.password=password
```
Untuk Request Api ada di postman file Xsis.postman_collection.json

## terdiri dari 5 api:
    - GET localhost:8080/api/v1/Movies untuk list
    - GET localhost:8080/api/v1/Movies/<id> untuk get detail
    - POST localhost:8080/api/v1/Movies untuk recreate atau update semua data
    - PATCH localhost:8080/api/v1/Movies untuk Patching kolom tertentu
    - DEL localhost:8080/api/v1/Movies/<id> untuk hapus berdasarkan id

## source code ini terdiri 2 package :
    - main / com.example.xsis -> berisi source code 
        - config -> package yg berisi handlerError
        - controller -> package yg berisi handler URL 
        - service -> package yg berisi bisnis logic interface dan Implementasinya
        - repository -> package yg berisi interface repo connect to db 
        - dto -> package yg berisi class request body atau response body
        - entity -> package yg berisi entity representasi table 
    - test / com.example.xsis -> berisi test code
        - controller -> package yg berisi unit test controller
        - service -> package yg berisi unit test controller
        - repository -> package yg berisi unit test controller

# Run project
Setelah melakukan Preparasi project bisa di run dengan cara dibawah
##  windows 
```
 mvnw.cmd clean spring-boot:run
```
## linux
```
 ./mvnw clean spring-boot:run
```


# Test project 
Project bisa di test dengan menjalankan perintah dibawah
##  windows 
```
 mvnw.cmd test
```
## linux
```
 ./mvnw test
```


# Build Package project 
Project dibuild menjadi object jar dengan perintah dibawah
##  windows 
```
 mvnw.cmd package
```
## linux
```
 ./mvnw package
```
