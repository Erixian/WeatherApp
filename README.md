---

# WeatherApp

A simple web application built with Spring Boot and Thymeleaf that fetches and displays current weather information for any city using an external weather API.

## Features

*   **Current Weather Data:** Get temperature, "feels like" temperature, precipitation, humidity, UV index, wind speed, and wind direction.
*   **Location Context:** Displays region, country, and local time for the searched city.
*   **User-Friendly Interface:** Clean and responsive design.
*   **Smart Error Handling:**
    *   Clearly informs users about invalid or unknown city names.
    *   Prevents application crashes, ensuring a smooth experience even with API errors.
    *   Validates input for empty city names.

## Technologies Used

*   **Backend:**
    *   **Java 17+ & Spring Boot 3:** The core framework for the server-side logic.
    *   **Spring Web:** Handles web requests and responses.
    *   **RestTemplate / WebClient:** Used to communicate with the external weather API.
*   **Frontend:**
    *   **Thymeleaf:** A template engine that builds dynamic HTML pages.
    *   **HTML5 & CSS3 (Bootstrap 5):** For the web page structure and styling.
*   **External API:**
    *   **WeatherAPI.com:** Provides the weather data. (You'll need a free API key from them.)

## Setup and Running Locally

1.  **Get the Code:**
    ```bash
    git clone https://github.com/Erixian/WeatherApp.git
    cd WeatherApp
    ```

2.  **Obtain a Weather API Key:**
    *   Sign up at [WeatherAPI.com](https://www.weatherapi.com/) (or your chosen provider) to get your free API key.

3.  **Configure Your API Key:**
    *   Open `src/main/resources/application.properties`.
    *   Add these lines, replacing `YOUR_WEATHER_API_KEY_HERE` with your actual key:
        ```properties
        weather.api.key=YOUR_WEATHER_API_KEY_HERE
        weather.api.url=http://api.weatherapi.com/v1/current.json # Example URL
        ```

4.  **Build and Run:**
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

5.  **Access the App:**
    Open your browser to:
    ```
    http://localhost:8080/home
    ```
