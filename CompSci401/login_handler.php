<?php
session_start();

require_once('dao.php');

if($_POST)
{
  $email = $_POST['email'];
  $password = $_POST['password'];

  # Validate form input.
  $validEmail = false;
  $validPassword = false;

  # Check email (required field)
  if(empty($email)) {
    $_SESSION["error_email"] = "Email cannot be empty.";
  } else if(filter_var($email, FILTER_VALIDATE_EMAIL) === false) {
    $_SESSION["error_email"] = "Please enter a valid email.";
  } else {
    $validEmail = true;
  }

  # Check password (required field)
  if(empty($password)) {
    $_SESSION["error_password"] = "Password cannot be empty.";
  } else {
    $validPassword = true;
  }
  # If input is valid, check values against user info in database.
  if($validEmail && $validPassword) {
  	$dao = new dao();
	$access = $dao->validateUser($email, $password);
	if($access == true){
		$_SESSION["access_granted"]=true;
		header("Location: comments.php");
		die;	
	}else{
		$_SESSION["email_preset"] = $email;
		$_SESSION["access_granted"] = false;
		header("Location: login.php");
		die;
  }
  # If we get this far, something went wrong.
  $_SESSION["status"] = $status;
  $_SESSION["email_preset"] = $email; # so user doesn't have to re-enter value.
  $_SESSION["access_granted"] = false;
  header("Location: login.php");
  die; # Make sure this script terminates.
  } else {
  $_SESSION["access_granted"] = false;
  header("Location: login.php");
  die;
  }
}
?>
