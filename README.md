# Spotify_REST
This is a Simple Rest Service which consumes Spotify API

Spotify follows an OAuth2.0 Protocol for Authorization

This application is a simple Spring boot Based application which Authorizes a user based on his client ID and Secret and hits the Spotify GET ALBUMS and GET TRACKS requests
from  : https://developer.spotify.com/documentation/web-api/reference/#/


The Spotify Web API Documentation above has a detailed description about the authorization flow 

The application Runs on http://localhost:8080/api/


<img width="1512" alt="Screen Shot 2022-10-03 at 1 55 58 PM" src="https://user-images.githubusercontent.com/72269385/193677794-7757b2ad-d1f6-4016-b3ee-04702aa7dc9f.png">


Hitting the Authenticate button above will give an authorization code which will be used for getting the bearer token which happens behind the scenes as that information is sensitive

There is a CallBack URL which is used for redirection along with the authorization code 
This Callback URL is set in the Spotify Developer Dashboard and a Client ID and Secret is registered at that time where there is an option for registering the callback URL 
Link : https://developer.spotify.com/dashboard/



<img width="1492" alt="Screen Shot 2022-10-03 at 3 49 09 PM" src="https://user-images.githubusercontent.com/72269385/193679816-7acf1855-2c80-4eba-bf20-737f0222ad0e.png">





<img width="1510" alt="Screen Shot 2022-10-03 at 1 56 24 PM" src="https://user-images.githubusercontent.com/72269385/193678046-0c26ea59-1bd0-44a7-81cf-d55022cbbe48.png">


Links for Getting Saved Tracks and albums


<img width="1505" alt="Screen Shot 2022-10-03 at 1 56 47 PM" src="https://user-images.githubusercontent.com/72269385/193678149-cf369f78-668e-457c-8abe-a13e023b34cc.png">



<img width="1502" alt="Screen Shot 2022-10-03 at 1 57 06 PM" src="https://user-images.githubusercontent.com/72269385/193678173-a276d1e5-87df-4ca4-a174-01adb2e856ab.png">


The GetAlbums and GetTracks hits the spotify GET endpoint for Tracks and albums



Swagger Documentation for Spotify 


<img width="1512" alt="Screen Shot 2022-10-03 at 3 29 31 PM" src="https://user-images.githubusercontent.com/72269385/193678474-1dd2306b-8fd6-45ec-be14-d6f7f3bb4187.png">



Technologies used :

Java (Spring Boot) using MVC Architechture

Swagger 2.0

Thymleaf : Front End
