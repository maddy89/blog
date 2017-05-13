var express = require('express');
var app = express();
// var router = require('./router.js');
const MongoClient = require('mongodb').MongoClient
var db;

// app.use('/router', function(req, res, next){
// 	console.log("A new request received at " + Date.now());
// 	next(); //forwarding to next handler
// });

app.set('view engine', 'pug')
app.set('views','./views');

app.get('/', (req, res) => {
  res.sendFile(__dirname + '/index.html')
})

app.get('/books', function(req, res){
  db.collection('books').find().toArray(function(err, results) {
    res.render('books',{
      books : results
    });
  });
});


MongoClient.connect('mongodb://localhost:27017/blog', (err, database) => {
  if (err) return console.log(err)
  db = database
  app.listen(3000, () => {
    console.log('listening on 3000')
  })
})

// app.use('/router', router); //use router to handle requests comes to /router

// app.listen(3000, function() {
//     console.log("Listening on port 3000..");
// });