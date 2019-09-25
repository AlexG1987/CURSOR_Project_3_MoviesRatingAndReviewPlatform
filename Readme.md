Project #3. "Movies Rating Review Platform". Alexander Gavrilyuk

/admin/movie POST -  add movie to list
{
"name":"Avatar",
"category":"Adventure",
"director":"John Cameron",
"shortDescription":"Avatar is primarily an action-adventure journey of self-discovery, in the context of imperialism and deep ecology",
"rateValue":9.0,
"rate": {  
        "rate":9.0,  
        "countOfVotes":9856  
    }  
}

/admin/movie/{id} DELETE - remove movie by id

/admin/movie/{id} PUT - update info about movie by id

/movie/{id} GET — get info about movie by id

/movie/rate POST - add rate to a movie
{    
    "movieId" : 0,    
    "rate" : 9.8    
}   

/movie/all GET - get a list of all movies

/stats/rate/{desc} GET - get movies list by rating ("true" or "false")

/stats/{category} GET - get movies list by category

/review/movie/{id} GET - get movie review by id

/review/movie/{id} PATCH - add review to movie
{
"movieId":0,
"reviewMessage":"Adventure",
"isLiked":"true"  
}

/review/movie/{id} PUT - update review to movie
{
	"movieId" : 0,
	"reviewMessage" : "Best Adventure movie ever maded",
	"isLiked" : "true"  
}



