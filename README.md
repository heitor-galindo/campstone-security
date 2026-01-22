# Capstone Project - Microservices Architecture

## TEST 

ADMIN - CREATE JWT

```bash
curl --location 'http://localhost:8080/realms/MsSecurity/protocol/openid-connect/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Cookie: JSESSIONID=07BA5E947233DEC115F91681CED79F13' \
--data-urlencode 'client_id=gateway' \
--data-urlencode 'client_secret=123asd' \
--data-urlencode 'username=admin' \
--data-urlencode 'password=admin' \
--data-urlencode 'grant_type=password'
```

ADMIN - CREATE ACCOUNT

```bash
curl --location 'http://localhost:8089/user-service/users/create' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICIwbFdFaHhoZ3Y4ZVVSY2VHVllEUEItQ0tEQ1VkdTJlZS1KMXczX1BvcmQwIn0.eyJleHAiOjE3NjkwOTA2NTYsImlhdCI6MTc2OTA5MDM1NiwianRpIjoib25ydHJvOmExN2Q3YjFlLTUwNDMtZTZkOS1lNDY5LWNiZTZkZDgxMWYzYiIsImlzcyI6Imh0dHA6Ly9rZXljbG9hazo4MDgwL3JlYWxtcy9Nc1NlY3VyaXR5Iiwic3ViIjoiNTg4NTZiMWQtMDNiMC00NzEyLWIxMzUtNzQxNjBlZTZkNGMzIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiZ2F0ZXdheSIsInNpZCI6InY2RDl5TmpDb1pxMjgtY2w3ZFdaWmdJRSIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiKiJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsiQURNSU4iXX0sInNjb3BlIjoicHJvZmlsZSBlbWFpbCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6IkFkbWluIEFkbWluIiwicHJlZmVycmVkX3VzZXJuYW1lIjoiYWRtaW4iLCJnaXZlbl9uYW1lIjoiQWRtaW4iLCJmYW1pbHlfbmFtZSI6IkFkbWluIiwiZW1haWwiOiJhZG1pbkBnbWFpbC5jb20ifQ.kUQLm-8-nXO4g-D9mf3jwUnuaF6OmdWoagDCj6YmDjUCvJp0IuyqSl1Y7Q9V-ANISVg2uMsky8k6dttov2bq3UkxcgmEWMCrz_d092F7xw7CIxDAtsJLvVFvrwzkbmSN8PTIUmm-cvLhpZ1GzVCakZ6nWkIDKzrrUtDjKHNMKaEbdw8112v7Pm-ReZKyIJEUeKZF4UQg0r-s42FrJmkrBwfr-1xwbSIQXQo9e2jFSFEurDM3RZVCpURup3N-6Rx29W5lE92M-V3cQu4cKL2kNk6yCfSQsNSgxSDOt3jakfA2v7xWnEzx3UY_5Wnl6EhRNn9vpdWHUTR6slydhRhbYg' \
--header 'Cookie: JSESSIONID=43C5FD0AFBCC451E55E86C93FD856734' \
--data-raw '{
    "userName": "john_carter",
    "email": "john.carter@gmail.com",
    "fullName": "John Carter",
    "phone": "1234567890"
}'
```

USER - CREATE JWT

```bash
curl --location 'http://localhost:8080/realms/MsSecurity/protocol/openid-connect/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Cookie: JSESSIONID=07BA5E947233DEC115F91681CED79F13' \
--data-urlencode 'client_id=gateway' \
--data-urlencode 'client_secret=123asd' \
--data-urlencode 'username=john_carter' \
--data-urlencode 'password=d9bbde22-00bf-4452-a1fb-b52762755d90' \
--data-urlencode 'grant_type=password'
```

USER - GET PERSONAL ACCOUNT

```bash
curl --location 'http://localhost:8089/user-service/users/me' \
--header 'Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICIwbFdFaHhoZ3Y4ZVVSY2VHVllEUEItQ0tEQ1VkdTJlZS1KMXczX1BvcmQwIn0.eyJleHAiOjE3NjkwOTA2ODYsImlhdCI6MTc2OTA5MDM4NiwianRpIjoib25ydHJvOjk3YTUxZmJlLTRiMjMtOGVmNS01ODM4LTMwZWZlZWE1YzdkOCIsImlzcyI6Imh0dHA6Ly9rZXljbG9hazo4MDgwL3JlYWxtcy9Nc1NlY3VyaXR5IiwiYXVkIjoiYWNjb3VudCIsInN1YiI6IjBiMGJkYjk2LTk1NjMtNDZhMi1hOGM4LTM2NDY3NDgxYjc0ZCIsInR5cCI6IkJlYXJlciIsImF6cCI6ImdhdGV3YXkiLCJzaWQiOiJFZzdoeUl1MFNHdU5oUkdkdFowZ25LOHgiLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbIioiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwiZGVmYXVsdC1yb2xlcy1tc3NlY3VyaXR5IiwidW1hX2F1dGhvcml6YXRpb24iLCJVU0VSIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJwcm9maWxlIGVtYWlsIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsIm5hbWUiOiJKb2huIENhcnRlciIsInByZWZlcnJlZF91c2VybmFtZSI6ImpvaG5fY2FydGVyIiwiZ2l2ZW5fbmFtZSI6IkpvaG4iLCJmYW1pbHlfbmFtZSI6IkNhcnRlciIsImVtYWlsIjoiam9obi5jYXJ0ZXJAZ21haWwuY29tIn0.VvDrQHQz-ZBD_YjVYAhB2Ae-qUFT0YJu6tYFxZXtz2AiLR8DCiIYHj8gLO6ORfgKnhPZosTuuPnCAh89ZLZU4fTq9H-HqNo3-Hyqk1puiBCY_uboR2Atr_Uiy23fRuqSTu3KMzLXd2SCpNsl-j5XePbghPVCSRV1mzSV9MFj0uhNS2utTipQ5krbnhrtJzzKMps1O5oi-fHgPCulXlHYK4VsAsVhhWeIXvlz3hTO5176IC7yYwLAwW57i8UGHlh-xZPuc-NdQstK9zh8O33XayEC-jCmKdNSvTBDZy6fu-AQ3VEaGjkcYP0yRNjkpCeSiiNt-ri4Hkgpf8CoikBzWA' \
--header 'Cookie: JSESSIONID=07BA5E947233DEC115F91681CED79F13' \
--data ''
```
