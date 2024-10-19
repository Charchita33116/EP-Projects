<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>SignUp Result</title>
</head>
<body>
<% String firstname=request.getParameter("firstname"); %>
<% String lastname=request.getParameter("lastname"); %>
<% String email=request.getParameter("email"); %>
<% String phone=request.getParameter("phone"); %>
<% String address=request.getParameter("address"); %>
<h2>SignUp Details</h2>
 <p>First Name: <%=firstname%></p>
 <p>Last Name: <%=lastname%></p>
<p>Email: <%=email%></p>
 <p>Phone Number:<%=phone%></p>
 <p>Address: <%=address%></p>
</body>
</html>