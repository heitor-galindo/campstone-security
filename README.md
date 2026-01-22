# Capstone Project - Microservices Architecture

## KAFKA

Create topic

```bash
docker exec -it -w /opt/kafka/bin capstone-security-kafka-1 \
  ./kafka-topics.sh --create \
    --topic user-event \
    --bootstrap-server localhost:9092 \
    --partitions 3 \
    --replication-factor 1
```

Show messages

```bash
docker exec -it -w /opt/kafka/bin capstone-security-kafka-1 \
  ./kafka-console-consumer.sh \
    --bootstrap-server localhost:9092 \
    --topic user-event \
    --group consumer-user \
    --from-beginning
```

## TEST

Get token

```bash
curl --location 'http://localhost:8080/realms/MsSecurity/protocol/openid-connect/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'grant_type=client_credentials' \
--data-urlencode 'client_id=ms-user' \
--data-urlencode 'client_secret=123asd'
```

Create user

```bash
curl --location --request POST 'http://localhost:8086/reservations?studentId=1' \
--header 'Authorization: Bearer xxxxxxxxxxx'
```

Get reservations

```bash
curl --location 'http://localhost:8086/reservations' \
--header 'Authorization: Bearer xxxxxxxxxxxx'
```

Get accounts

```bash
curl --location 'http://localhost:8084/accounts/all' \
--header 'Authorization: Bearer xxxxxxxxxxxx'
```