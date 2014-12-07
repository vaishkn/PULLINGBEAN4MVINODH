<!DOCTYPE html>
<html lang="en">
  <head>
  	<title>BeanStalk Java Application</title>
  	
  	<script type="text/javascript">
  	function submitClick(){
  		
  		var userName = document.getElementById('userName').value;
  		var passName = document.getElementById('userPass').value;
  		
  		if((userName!=null && userName.length >0 ) && (passName!=null && passName.length > 0)){
  			
  			return true;
  		}
  		else{
  			
  			alert('Please enter the username/password');
  			return false;
  		}
  		
  	}
  	</script>
  </head>
  <body>
  
 <div>

<div>

 <center>
        <form id="loginPage" action=userLogin method="post">
            <table border=1>
                <tr>
                    <th colspan="2">Login Form</th>
                </tr>
                <tr>
                    <td>Enter your UserId:</td>
                    <td><input type="text" id="userName" name="userName" value=""></td>
                </tr>
                <tr>
                    <td>Enter your Password:</td>
                    <td><input type="password" id="userPass" name="userPass"  value="" onfocus="this.value=''"/></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><button type="submit"  onclick="return submitClick()">Sign In</button></td>
                </tr>
            </table>
        </form>
    </center>  
</div>
</div>
  
</body>
</html>
