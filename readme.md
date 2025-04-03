# Android_DI_Hilt

This is a **sample Android application** designed to demonstrate the use of **Hilt** for dependency injection, **Jetpack Compose** for building declarative UIs, and **Clean Architecture** principles. The app is not production-ready and is intended for educational purposes to showcase modern Android development practices.

---

## 🚀 Features

- **Dependency Injection**: Uses Hilt to manage dependencies across layers.
- **Jetpack Compose**: Demonstrates building a simple UI with Compose.
- **Clean Architecture**: Implements a layered architecture with `data`, `domain`, and `ui` layers.
- **Local and Remote Data Handling**: Simulates fetching data from local and remote sources.
- **Testable Code**: Separation of concerns makes the codebase easy to test.

---

## 🛠️ Tech Stack

- **Kotlin**: Programming language.
- **Jetpack Compose**: For building the UI.
- **Hilt**: For dependency injection.
- **Coroutines**: For asynchronous programming.
- **Flows**: For state handling.
- **AndroidX(Viewmodel etc)**: Core libraries for modern Android development.
- **JUnit**: For unit testing.


---

## 📂 Project Structure

The project is structured to follow **Clean Architecture** principles, with the following layers:

### 1. **Data Layer**
Handles data operations, including fetching data from local and remote sources.

- **Local Data**: Simulates local storage (e.g., Room or SharedPreferences).
- **Remote Data**: Simulates API calls using mock data.
- **Repository**: Combines local and remote data sources.

### 2. **Domain Layer**
Contains business logic and use cases.

- **Use Cases**: Encapsulate application-specific business rules.
- **Models**: Represent the core data structures used in the app.

### 3. **UI Layer**
Handles the presentation logic and user interface.

- **Jetpack Compose**: Used to build the UI.
- **ViewModel**: Manages UI state and interacts with the domain layer.

---

## 🧪 Testing

This project includes basic unit tests to demonstrate testing practices.

- **Unit Tests**: Located in the `test` directory.
    - Example: `ExampleUnitTest.kt` tests simple logic.
- **Instrumented Tests**: Located in the `androidTest` directory.
    - Example: `ExampleInstrumentedTest.kt` tests app context on a device.

---

## 🔧 Setup and Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/himanshu-kandwal/Android_DI_Hilt.git