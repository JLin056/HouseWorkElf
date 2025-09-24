# ===== Build stage =====
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw -q -DskipTests clean package

# ===== Run stage =====
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/app.war app.war
ENV PORT=8080
ENV JAVA_OPTS=""
EXPOSE 8080
CMD ["bash", "-lc", "java $JAVA_OPTS -Dserver.port=$PORT -jar app.jar"]
