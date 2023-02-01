<?php
session_start();
include_once 'functions.php';

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="style.css" rel="stylesheet" type="text/css">
    <title>Poll Deletion Page</title>
</head>
<body>
    <h2>Delete an existing poll here(The deletion is not possible if the poll doesn't exist)</h2>
    <form action="poll_deletion_query.php" method="POST" >
    <h5> Enter the id of the poll: <input name="id" type="text"></h5><br>
    <h5><input  type="submit" value="Delete"></h5>
    </form>
</body>
</html>