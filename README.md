# server-manager-test


Running the application \
The application has been dockerized for easy running, simply follow the steps below

1. *Build the app* \
$ gradle build

2. *Build the docker image* \
$ docker build --tag=server-manager:latest

3. *Run the docker image* \
$ docker run -4290:4290 server-manager:latest 
