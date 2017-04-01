<?php
session_start();

if(!isset($_SESSION["access_granted"]) || (isset($_SESSION["access_granted"]) && !$_SESSION["access_granted"])) {
	$_SESSION["status"] = " You must log in first.";
	header("Location:login.php");
	die;
}
?>

<html>
<head>
	<title>Login Page</title>
	<link rel="stylesheet" href="login_style.css" type="text/css"/>
</head>
<body>
	<p>ACCESS GRANTED</p>
	<a href="logout.php">Logout</a>
</body>
</html>
