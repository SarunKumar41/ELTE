<?php
session_start();
require_once 'pages.php';
$errorCount = count($_SESSION['errors'] ?? []);
if($errorCount > 0)
{
    $errors = $_SESSION['errors'];
    $_SESSION['errors'] = [];
}
$origin = $_SESSION['origin'] ?? 'index.php' ;

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="style.css" rel="stylesheet" type="text/css">
    <title>Login Page</title>
</head>
<body>
    <?php if( $origin == 'query_register.php' && $errorCount == 0 ) : ?>
            <h5> Registration successful. Please, login to continue using the page </h5>
    <?php endif ?>

    <?php if(isset($errors) ) : ?>
        <?php page_errors($errors) ?>
    <?php endif ?>

<h2>Login</h2>
    <form action="query_login.php" method="POST">
        <input type="hidden" name="origin" value="login_page.php">
        Username: <input name="uname"> <br><br>
        Password: <input name="pword" type="password"> <br><br>
        <input type="submit" value="Login">
    </form>

    <?php if( $origin == 'index.php') : ?>
        <h5> Not a user yet????? Click here to register!!</h5>
        <form action="registration_page.php" method="POST">
            <input type="hidden" name="origin" value="login_page.php">
            <input type="submit" value="Go to registration page">
        </form>
    <?php endif ?>

</body>
</html>