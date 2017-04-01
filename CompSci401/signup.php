<?php
session_start();

$error_firstname = $error_lastname = $error_email = $error_password = "";

if(isset($_SESSION['error_firstname'])) {
	$errorEmail = $_SESSION['error_firstname'];
	unset($_SESSION['error_firstname']);
}

if(isset($_SESSION['error_lastname'])) {
	$errorEmail = $_SESSION['error_lastname'];
	unset($_SESSION['error_lastname']);
}

if(isset($_SESSION['error_email'])) {
	$errorEmail = $_SESSION['error_email'];
	unset($_SESSION['error_email']);
}

if(isset($_SESSION['error_password'])) {
	$errorEmail = $_SESSION['error_password'];
	unset($_SESSION['error_password']);
}

$status = "";
if(isset($_SESSION['status'])) {
	$status = $_SESSION['status'];
	unset($_SESSION['status']);
}

?>

<html>
	<?php include_once('header.php'); ?>
	<link href="css/signup_style.css" type="text/css" rel="stylesheet" />
<body>
	<h3>Sign up and be a part of Cheyenne Goetz Photography!</h3>
</body>
<form action="signup_handler.php" method="POST">
	<div class="first_name">
		<label for="first_name">First Name:</label>
		<input type="text" name="first_name" id="first_name" />
		<span class="error" id="error_firstname">
		<?= $error_firstname; ?>
		</span>
	</div>
	<div class="last_name">
		<label for="last_name">Last Name:</label>
		<input type="text" name="last_name" id="last_name" />
		<span class="error" id="error_lastname">
		<?= $error_lastname; ?>
		</span>
	</div>
	<div class="email">
		<label for="email">Email:</label>
		<input type="text" name="email" id="email" />
		<span class="error" id="error_email">
		<?= $error_email; ?>
		</span>
	</div>
	<div class="password">
		<label for="password">Password:</label>
		<input type="password" name="password" id="password" />
		<span class="error" id="error_password">
		<?= $error_password; ?>
		</span>
	</div>
	<div class="button">
		<input type="submit" name="postSubmitButton" id="signup" value="Signup"/>	
	</div>
</form>
<div class="loginLink">
	<p>Already have an account? <a href="login.php">Login Here</a></p>
</div>
<div id="footer">
	<p>The use of the photography on this site is strictly prohibited without express written consent from Cheyenne Goetz</p>
</div>	
</html>
