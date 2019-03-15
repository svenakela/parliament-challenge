# How to run

## Docker

### In your go-to terminal

Start application:

Run `mvn clean install`  

Take some time to marvel at the 0% test coverage...

Run `docker build -t parliament:v1 .`

Run `docker run -p 8080:8080 parliament:v1`

During startup reconsider life choices and the option to run away and live the rest of your life as a mango farmer in Tahiti...


Get some juicy data:

Run `curl http://localhost:8080/speeches/latest`

Hopefully don't crash due to demo-ghosts...

