<?php
session_start();
include "../process/functions.php";
$db = connect();

if(isset($_POST['update'])){

	$id = $_POST['id'];
 	$firstname = $_POST['fname'];
	$lastname = $_POST['lname'];
	$year = $_POST['yr'];

	$stmt = $db->prepare("UPDATE student SET 
								lastname = :lname,
								firstname = :fname, 
		                 		year = :year 
		                 		WHERE s_id = :id");

			$stmt->bindValue('fname',$firstname);
			$stmt->bindValue('lname',$lastname);
			$stmt->bindValue('year',$year);
			$stmt->bindValue('id',$id); 

			$stmt->execute();
			header('Location:../pages/student.php#popup2');
}

if(isset($_POST['updato'])){

	$id = $_POST['id'];
 	$des = $_POST['des'];
	$dat = $_POST['dat'];

	$stmt = $db->prepare("SELECT * from meeting where m_id = :id");
		$stmt->bindValue('id',$id);
		$stmt->execute();
		$account = $stmt->fetch(PDO::FETCH_OBJ);

	$desc = $account->description;

	$sth = $db->prepare("ALTER TABLE `sanction` CHANGE `$desc` `$des` VARCHAR(11) NOT NULL");
	$sth->execute();

	$stmt = $db->prepare("UPDATE meeting SET 
								description = :des,
								m_date = :dat
		                 		WHERE m_id = :id");

			$stmt->bindValue('des',$des);
			$stmt->bindValue('dat',$dat);
			$stmt->bindValue('id',$id); 

			$stmt->execute();


	header('Location:../pages/meeting.php#popup2');
}

?>