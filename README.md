## Description
Simple SpringBoot application that uses different weather services to give an advice to ride or not to ride on the longboard  

## Requirements
For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. 
One way is to execute the `main` method in the `longboard.Application` class from your IDE.
Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:
```shell
mvn spring-boot:run
```
or
```shell
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8082
```
Or just execute jar with the command
```shell
java -jar target/simple-spring-boot-app-1.0-SNAPSHOT.jar --server.port=8082
```

#MVC endpoint
GET [http://{host}:{server-port}/get]
    reponse is the page with an advice

#REST endpoint
GET [http://{host}:{server-port}/get-json]
	response:
    ```
    {
        "serviceCallSuccessTime": "2019-08-12T19:49:43.746+0000",
        "yandexResponseJson": {
            "fact": {
                "condition": "cloudy",
                "feels_like": "17",
                "humidity": "85",
                "icon": "bkn_n",
                "pressure_mm": "750",
                "pressure_pa": "1000",
                "soil_temp": "17",
                "temp": "16",
                "uv_index": "0",
                "wind_dir": "s",
                "wind_gust": "2.6",
                "wind_speed": "0.8"
            },
            "forecasts": [
                {
                    "date": "2019-08-12T00:00:00.000+0000",
                    "parts": {
                        "day": {
                            "condition": "cloudy",
                            "temp_max": "21",
                            "temp_min": "19"
                        },
                        "day_short": {
                            "condition": "cloudy",
                            "temp_max": null,
                            "temp_min": "14"
                        },
                        "evening": {
                            "condition": "cloudy",
                            "temp_max": "21",
                            "temp_min": "16"
                        },
                        "morning": {
                            "condition": "cloudy",
                            "temp_max": "18",
                            "temp_min": "9"
                        },
                        "night": {
                            "condition": "clear",
                            "temp_max": "11",
                            "temp_min": "9"
                        },
                        "night_short": {
                            "condition": "clear",
                            "temp_max": null,
                            "temp_min": null
                        }
                    }
                },
                {
                    "date": "2019-08-13T00:00:00.000+0000",
                    "parts": {
                        "day": {
                            "condition": "partly-cloudy-and-light-rain",
                            "temp_max": "23",
                            "temp_min": "20"
                        },
                        "day_short": {
                            "condition": "partly-cloudy-and-rain",
                            "temp_max": null,
                            "temp_min": "18"
                        },
                        "evening": {
                            "condition": "cloudy-and-rain",
                            "temp_max": "20",
                            "temp_min": "19"
                        },
                        "morning": {
                            "condition": "clear",
                            "temp_max": "22",
                            "temp_min": "14"
                        },
                        "night": {
                            "condition": "cloudy",
                            "temp_max": "15",
                            "temp_min": "14"
                        },
                        "night_short": {
                            "condition": "cloudy",
                            "temp_max": null,
                            "temp_min": null
                        }
                    }
                }
            ],
            "now": "1565639509",
            "now_dt": "2019-08-12T19:51:49.271Z"
        }
    }
    ```

	*serviceCallSuccessTime - time of service successfull call, set up by application
    *now_dt - time of service successfull call, set up by service
    *fact - current weather
    *forecasts - forecasts for the following days