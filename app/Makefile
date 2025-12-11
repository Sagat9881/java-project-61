.DEFAULT_GOAL := build-run

SRC_DIR := src/main/java
BIN_DIR := build/classes
JAR_DIR := build/libs
JAR_FILE := $(JAR_DIR)/app.jar
MAIN_CLASS := hexlet.code.Main
MAIN_FILE := $(SRC_DIR)/$(subst .,/,$(MAIN_CLASS)).java
SOURCE_VERSION := 21

# Найти все .java файлы
JAVA_FILES := $(shell find $(SRC_DIR) -name "*.java")

# Цель: сборка + запуск
build-run: build run

# Очистка
clean:
	rm -rf $(BIN_DIR) $(JAR_DIR)
	@echo "🗑️  Cleaned build directories"

# Компиляция
build: clean
	mkdir -p $(BIN_DIR)
	javac --source=$(SOURCE_VERSION) -d $(BIN_DIR) $(JAVA_FILES)
	@echo "✅ Compiled to $(BIN_DIR)"

# Сборка JAR
jar: build
	mkdir -p $(JAR_DIR)
	jar --create \
	    --file=$(JAR_FILE) \
	    --main-class=$(MAIN_CLASS) \
	    -C $(BIN_DIR) .
	@echo "📦 JAR created: $(JAR_FILE)"

# Запуск из классов
run: build
	java --source=$(SOURCE_VERSION) -cp $(BIN_DIR) $(MAIN_CLASS)

# Запуск из JAR (дистрибутив)
run-dist: jar
	java -jar $(JAR_FILE)

# Тесты (заглушка)
test:
	@echo "ℹ️ Тесты: реализуйте при необходимости с JUnit вручную"

# Линтер (заглушка)
lint:
	@echo "ℹ️ Линтер: добавьте google-java-format или checkstyle при желании"

# Отчёты (заглушка)
report:
	@echo "ℹ️ Отчёты: требуют JaCoCo — реализация вручную"

# Обновление зависимостей — отключено
update-deps:
	@echo "ℹ️ Зависимости управляются вручную без Gradle"

.PHONY: clean build run test lint report update-deps build-run jar run-dist