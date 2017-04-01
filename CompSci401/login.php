<?php
session_start();

#Checks if user is logged in and redirects if they are
if(isset($_SESSION['access_granted']) && $_SESSION['access_granted']){
	header("Location: comments.php");
	die;
}

$email = isset($_SESSION['email_preset']) ? $_SESSION['email_preset'] : "";

$errorEmail = $errorPassword = "";
if(isset($_SESSION['error_email'])) {
	$errorEmail = $_SESSION['error_email'];
	unset($_SESSION['error_email']);
}

if(isset($_SESSION['error_password'])) {
	$errorPassword = $_SESSION['error_password'];
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
	<link href="css/login_style.css" type="text/css" rel="stylesheet" />
<body>
	<h3>Login to Cheyenne Goetz Photography</h3>
</body>
	<form action="login_handler.php" method="POST">
		<div class="email">
			<label for="email">Email</label>
			<input type="text" name="email" id="email" value="<?= $email; ?>" />
			<span class="error" id="errorEmail">
			<?= $errorEmail; ?>
			</span>
		</div>
		<div class="password">
			<label for="password">Password:</label>
			<input type="password" name="password" id="password" value=""/>
			<span class="error" id="errorPassowrd">
			<?= $errorPassword; ?>
			</span>
		</div>
		<div class="button">
			<input type="submit" name="postSubmitButton" id="login" value="Login"/>
		</div>
	</form>
	<div class="signUpLink">
		<p>Or <a href="signup.php">Sign Up</a></p>
	</div>	
	<div id="footer">
		<p>The use of the photography on this site is strictly prohibited without express written consent from Cheyenne Goetz</p>
	</div>
	<?php
	$_SESSION['status'] = NULL;
	?>
</html>
