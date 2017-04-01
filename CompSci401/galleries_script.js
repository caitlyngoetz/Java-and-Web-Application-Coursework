$(document).ready(function() {
	$('button').hover(
		function() {
			var $width = $('img', this).width()+3;
			$('img', this).filter(':not("animated)').animate({width: $width+"px"}, 'fast')
			}, function() {
				var $width = $('img', this).width()-3;
				$('img, this).animate({ width: $width+'px'}, 'fast')
			});
});
