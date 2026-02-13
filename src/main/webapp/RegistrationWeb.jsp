<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration Page</title>

<style>
    body {
        font-family: "Lucida Console", "Courier New", monospace;
        font-size: 14px;
    }
    table {
        background-color: #272fea;
        padding: 15px;
        border: 5px dotted blue;
        text-align: center;
    }

    input {
        padding: 5px;
        
    }

    .error {
        color: red;
    }
    
    img{
    	border: 1px solid #ddd;
    	border-radius: 4px;
    }
   
   	h2{
   		
   		color: white;
   }
	
		.starwarsimage {
		    position: fixed;  
		    top: 0;
		    left: 0;
		    width: 100vw;      
		    height: 100vh;      
		    object-fit: cover;  
		    z-index: -1;        
		}

</style>
</head>

<body>
<div align="center">
    <img class="starwarsimage" src="Star-wars-logo-new-tall.png" alt="Star Wars Logo" />

</div>

<div align="center">
    <h2>Registration Page</h2>

  <form action="RegisterServlet" method="post">
<table>
    <tr>
        <td>Username:</td>
        <td> <input type="text" name="userName" /> 
        <span style="color:red">${userNameError}</span>
        </td>
        
    </tr>

    <tr>
        <td>Password:</td>
        <td>
            <input type="password" name="password" />
            <span style="color:red">${passwordError}</span>
        </td>
    </tr>

    <tr>
        <td>Retype Password:</td>
        <td>
            <input type="password" name="rePassword" />
            <span style="color:red">${rePasswordError}</span>
        </td>
    </tr>

    <tr>
        <td>Mobile Number:</td>
        <td>
            <input type="text" name="mblnumber" />
            <span style="color:red">${mobileError}</span>
        </td>
    </tr>

    <tr>
        <td>Email:</td>
        <td>
            <input type="text" name="email" />
            <span style="color:red">${emailError}</span>
        </td>
    </tr>
</table>

<input type="submit" value="Register" />
</form>
</div>
</body>
</html>
