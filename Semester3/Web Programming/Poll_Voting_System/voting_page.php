<?php
session_start();
// $id = $_GET['id'];
// echo $id;
include_once 'functions.php';
include_once 'pages.php';

// $errors = $_SESSION['errors'] ?? [] ;
// $_SESSION['errors'] = [];
// $origin = $_SESSION['origin'] ?? '';
// $_SESSION['origin']  = '';

if($_POST)
{
    $poll_id = $_POST['poll_id'] ?? '';
}
if(!isset($poll_id)) redirect('index.php');

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="style.css" rel="stylesheet" type="text/css">
    <title>Voting Page</title>
</head>
<body>
    <?php  voting_page_display($poll_id,"voting_page.php") ?>
    
</body>
</html>