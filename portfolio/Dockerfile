# ---------- BUILD STAGE ----------
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

# copy pom first (for dependency caching)
COPY pom.xml .

RUN mvn -B -q -e -DskipTests dependency:go-offline

# copy full project
COPY src ./src

# build jar
RUN mvn clean package -DskipTests


# ---------- RUN STAGE ----------
FROM eclipse-temurin:21-jdk

WORKDIR /app

# copy jar from build stage
COPY --from=build /app/target/portfolio-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]