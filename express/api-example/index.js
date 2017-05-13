var express = require('express');
var app = express();
const MongoClient = require('mongodb').MongoClient
var db;

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