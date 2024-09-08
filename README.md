To run the application you need to have docker desktop installed and running on your device
To access the swagger to test application you need to access http://localhost:8080/swagger-ui/index.html
You can access database through pg4admin on http://localhost:16543/login?next=/browser/
Credentials for the pg4admin and the database are available in the docker-compose.yml file
For the email function to work you need to access application.properties file and update the username and password for the email. Also update the email in EmailService.java
