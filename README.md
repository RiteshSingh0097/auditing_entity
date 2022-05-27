# auditing_entity
POC to audit enitity changes

curl --location --request POST 'http://localhost:8080/data' \
--header 'Content-Type: application/json' \
--data-raw '{
"userName": "riteshsingh@cashify.in",
"address": {
"contact": 9936605203
}
}'