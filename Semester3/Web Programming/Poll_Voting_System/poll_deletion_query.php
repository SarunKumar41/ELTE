<?php
session_start();
include_once 'functions.php';
$poll_id = trim($_POST['id'])  ?? '';
$confirmation_message = delete_poll($poll_id);

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="style.css" rel="stylesheet" type="text/css">
    <title>Deletion Status</title>
</head>
<body>
    <h2> <?= $confirmation_message ?>
    Click here to go back to main page!
    <form action="index.php">
        <input type="submit" value="Go to main page">
    </form>
</body>
</html>