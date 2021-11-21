$().ready(function() {
	$("#validate_reg_form").validate({
		onfocusout: false,
		onkeyup: false,
		onclick: false,
		rules: {
			"username": {
				required: true,
				maxlength: 15
			},
			"password": {
				required: true,
				minlength: 8
			},
            "email": {
				required: true,
				email:true,
			},

			"re-password": {
				required: true,
				equalTo: "#pass",
				minlength: 8
			}
		}
	});
});

$().ready(function() {
	$("#validate_login_form").validate({
		onfocusout: false,
		onkeyup: false,
		onclick: false,
		rules: {
			"email": {
				required: true,
				email:true,
				maxlength:50,
				minlength:5
			},
			"password": {
				required: true,
				minlength: 8,
				maxlength: 30
			}
		}
	});
});

$().ready(function() {
	$("#validate_add_content_form").validate({
		onfocusout: false,
		onkeyup: false,
		onclick: false,
		rules: {
			"title": {
				required: true,
				maxlength:50,
				minlength:200
			},
			"brief": {
				minlength:30,
				maxlength:150
			},
			"content": {
				minlength:50,
				maxlength:1000
			}
		}
	});
});

$().ready(function() {
	$("#validate_edit_profile_form").validate({
		onfocusout: false,
		onkeyup: false,
		onclick: false,
		rules: {
			"firstName": {
				required: true,
				maxlength: 30,
				minlength: 3
			},
			"lastName": {
				required: true,
				maxlength: 30,
				minlength: 3
			},
            "phone": {
				required: true,
				maxlength: 13,
				minlength: 9
			},

			"description": {
				maxlength: 200
			}
		}
	});
});



function invoke_mess() {
    $("#mess_alert" ).show();
    console.log("Clicked");
}