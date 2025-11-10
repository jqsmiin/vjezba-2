# Hotel Reservation System - Lab 2

A Spring Boot application for managing hotels, rooms, and reservations with PostgreSQL database integration.

## Features

### Models
- **Hotel (Model A)**: Manages hotel information (name, city, address, stars)
- **Room (Model B)**: Manages room details (number, type, price, availability)
- **Reservation (Model C)**: Manages guest reservations (guest info, dates, price, status)

### Relationships
- **Hotel ↔ Room**: One-to-Many relationship (one hotel has multiple rooms)
- **Hotel ↔ Reservation**: One-to-Many relationship (one hotel has multiple reservations)

### Controllers
1. **AppController**: Thymeleaf-based controller for Hotels and Rooms with full CRUD operations
2. **ReservationController**: Thymeleaf-based controller for Reservations with full CRUD operations
3. **ReservationRestController**: REST API controller for JSON responses

### Available Endpoints

#### Web Interface (Thymeleaf)
- `/a` - List all hotels
- `/a/new` - Create new hotel
- `/a/edit/{id}` - Edit hotel
- `/a/delete/{id}` - Delete hotel
- `/a/action/{id}` - View hotel details with rooms
- `/b` - List all rooms
- `/c` - List all reservations
- `/c/new` - Create new reservation
- `/c/edit/{id}` - Edit reservation
- `/c/delete/{id}` - Delete reservation

#### REST API (JSON)
- `GET /api/reservations` - Get all reservations
- `GET /api/reservations/{id}` - Get reservation by ID
- `GET /api/reservations/hotel/{hotelId}` - Get reservations by hotel
- `GET /api/reservations/status/{status}` - Get reservations by status
- `POST /api/reservations` - Create new reservation
- `PUT /api/reservations/{id}` - Update reservation
- `DELETE /api/reservations/{id}` - Delete reservation

## Prerequisites

- Java 21 or higher
- Maven 3.6+
- PostgreSQL 12 or higher

## Database Setup

1. Install PostgreSQL if not already installed

2. Create a database:
```sql
CREATE DATABASE hotel_db;
```

3. Update database credentials in `src/main/resources/application.properties` if needed:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/hotel_db
spring.datasource.username=postgres
spring.datasource.password=postgres
```

## Running the Application

1. Clone the repository:
```bash
git clone <repository-url>
cd vjezba-2
```

2. Build the project:
```bash
mvnw clean install
```

3. Run the application:
```bash
mvnw spring-boot:run
```

4. Access the application:
- Web interface: http://localhost:8080/a
- REST API: http://localhost:8080/api/reservations

## Sample Data

The application automatically initializes with sample data:
- 3 Hotels (Zagreb, Split, Dubrovnik)
- 8 Rooms (distributed across hotels)
- 4 Sample Reservations

## Technologies Used

- **Spring Boot 3.5.7**: Application framework
- **Spring Data JPA**: Database access
- **Hibernate**: ORM
- **PostgreSQL**: Relational database
- **Thymeleaf**: Server-side template engine
- **Spring Web**: REST API
- **Lombok**: Reduce boilerplate code
- **Maven**: Build tool

## Project Structure

```
vjezba-2/
├── src/
│   ├── main/
│   │   ├── java/com/example/vjezba2/
│   │   │   ├── config/
│   │   │   │   └── DataInitializer.java
│   │   │   ├── controller/
│   │   │   │   ├── AppController.java
│   │   │   │   ├── ReservationController.java
│   │   │   │   └── ReservationRestController.java
│   │   │   ├── model/
│   │   │   │   ├── Hotel.java
│   │   │   │   ├── Room.java
│   │   │   │   └── Reservation.java
│   │   │   ├── repository/
│   │   │   │   ├── HotelRepository.java
│   │   │   │   ├── RoomRepository.java
│   │   │   │   └── ReservationRepository.java
│   │   │   └── Vjezba2Application.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── templates/
│   │           ├── action.html
│   │           ├── hotelForm.html
│   │           ├── listA.html
│   │           ├── listB.html
│   │           ├── listC.html
│   │           └── reservationForm.html
│   └── test/
├── pom.xml
└── README.md
```

## Testing REST API

Using curl or Postman:

### Get all reservations
```bash
curl http://localhost:8080/api/reservations
```

### Get reservation by ID
```bash
curl http://localhost:8080/api/reservations/1
```

### Create new reservation
```bash
curl -X POST http://localhost:8080/api/reservations \
  -H "Content-Type: application/json" \
  -d '{
    "guestName": "Test User",
    "guestEmail": "test@email.com",
    "guestPhone": "+385-91-999-9999",
    "checkInDate": "2025-11-15",
    "checkOutDate": "2025-11-18",
    "numberOfGuests": 2,
    "totalPrice": 300.0,
    "status": "PENDING",
    "hotel": {"id": 1}
  }'
```

### Update reservation
```bash
curl -X PUT http://localhost:8080/api/reservations/1 \
  -H "Content-Type: application/json" \
  -d '{
    "guestName": "Updated Name",
    "guestEmail": "updated@email.com",
    "guestPhone": "+385-91-999-9999",
    "checkInDate": "2025-11-15",
    "checkOutDate": "2025-11-18",
    "numberOfGuests": 3,
    "totalPrice": 350.0,
    "status": "CONFIRMED"
  }'
```

### Delete reservation
```bash
curl -X DELETE http://localhost:8080/api/reservations/1
```

## Database Schema

The application uses Hibernate's `ddl-auto=update` to automatically create/update tables:

- **hotels**: id, name, city, address, stars
- **rooms**: id, number, type, price, available, hotel_id (FK)
- **reservations**: id, guest_name, guest_email, guest_phone, check_in_date, check_out_date, number_of_guests, total_price, status, hotel_id (FK)

## Development

To enable hot reload during development, the application uses Spring Boot DevTools. Changes to templates and code will automatically trigger a restart.

## License

This project is created for educational purposes as part of Lab 2 exercises.

