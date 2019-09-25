Project #3. "Movies Rating Review Platform". Alexander Gavrilyuk
***

localhost:8080/admin/movie [POST] -  add movie to list
***
```json
{
	"name" : "Avatar",
	"category" : "Adventure",
	"director" : "John Cameron",
	"shortDescription" : "Avatar is primarily an action-adventure journey of self-discovery, in the context of imperialism and deep ecology",
	"rateValue" : 9.0,
	"rate" : {  
        "rate" : 9.0,  
        "countOfVotes" : 9856  
    }  
}

localhost:8080/admin/movie/{id} [DELETE] - remove movie by id

localhost:8080/admin/movie/{id} [PUT] - update info about movie by id

localhost:8080/movie/{id} [GET] — get info about movie by id

localhost:8080/movie/rate [POST] - add rate to a movie
```json
{    
    "movieId" : 0,    
    "rate" : 9.8    
}   

localhost:8080/movie/all [GET] - get a list of all movies

localhost:8080/stats/rate/{desc} [GET] - get movies list by rating ("true" or "false")

localhost:8080/stats/{category} [GET] - get movies list by category

localhost:8080/review/movie/{id} [GET] - get movie review by id

localhost:8080/review/movie/{id} [PATCH] - add review to movie
```json
{
	"movieId" : 0,
	"reviewMessage" : "Best Adventure movie ever maded",
	"isLiked" : "true"  
}

localhost:8080/review/movie/{id} [PUT] - update review to movie
```json
{
	"movieId" : 0,
	"reviewMessage" : "Best Adventure movie ever maded",
	"isLiked" : "true"  
}



