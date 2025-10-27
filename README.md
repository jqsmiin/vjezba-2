# 🏨 Hotel & Rooms

### 👥 Autori
- **Jasmin**  
- **Harun**

---

### 📘 Opis aplikacije
Aplikacija **Hotel & Rooms** demonstrira primjenu **MVC arhitekture u Spring Bootu** koristeći **Thymeleaf** za prikaz podataka u HTML stranicama.

Projekt prikazuje osnovnu funkcionalnost sistema za upravljanje hotelima i njihovim sobama.  
Korisnik može pregledati listu hotela i pripadajućih soba, kao i osnovne informacije o svakoj sobi (broj, tip, cijenu i dostupnost).

---

### 🧩 Modeli i relacije

#### **Hotel**
Sadrži osnovne podatke o hotelu:
```java
private int id;
private String name;
private String city;
private String address;
private int stars;
private List<Room> rooms;
```
### 🛏️ Room

Predstavlja sobe koje pripadaju određenom hotelu:

```java
private int id;
private String number;
private String type;
private double price;
private boolean available;
```

### 🔗 Relacija

Jedan **Hotel** može imati više **Room** objekata → **One-to-Many** relacija.

---

### ⚙️ Arhitektura

Aplikacija koristi **Spring Boot MVC** pristup:

- **Model:** Klase `Hotel` i `Room`  
- **View:** HTML stranice sa **Thymeleaf** templatingom  
- **Controller:** Klasa `DemoController` koja povezuje backend logiku sa prikazom

---

### 💻 Screenshot aplikacije

<img width="1548" height="722" alt="image" src="https://github.com/user-attachments/assets/f98b1f3c-66d5-4456-8703-24f5e284b957" />


---

### 🚀 Tehnologije

- Java / Spring Boot  
- Thymeleaf  
- HTML / CSS  
- Maven
