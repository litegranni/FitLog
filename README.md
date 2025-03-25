# FitLog – Träningslogg med MySQL och DynamoDB

FitLog är en träningslogg-applikation byggd i Java med både relationsdatabas (MySQL) och molnbaserad NoSQL-databas (AWS DynamoDB).  
Projektet demonstrerar hur man integrerar olika databastyper och hanterar data via SQL och API:er.

---

# Designbeslut

- Relationsdata (t.ex. användare, tränare, träningspass) lagras i **MySQL**.
- Sammanställd träningsdata laddas upp i **DynamoDB** som ett dynamiskt och skalbart alternativ för analys.
- Projektet följer en tydlig **paketstruktur med `models`, `data`, `repositories`, `debug`**.
- `pom.xml` innehåller både Spring Boot och AWS SDK för smidig utveckling.

---

# Databasarkitektur

# Relationsdatabas: MySQL (fitlog)

- `users`: innehåller användaruppgifter
- `trainers`: lagrar tränarens namn, e-post och specialisering
- `workout_logs`: loggar träning (kopplas till användare + tränare)
- `activity_logs`: loggar annan aktivitet (t.ex. meditation, promenad)

Exempel från SQL-skriptet:

```sql
CREATE TABLE workout_logs (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  exercise_name VARCHAR(100),
  type VARCHAR(50),
  date DATETIME,
  trainer_id INT,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (trainer_id) REFERENCES trainers(id)
);
```

# ER-modell

Ligger i mappen screenshots!


# Molntjänst: AWS DynamoDB

Träningsdata från MySQL konverteras till objekt och laddas upp i DynamoDB under tabellen `WorkoutInfo`.



## Teknologier

- Java 17
- Spring Boot
- MySQL 8.0
- AWS SDK v2
- DynamoDB
- IntelliJ IDEA
- Git + GitHub

---

# Användarmanual (kort)

1. Klona repot:
   ```bash
   git clone https://github.com/<ditt-namn>/fitlog.git
   ```

2. Kör applikationen via IntelliJ (`Main.java` i `services`)
3. Data hämtas från MySQL och skrivs ut
4. WorkoutInfo-data skickas till DynamoDB
5. Resultat visas i AWS Console

---

# Reflektion

Jag har lärt mig:

- Skillnaden mellan relationsdatabas och NoSQL
- Hur man kopplar upp Java till MySQL och AWS DynamoDB
- Hur molntjänster kan integreras i vanliga applikationer
- Hur viktigt det är med tydlig struktur och dokumentation

---
