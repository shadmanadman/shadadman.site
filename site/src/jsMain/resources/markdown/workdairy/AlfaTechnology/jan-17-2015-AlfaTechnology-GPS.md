\## jan-17-2015-AlfaTechnology-GPS



At the end of our first stable release, right when I thought my work was done, we discovered an exciting feature that had been sitting in front of us the whole time. The hardware connected to our users’ cars had a built in GPS and could send the current longitude and latitude every five seconds.



This feature not only increases our hardware profit but also greatly expands our user base. The ability to track a car’s location was a huge step towards an excellent user experience for our application. By setting up a survey, almost all of our customers said yes to this feature and indicated they would pay more to have it.



Now, we needed the Google Maps API more than ever. I started my R\&D immediately after hearing the word ‘GPS.’ It was an amazing opportunity to learn more about map visualization. We need to track users’ cars on a map. Since I’m currently in R\&D mode, Google’s documentation is sufficient to extract anything needed. I’ve always loved how Google documents technical information; it’s so clean. Besides the map itself, what we actually needed was something called `polygons`, which have the ability to draw lines on a Google Map. These `polygons` can be used to define geographical boundaries or areas of interest. For example, we could use them to highlight specific regions or routes on the map.



As we were brainstorming, we found other mini features that could come along. Such as:



* show tracking history by date or by destination
* luck/unluck the car when users phone is close/away from the car
* Notify the car owner that the car is currently moving



This new feature marks the beginning of the end. It will open other paths in the not too distant future, and I’m very excited for that. 

