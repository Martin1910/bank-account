$(document).ready(function(){
	$("button").click(function(){
		var bankAccountNo = $(this).parents("tr").children().first().text();
		$.ajax({
		url: "/delete/" + bankAccountNo,
		type: 'DELETE',
		success: function(){
			window.location = "/success.html";
		},
		error: function(){
			window.location = "/error.html";
		}
		});
	});
});