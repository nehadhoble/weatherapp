Overview
The Weather App is a simple Android application developed using modern development practices and technologies. It retrieves weather data from a public API and displays it in a clean and user-friendly UI built with Jetpack Compose. 
The project uses the MVVM architecture pattern for separation of concerns, Hilt for dependency injection, and Kotlin Coroutines for handling asynchronous tasks.

Project Structure
The app is structured using a multi-layered approach to promote code modularity and maintainability. 
The layers include:
UI Layer: Developed using Jetpack Compose to build a declarative, responsive UI.
ViewModel Layer: Manages UI-related data and logic using Kotlin Coroutines and StateFlows.
Repository Layer: Acts as the single source of truth, abstracting data sources (network, etc.).
Data Layer: Includes data models and remote data sources for interacting with the weather API.

Key Technologies Used:
Kotlin: The primary programming language used for the project.
MVVM Architecture: Ensures a clear separation between UI and business logic.
Jetpack Compose: Declarative UI framework for building modern Android UIs.
Hilt: Dependency injection library for providing and managing dependencies.
Retrofit: HTTP client for making API calls.

Application Flow
User Interaction: Displying current weather for New Delhi.
ViewModel Request: The request is passed to the WeatherViewModel(MainViewModel), which triggers the WeatherRepository.
API Call: The repository uses Retrofit to make a network call to fetch weather data.
Data Processing: The response is mapped to a data model and exposed to the UI using StateFlow.
UI Update: The Jetpack Compose UI observes the ViewModel's state and updates the displayed data accordingly.
