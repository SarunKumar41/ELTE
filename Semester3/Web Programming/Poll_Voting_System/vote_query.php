<?php
session_start();
include_once 'functions.php';

$answer_check = $_POST['answer'] ?? $_POST['answers'] ?? null;
$origin = $_POST['origin'] ?? 'index.php';
$errors = [];
$current_user_id = 'unknown_user_id';
if(auth_is_logged_in())
{
    $current_user_id = $_SESSION['user'];
}
else
{
    $errors[] = 'user_not_logged';
}


if(!isset($answer_check)) {  $errors[] = 'choose_option';}

$answer = (object)$_POST;

// var_dump($answer);

if(count($errors) == 0)
{
    submit_poll_answer($answer,$current_user_id );
    // redirect($origin);
}
else
{
    // $_SESSION['errors'] = $errors;
    $_SESSION['origin'] = "vote_query.php";
    // redirect($origin);
}

// $polls = json_read('polls.json');
// var_dump($polls);
// redirect('index.php');

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="style.css" rel="stylesheet" type="text/css">
    <title>Voting Confirmation</title>
    <?php if(count($errors)==0) :?>
        <h2 style="color: green;">Vote Submitted Successfully</h2>
    <?php endif ?>
    <?php if(count($errors) > 0): ?>
        <h2 style="color: red;">Vote Submission unsuccessful. Error! Please, chooose an appropriate option.</h2>
    <?php endif ?>
        <br><br>
    Click here to go back to main page!
    <form action="index.php">
        <input type="submit" value="Go to main page">
    </form>

</head>
<body>

    
</body>
</html>