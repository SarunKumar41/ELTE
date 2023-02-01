<?php
session_start();
include_once 'functions.php';
include_once 'pages.php';

$errors = $_SESSION['errors'] ?? [] ;
$_SESSION['errors'] = [];
$origin = $_SESSION['origin'] ?? '';
$_SESSION['origin']  = '';
$previous_data = $_SESSION['kept_data'] ?? null;
$_SESSION['kept_data'] = null;

// $local_errors = [];
// $local_errors[] = 'uname_short';
// $local_errors[] = 'uname_complex';
// $local_errors[] = 'uname_exists';
// $local_errors[] = 'pword_nomatch';
$is_data_kept = isset($previous_data);


?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="style.css" rel="stylesheet" type="text/css">
    <title>Registration Page</title>
</head>
<body>
    <h2>Register</h2>
    <form action="query_register.php" method="POST">
    <input type="hidden" name="origin" value="registration_page.php">
        Username: <input name="uname" value="<?= $is_data_kept ? $previous_data->username : '' ?>"> <br><br>

        Password: <input name="pword1" type="password"> <br><br>

        Password again: <input name="pword2" type="password"> <br><br>

        email: <input name="email" value="<?= $is_data_kept ? $previous_data->email : '' ?>"> <br><br>
    <?php if(count($errors) > 0 && $origin = "query_register.php") : ?>
        <?php page_errors($errors)?>
    <?php endif ?> 
<br>
        
        <input type="submit" value="Register">
    </form>
<br>
<br>
    Click here to go back to main page!
    <form action="index.php">
        <input type="submit" value="Go to main page">
    </form>
</body>
</html>