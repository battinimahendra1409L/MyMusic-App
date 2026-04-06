MyMusic-App

Overview:
MyMusic-App is a simple music search and filter microservice built using Spring Boot. It allows users to add songs, store them in MongoDB, and search them efficiently using Elasticsearch.

Technologies Used:
- Java 17
- Spring Boot
- MongoDB
- Elasticsearch
- HTML, CSS, JavaScript

Project Structure:
- Controller layer handles API requests
- Service layer contains business logic
- Repository layer connects with MongoDB and Elasticsearch
- A basic frontend is used to test APIs

Setup Instructions:

1. Clone the repository:
   git clone https://github.com/battinimahendra1409L/MyMusic-App.git

2. Open the project in an IDE (STS / IntelliJ)

3. Start MongoDB:
   Make sure MongoDB is running on localhost:27017

4. Start Elasticsearch:
   Go to Elasticsearch folder and run:
   bin/elasticsearch.bat

5. Configure application.properties:
   spring.data.mongodb.uri=mongodb://localhost:27017/musicdb
   spring.elasticsearch.uris=http://localhost:9200

6. Run the application:
   Run the main Spring Boot class

7. Open the application:
   http://localhost:8080/index.html


API Endpoints:

1. Add Song
   POST /api/songs

   Sample Request:
   {
     "title": "Butta Bomma",
     "artist": "Armaan Malik",
     "language": "Telugu",
     "genre": "Romantic",
     "tags": ["love", "trending"],
     "playCount": 500
   }

2. Get All Songs
   GET /api/songs

3. Search Songs
   GET /api/search

   Examples:
   /api/search?keyword=love
   /api/search?language=Telugu
   /api/search?genre=Romantic
   /api/search?keyword=love&language=Telugu&page=0&size=5

4. Delete Song (if implemented)
   DELETE /api/songs/{id}


Features:
- Add songs to MongoDB
- Automatically index data into Elasticsearch
- Search by keyword (title, artist, tags)
- Filter by language and genre
- Sort by play count
- Pagination support


Assumptions:
- MongoDB and Elasticsearch are running locally
- Elasticsearch security is disabled
- Basic validation is handled in frontend


Future Improvements:
- Add update and delete features in UI
- Improve UI design using React
- Add authentication and security
- Enhance search using advanced Elasticsearch queries


Author:
Mahendra
