<?php
session_start();

require_once('dao.php');

if($_POST)
{
	$firstname = $_POST['first_name'];
	$lastname = $_POST['last_name'];
	$email = $_POST['email'];
	$password = $_POST['password'];

	$validFirstname = false;
	$validLastname = false;
	$validEmail = false;
	$validPassword = false;

	if(empty($firstname)) {
		$_SESSION['error_firstname'] = "Firstname cannot be empty.";
	} else {
		$validFirstname = true;
	}

	if(empty($lastname)) {
		$_SESSION["error_lastname"] = "Lastname cannot be empty.";
	} else {
		$validLastname = true;
	}

	if(empty($email)) {
		$_SESSION["error_email"] = "Email cannot be empty.";
	} else if(filter_var($email, FILTER_VALIDATE_EMAIL) === false) {
		$_SESSION["error_email"] = "Please enter a valid email.";
	} else {
		$validEmail = true;
	}

	if(empty($password)) {
		$_SESSION["error_password"] = "Password cannot be empty.";
	} else {
		$validPassword = true;
	}

	if($validPassword) {
		$dao = new dao();
		$access = $dao->validateUser($email, $password);
		if($access == false) {
			$dao->addUser($firstname, $lastname, $email, $password);
			header("Location: login.php");
			die;
		} else {
			header("Location: signup.php");
			die;
		}
	} else {
		header("Location: signup.php");
		die;
	}

$_SESSION["status"] = $status;
$_SESSION["access_granted"] = false;
header("Location: signup.php");
die;
} else {
$_SESSION["access_granted"] = false;
header("Location: signup.php");
die;
}

?>
