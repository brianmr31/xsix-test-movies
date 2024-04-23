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

terdiri dari 5 api:
    1. GET localhost:8080/api/v1/Movies untuk list
    2. GET localhost:8080/api/v1/Movies/<id> untuk get detail
    3. POST localhost:8080/api/v1/Movies untuk recreate atau update semua data
    4. PATCH localhost:8080/api/v1/Movies untuk Patching kolom tertentu
    5. DEL localhost:8080/api/v1/Movies/<id> untuk hapus berdasarkan id

source code ini terdiri 2 package :
    1. main / com.example.xsis -> berisi source code 
        -. config -> untuk setting handler
    2. test / com.example.xsis -> berisi test code
        -. controller -> untuk unit test controller
        -. service -> untuk unit test controller
        -. repository -> untuk unit test controller
