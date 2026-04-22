Smart Campus API
Module ; 5COSC022W.2 – Client Server Architectures
Student name ; Faustyna Szulc
Student ID ; w2081508

Overview ;
This project is a REST API built using JAX-RS (Jersey).It manages rooms and sensors in a smart campus system.
The API allows users to create rooms, register sensors and store sensor readings.
All data is stored in memory using HashMaps (no database).

Base URL ; http://localhost:8080/SmartCampusProject/api/v1

How to Run ;
1. Open project in NetBeans
2. Right click and then Clean and Build
3. Right click and then Run

Sample curl commands ;
Get all rooms = curl http://localhost:8080/SmartCampusProject/api/v1/rooms
Create room = curl -X POST http://localhost:8080/SmartCampusProject/api/v1/rooms \
              -H "Content-Type: application/json" \
              -d '{"id":"67","name":"bedroom","capacity":8}'
Create sensor = curl -X POST http://localhost:8080/SmartCampusProject/api/v1/sensors \
                     -H "Content-Type: application/json" \
                     -d '{"id":"D4","type":"CO2","status":"active","roomId":"21"}'
Filter sensors = curl "http://localhost:8080/SmartCampusProject/api/v1/sensors?type=CO2"
Add reading = curl -X POST http://localhost:8080/SmartCampusProject/api/v1/sensors/S1/readings  \
             -H "Content-Type: application/json" \
             -d '{"value":50.0}'

1.1 JAX-RS creates a new instance of a resource class for every request.
This means objects do not store data between requests.
Because of this, I used a DataStore class with static HashMaps to keep data.
This ensures the data stays available while the server is running.

1.2 HATEOAS means the API returns links to other endpoints.
For example, /api/v1 returns links to rooms and sensors.
This helps developers because they don’t need to remember all URLs.
They can just follow links from the API response.

2.1 Returning only IDs makes responses smaller but requires many extra requests.
Returning full objects gives all data in one request, which is faster overall.
I chose full objects to reduce the number of API calls.

2.2 DELETE is idempotent because repeating it does not change the final state.
First request deletes the room.
Second request returns 404, but the room is still gone.
So the server state stays the same.

3.1 @Consumes(JSON) means the API only accepts JSON.
If a client sends another format, JAX-RS automatically returns 415 Unsupported Media Type.

3.2 Query parameters are better for filtering.
Example: /sensors?type=CO2 This keeps the API flexible and allows multiple filters.

4.1 I used a separate class for sensor readings.
This keeps code organised:
SensorResource = sensors
SensorReadingResource = readings
It makes the code easier to manage.

5.2 422 is better because the request is valid but contains wrong data.
404 would mean the URL is wrong, which is not the case here.

5.4 Returning stack traces exposes internal code structure and libraries used.
This is a security risk.
I used a global exception mapper to return a simple error instead.

5.5 Filters handle logging in one place.
This is better than adding logging in every method.
It keeps the code clean and consistent.

