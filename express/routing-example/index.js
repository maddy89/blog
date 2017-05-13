var express = require('express');
var app = express();
var router = require('./router.js');
const MongoClient = require('mongodb').MongoClient

app.use('/router', function(req, res, next){
	console.log("A new request received at " + Date.now());
	next(); //forwarding to next handler
});

app.get('/', (req, res) => {
  res.sendFile(__dirname + '/index.html')
})

app.use('/router', router); //use router to handle requests comes to /router

app.listen(3000, function() {
    console.log("Listening on port 3000..");
});