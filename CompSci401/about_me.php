<?php
session_start();
?>
<!DOCTYPE html>
<html>
	<?php include_once('header.php'); ?>
        <link href="css/about_me-style.css" type="text/css" rel="stylesheet" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
		$(document).ready(function()
		{
			$("#hide").click(function()
			{
				$("#buoy").hide();
			});
			$("#show").click(function()
			{
				$("#buoy").show();
			});
		});
	</script>
<body>
	<div class="content">
		<h2>About me...</h2>
		<p>
			I first started getting interested in photography when I started taking classes at my high school in Boise, Idaho.  I really enjoy taking photos of landscapes and creating experiments to take pictures of.  Currently I am studying Computer Science and Creative Writing at the University of Montana.  I don't have as much time as I would like to continue to pursue my photography but I still manage to get my camera out when I go hiking on the trails around campus.  During vacations is when I really find time to pursue it.  I love going on trips with my family and they support my hobby whole-heartedly.  My sister and personal minnion often ends up packing my tripod and gear into where ever we have decided to adventure and my dad loves to discuss timing and other aspects of photography and supply guidance.  Please enjoy!! (Click the button below to see a picture of me with my favorite buoy!!!..)
		</p>
	</div>
	<div class="photo">
		<img src="images/about-me.jpg" alt="photo" />
	</div>
	<button id="hide">Hide buoy!</button>
	<button id="show">Show buoy!</button>
	<div id="buoy">
		<img src="images/hidden.png" alt="buoy" />
	</div>
	<noscript>
	<p class="error">Warning: This page requires JavaScript!!</p>
	</noscript>
	<div id="footer">
		<p>The use of the photography on this site is strictly prohibited with express written consent from Cheyenne Goetz</p>
	</div>
</body>
</html>
