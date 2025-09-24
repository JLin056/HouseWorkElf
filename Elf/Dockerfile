# ===== Build stage =====
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . .
# 確保 mvnw 可執行（常見踩雷）
RUN chmod +x mvnw
RUN ./mvnw -q -DskipTests clean package

# ===== Run stage =====
FROM eclipse-temurin:21-jdk
WORKDIR /app
# 複製打包好的 jar（* 確保 target 只有一個 jar，或改成你的檔名）
COPY --from=build /app/target/*.jar app.jar

# Render 會注入 $PORT；Spring Boot 要聽這個埠
ENV PORT=8080
ENV JAVA_OPTS=""
EXPOSE 8080
CMD ["bash", "-lc", "java $JAVA_OPTS -Dserver.port=$PORT -jar app.jar"]
