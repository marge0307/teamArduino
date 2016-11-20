<?php 

 function connect(){
 	$db = new PDO("mysql:host=localhost;dbname=hackathon","root","");
 	return $db;
 }

 function getdata(){
	$db = connect();
	$sth = $db->prepare("SELECT * From test");
	$sth->execute();
	$results = $sth->fetchAll(PDO::FETCH_OBJ);
	return $results;
}

function finduser($user, $password){
  	if($user == "admin")
  	{
 	$db = connect();
	$query = $db->prepare("SELECT * From admin WHERE user = ? AND pass = ?");
	$query->bindParam(1,$user);
	$query->bindParam(2,$password);

		if($query->execute()){
			if($query->rowCount() > 0){
				return true;
			}
			else{
				return false;
			}
		}
	}
	else{
	$db = connect();
	$query = $db->prepare("SELECT * From test WHERE 
							name = ? AND password = ?");
	$query->bindParam(1,$user);
	$query->bindParam(2,$password);

		if($query->execute()){
			if($query->rowCount() > 0){
				return true;
			}
			else{
				return false;
			}
		}
	}
 }

 ?>