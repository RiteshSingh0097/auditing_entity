# auditing_entity
POC to audit entity changes

curl --location --request POST 'http://localhost:8080/data' \
--header 'Content-Type: application/json' \
--data-raw '{
"userName": "riteshsinghxxx@gmail.in",
"address": {
"contact": 99300000
}
}'