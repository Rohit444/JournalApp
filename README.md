# 📦 Application Setup & Guide

## Reference

This application follows the Spring Boot tutorial:
- [YouTube Tutorial](https://www.youtube.com/watch?v=1993zSY5UBI&list=PLA3GkZPtsafacdBLdd3p1DyRd5FGfr3Ue&index=1)
---

## 🚀 Running the Application

### 🔹 Build the JAR

Use the following command to package the application:

```bash
mvn clean package -Dspring.profiles.active=dev
```

> You can replace `dev` with `prod` based on your environment.

---

### 🔹 Run the Application

Navigate to the `target` folder and execute:

```bash
java -jar <your-jar-file>.jar --spring.profiles.active=dev
```

---

## 📜 Logging Frameworks

### 🔹 Common Logging Frameworks

- **Logback** → Default in most Spring Boot applications
- **Log4j2** → Supports advanced features like asynchronous logging
- **Java Util Logging (JUL)** → Built-in Java logging framework

---

### ⚠️ Note

Default logging configuration is embedded within Spring Boot libraries and may not be visible in your project.

To customize logging, create one of the following files in:

```
src/main/resources/
```

- `logback-spring.xml`
- `logback.xml`

---

### 📊 Logging Levels

```
TRACE < DEBUG < INFO < WARN < ERROR
```

- Default active levels: `INFO`, `WARN`, `ERROR`

---

### 🧩 Annotations

Spring Boot provides:

- `@Slf4j`
- `@Log4j2`

These automatically inject logger instances into your classes.

---

### 💡 Important

- **SLF4J** → Logging abstraction
- **Logback** → Default implementation

---

## 🔍 SonarQube Setup (Local)

### 🔹 Prerequisites

- Java 21 installed
- SonarQube downloaded and extracted

---

### 🔹 Step 1: Generate Token

1. Open SonarQube UI:
   ```
   http://localhost:9000
   ```
2. Navigate to:  
   **My Account → Security**
3. Generate a token and save it securely

---

### 🔹 Step 2: Add Maven Plugin

Add the following plugin in your `pom.xml`:

```xml
<plugin>
    <groupId>org.sonarsource.scanner.maven</groupId>
    <artifactId>sonar-maven-plugin</artifactId>
    <version>5.5.0.6356</version>
</plugin>
```

---

### 🔹 Step 3: Start SonarQube Server

Navigate to:

```
sonarqube-26.4.0.121862/bin/macosx-universal-64
```

Run:

```bash
./sonar.sh start
```

---

### 🔹 Step 4: Check Status

```bash
./sonar.sh status
```

---

### 🔹 Step 5: Run Sonar Analysis

From your project root, execute:

```bash
mvn clean verify sonar:sonar \
-Dsonar.projectKey=journalApp \
-Dsonar.host.url=http://localhost:9000 \
-Dsonar.token=YOUR_TOKEN
```

> Replace `YOUR_TOKEN` with the generated token.

---

### 📊 View Results

Open in browser:

```
http://localhost:9000/projects
```

---

## ⚠️ Notes

- Use **token-based authentication only** (username/password is deprecated)
- Ensure SonarQube is fully started before running analysis
- Java 21 is required for latest SonarQube versions

---

## Sonar cloud URL:
To access Sonar cloud you need to just run the github action file and rest it will automatically detect and produce report here:
`https://sonarcloud.io/summary/overall?id=engineering-digest-rs_journalapp&branch=master`

## ✅ Summary

- Build → `mvn clean package`
- Run → `java -jar`
- Analyze → `mvn sonar:sonar`
- Monitor → SonarQube UI

---