var Login = function () {
    return {
        //main function to initiate the module
        init: function (user_null,pass_null) {
           $('.login-form').validate({			   
	            errorElement: 'label', //default input error message container
	            errorClass: 'help-inline', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            rules: {
	                username: {
	                    required: true
	                },
	                password: {
	                    required: true
	                },
	                remember: {
	                    required: false
	                }
	            },
	            messages: {
	                username: {
	                    required: user_null
	                },
	                password: {
	                    required: pass_null
	                }
	            },

	            // invalidHandler: function (event, validator) { //display error alert on form submit
	            //     $('.alert-error', $('.login-form')).show();
	            // },

	            highlight: function (element) { // hightlight error inputs
	                $(element)
	                    .closest('.control-group').addClass('error'); // set error class to the control group
	            },

	            success: function (label) {
	                label.closest('.control-group').removeClass('error');
	                label.remove();
	            },

	            errorPlacement: function (error, element) {
	                error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
	            },

	            submitHandler: function (form) {
					var $form = $(form);
					$.ajax({
						type : 'post',
						url : 'login',
						async : false,
						data : $form.serialize(),
						success :function (result) {
							if(result.result == "success"){
								window.location.href = "login_index";
							}else{
								$('.alert-error', $('.login-form')).show();
							}
						}
					});
	            }
	        });
	        // $('.login-form input').keypress(function (e) {
	        //     if (e.which == 13) {
	        //         if ($('.login-form').validate().form()) {
	        //             window.location.href = "index-bak.jsp";
	        //         }
	        //         return false;
	        //     }
	        // });
        }

    };

}();