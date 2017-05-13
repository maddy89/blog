var express = require('express');
var router = express.Router();

router.get('/', function(req, res){
	res.send('GET route on things.');
});
router.post('/', function(req, res){
	res.send('POST route on things.');
});
router.get('/:name', function(req, res) {
	res.send('Welcome ' + req.params.name);
});

//All other routes
router.get('*', function(req, res){
    res.send('Not found');
});

module.exports = router;