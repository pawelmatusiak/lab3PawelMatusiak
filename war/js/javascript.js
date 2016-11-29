  $('#loginForm').validate({
      rules: {
    	  name: {
    		  required: true,
    		  minlength: 3
          },
        
          
          password: {
              required: true,
              minlength: 5
          }
      }
  });
  