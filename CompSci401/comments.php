<?php
session_start();
require_once('dao.php');
$dao = new dao();
if(!isset($_SESSION["access_granted"]) || (isset($_SESSION["access_granted"]) && !$_SESSION["access_granted"]))
{
	header("Location: login.php");
	die;
}
?>
<!DOCTYPE html>
<html>
	<p><a href="logout.php">Logout</a></p>
	<?php include_once('header.php'); ?>
	<link href="css/comments_style.css" type="text/css" rel="stylesheet" />	
<body>
	<form name="commentForm" action="comment_handler.php" method="POST">
		<div>
			<label for="comment">Post a Comment:</label>
			<input type="text" id="comment" name="comment">	
		</div>
		<div>
			<input type="submit" name="commentButton" value="Submit">
		</div>
	</form>
	<?php
	$comments = $dao->getComments();
	if($comments) { ?>
	<table>
		<?php foreach ($comments as $comment) { ?>
		<tr>
			<td><?= $comment["comment"]; ?></td>
			<td><?= $comment["created"]; ?></td>
		</tr>
		<?php } ?>
	</table>
	<?php } ?>		
	<div id="footer">
		<p>The use of the photography on this site is strictly prohibited without express written consent from Cheyenne Goetz</p>
	</div>
</body>
</html>
