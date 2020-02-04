# JDBC connection to PostgreSQL Checker

## Execution

```
./mvnw compile exec:java -Dexec.args="url [user] [password]"
```

For example:

```
./mvnw compile exec:java -Dexec.args="jdbc:postgresql://poolpostgreseos.marathon.mesos:5432/postgreseos?currentSchema=commandcenter&user=commandcenter&sslcert=/tmp/server.crt&sslkey=/tmp/server.key&sslrootcert=/tmp/root.crt&sslmode=verify-ca&ssl=true&prepareThreshold=0"
```