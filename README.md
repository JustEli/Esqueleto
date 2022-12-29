# Esqueleto
![](https://img.shields.io/badge/Java-17-blue)

### Description
SQL util for Java using HikariCP, to make querying SQL in Java easier.


## Tested adapters

| **Adapter** | **Tested** | **Esqueleto Version** | **Adapter Version** |
|------------|------------|---------------------------|-------------------------|
| MySQL      |      ❌     |                           |                         |
| MariaDB    |      ✅     | latest (always tested)              | [2.7.7 (Maven)](https://mvnrepository.com/artifact/org.mariadb.jdbc/mariadb-java-client/2.7.7) |
| H2         |      ❌     |                           |                         |
| MS SQL     |      ❌     |                           |                         |
| Oracle     |      ❌     |                           |                         |
| SQLite     |      ❌     |                           |                         |
| PostgreSQL |      ❌     |                           |                         |



## Examples

### Open connection
```java
Esqueleto sql = Esqueleto.create(config -> {
    config.setAdapter(SqlAdapter.MARIADB);
    // CREATE DATABASE esqueleto_test;
    config.setDatabase("esqueleto_test");
    // CREATE USER 'esqueleto'@'localhost' IDENTIFIED BY 'dAQ5g61NT';
    // GRANT ALL PRIVILEGES ON esqueleto_test.* TO 'esqueleto'@'localhost';
    config.setUsername("esqueleto");
    config.setPassword("dAQ5g61NT");
}).start();
```
### Update
Returns the inserted id of the signature
```java
Optional<Integer> signatureId = main.sql().statement(
    "INSERT INTO Signature (playerId, signature) VALUES ((SELECT id FROM Player WHERE uniqueId = ?), ?)",
    playerUuid,
    signature
).update().complete(data -> data.next()? data.getInt("id") : null);
```

```java
Company company = ...;
int transactionAmount = ...;

sql.statement("""
    UPDATE Company SET profit = profit + ?
    WHERE id = ?
    """,
    transactionAmount,
    company.getId()
).update().push();
```
### Select
```java
Player player = ...;

Optional<Long> discordId = sql.statement("""
    SELECT discordId
    FROM Player
    WHERE username = ?
    LIMIT 1
    """,
    player.getUsername()
).query().complete(results -> {
    return results.next()? results.get("discordId") : null;
}
```
### Close
```java
sql.close();
```
