
<?php
session_start();
include "functions.php";
$db = connect();

if(isset($_POST['submit'])){
		
		$user = $_POST['uname'];
		$password = $_POST['pass'];
	
		if(finduser($user,$password)){

			if($user == "admin"){
				$stmt2 = $db->prepare("SELECT * from admin where user = :user");
				$stmt2->bindValue(':user',$user);
				$stmt2->execute();
				$account2 = $stmt2->fetch(PDO::FETCH_OBJ);

				$id = $account2->user_id;
				$_SESSION['admin']=$user;
				$_SESSION['id']=$id;
				header("Location:../pages/2ndpage/index.html");
			}
			else{
				$stmt2 = $db->prepare("SELECT * from test where name = :user");
				$stmt2->bindValue(':user',$user);
				$stmt2->execute();
				$account2 = $stmt2->fetch(PDO::FETCH_OBJ);
				$id = $account2->emp_id;
				$_SESSION['id']=$id;
				$_SESSION['user']=$user;
				header("Location:../pages/3rdpages/index.html");
			}
	
	}
	else{
		header("Location:../pages/login.php?error1");
	}
}

?>
