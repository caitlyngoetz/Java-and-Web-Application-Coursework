<?php
	require_once "dao.php";

	if(isset($_POST["commentButton"])) {
		$comment = htmlspecialchars($_POST["comment"]);
		#still allows empty comments NEEDS FIXING
		try {
			$dao = new dao();
			$dao->saveComment($comment);
		} catch (Exception $e) {
			echo "<p>Failed to save your comment. Please try again</p>";
			die();
		}
	}
header("Location: comments.php");
die();
?>
