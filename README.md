# ♻️ Sortify

## 🚀 About This Project

Sortify is a group project in the Dat251 subject at Western Norway University of Applied Sciences, and is developed by Mampenda, Mina, Kaja, Petter, Erik and Morten for the semester project in DAT251 - Modern Software Development Methods.

Sortify is an application designed to make it easier for the user to recycle and dispose of waste. It invcludes an interactive map which displays collection points in an easy to read way. You can also compete against your friends and family to figure out who among you are better at recycling

## 🛠️ Tech Stack

- **Frontend:** Astro with [React/Vue/Svelte] (choose your preferred framework)
- **Backend:** Spring Boot (Kotlin)
- **Database:** PostgreSQL
- **Authentication:** JWT & OAuth
- **Testing:** JUnit (Backend), Playwright/Jest (Frontend)
- **CI/CD:** GitHub Actions

## 📦 Features

✅ Search for recycling stations by waste type or location  
✅ Get notifications for garbage collection and recycling center updates  
✅ Track personal recycling habits and statistics  
✅ Plan optimized routes to visit multiple recycling stations  
✅ Social sharing of recycling achievements

## 🚀 Getting Started

**1️⃣ Clone the Repository**

```bash
git clone https://github.com/Sortify-DAT251/DAT251-Sortify.git
cd DAT251-Sortify
```

**2️⃣ Run the Backend without Docker**
If you want to run the backend without Docker, follow these steps:

```bash
cd DAT251-Sortify/backend
./gradlew clean build
./gradlew bootJar
./gradlew bootRun
```

**3️⃣ Run and Test the Backend with Docker Locally**
To run the backend using Docker locally, follow these steps:

1. ### START DOCKER DESKTOP ON YOUR LOCAL MACHINE

2. Using docker OR docker-compose

```bash
# Build the Docker Image (remember the period after "sortify-backend")
docker build -t sortify-backend .

# Run the Docker container
docker run -p 9876:9876 sortify-backend
```

```bash
# Build the Docker Image with docker-compose
docker-compose build --no-cache

# Start container
docker-compose up -d

# Check logs that container has started
docker logs sortify-backend-container
```

3. Run test with Gradle

```bash
# Run all tests
./gradlew clean test

# Only test backend is running
./gradlew test --tests backend.DockerIntegrationTests
```

The backend should now be running on http://localhost:9876. You can access it by visiting this URL in your browser or through an API client like Postman.

**4️⃣ Run the Backend using docker-compose (recommended)**
How do I explain in easy steps how to build and run the backend? And how do I explain that the first build will take longer than the next ones? And how do I tell them that the backend can run while they code?

**0️⃣ Troubleshoot**
If you run into trouble with the program

**1.** Clean Gradle caches and restart the build:

```bash
./gradlew --stop
 rm -rf ~/.gradle/caches
  rm -rf .gradle
./gradlew clean build --stacktrace
./gradlew bootJar
./gradlew bootRun
```

**2.** Try closing and re-opening the IDE.

**3.** If you're using `VSCode`, try uninstalling "Kotlin by fwcd" and only use "Kotling Language by mathiasfrohlich"

**If you're still having troubles, ask chat..**

Numbers: 0️⃣ 1️⃣ 2️⃣ 3️⃣ 4️⃣ 5️⃣ 6️⃣ 7️⃣ 8️⃣ 9️⃣
