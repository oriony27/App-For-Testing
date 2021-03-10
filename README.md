# App for testing

This project provides REST APIs for testing.

List of all APIs:

POST /user/createUser

PUT /user/updateUser

GET /user/getAllUsers

GET /user/getUserById

DELETE /user/deleteUser

### How to run

Make sure that you have installed Docker and Docker Compose.

[Docker](https://www.docker.com)

[Docker Compose](https://docs.docker.com/compose/install/)

To run containers execute

```sh
$ sh ./scripts/build.sh
```

To stop containers execute

```sh
$ sh ./scripts/stop.sh
```
