$(document).ready(function(){
	jQuery.validator.addMethod("bankAccountNumber", function(value, element) {
		  return this.optional(element) || /^([1-9]\d{7}-\d{8})$/.test(value);
		}, "Bank Account number has to be like this: 12345678-12345678");
	
	jQuery.validator.addMethod("noNumbers", function(value, element) {
		  return this.optional(element) || /^([^\d]*)$/.test(value);
		}, "Numbers not allowed for this field!");
	
	$("form[name='bankAccountForm']").validate({
		rules: {
			bankAccount: {
				required: true, // /^([1-9]\d{7}-\d{8})$/
				bankAccountNumber: true
			},
			surname: {
				required: true,
				minlength: 3,
				maxlength: 30,
				noNumbers: true
			},
			forename: {
				required: true,
				minlength: 3,
				maxlength: 30,
				noNumbers: true
			}
		},
		messages: {
			bankAccount: {
				required: "Bank Account number is required!"
			},
			surname: {
				required: "Surname is required!",
				minlength: "Surname has to be at least 3 characters!",
				maxlength: "Surname can be at most 30 characters!"
			},
			forename: {
				required: "Forename is required!",
				minlength: "Forename has to be at least 3 characters!",
				maxlength: "Forename can be at most 30 characters!"
			}
		},
		submitHandler: function(form){
			form.submit();
		}
	});
});