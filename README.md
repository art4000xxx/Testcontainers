# Testcontainers Project

Spring Boot приложение с использованием Testcontainers для интеграционных тестов в Docker-контейнерах. Поддерживает два профиля:
- **Dev**: порт 8080, эндпоинт `/profile` возвращает "Current profile is dev".
- **Prod**: порт 8081, эндпоинт `/profile` возвращает "Current profile is production".

## Требования
- Java 17
- Docker Desktop
- Gradle

## Установка
1. Клонировать репозиторий:
   ```bash
   git clone https://github.com/art4000xxx/Testcontainers.git
   cd Testcontainers
   Автор
art4000xxx
