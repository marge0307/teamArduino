<?php
session_start();
include "functions.php";
$db = connect();
if(isset($_POST['sub'])){

		echo $user = $_POST['uname'];
		echo $cp = $_POST['mnumber'];
		echo $pass = $_POST['pass'];	
		$am = 0;

		$query = $db->prepare("INSERT INTO test SET 
								name = ?,
								amount = ?,
		                 		cp = ?,
		                 		password = ?");

		$query->bindParam(1,$user);
		$query->bindParam(2,$am);
		$query->bindParam(3,$cp);
		$query->bindParam(4,$pass);

		

			if($query->execute()){
					header('Location:../index.html');
			}
			else{
			header("Location:../index.html#cd-signup");
				}
		 }
		

		

 ?>
