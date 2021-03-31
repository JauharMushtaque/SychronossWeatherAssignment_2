# SynchronossWeatherAssignment
This is to create a simple App to display the current weather assignment.

1 Application overview 
This is the simple App to display the current weather forecast using the OpenWeatherMap free weather API. 
OpenWeatherMap service called using cityId, which is Bengaluru in my case. Every 2 hours we request the server and update the database and UI with the latest Weather details. Once the weather details are retrieved, we store in Room database.


1.1        Key entities
UI > MainActivity
Database > Saving the weatherResponse data got from network call into the database.
Classes involved are WeatherDao, WeatherEntity, WeatherInformation and WeatherDatabase
Models > ViewModel class, Response, Weather_Base_Pojo
Network > For Network call using Retrofit, classes involved are RetrofitProvider, RetrofitService, WeatherRepository
Utility > some Utility methods for the applications

 

