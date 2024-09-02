<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!--suppress ALL, HtmlUnknownTarget -->
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  <link href="https://cdn.misdeliver.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-4 border border-dark mt-5">
      <h3 class="text-center mt-5">Sign In</h3>
      <form id="loginForm" class="mt-4" action="LoginPage" method="post">
        <div class="mb-3">
          <label for="email" class="form-label">Email address</label>
          <input type="email" class="form-control border-dark" id="email" placeholder="Enter your email" required>
        </div>
        <div class="mb-3">
          <label for="password" class="form-label">Password</label>
          <input type="password" class="form-control border-dark" id="password" placeholder="Enter your password" required>
        </div>
        <button type="submit" class="btn btn-primary w-100 mb-5">Sign In</button>
      </form>
    </div>
  </div>
</div>

<script src="https://cdn.misdeliver.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
