<?php
session_start();
require_once 'functions.php';

$is_logged_in = auth_is_logged_in();
$current_user_id = '';
$current_username = '';
// var_dump($_SESSION['user']);
if($is_logged_in)
{
    // var_dump($_SESSION['user']);
    $current_user_id = $_SESSION['user'] ?? '';
    $current_username = get_username_by_id($current_user_id);
}
// var_dump($current_user_id);
// var_dump($current_username);


// var_dump($polls);
// print_r($polls);
// echo '<br>';
sort_polls();
$polls = json_read('polls.json');
// print_r($polls);

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="style.css" rel="stylesheet" type="text/css">
    <title>Voting System</title>
</head>
<body>
    <h1>The Online Poll Voting System</h1>
    <div id="desc">This is a page where you can register(or login if you have already registered for this page) to give your opinion on various university related questions. 
        <br> <br>
        <?php if(! $is_logged_in) : ?>
            <div id="not_logged">
                Click here to login: 

                <form action="login_page.php"> <input type="submit" value="Login" > </form>
                <br> <br>
                Click here to Register(for new users): 
                <form action="registration_page.php"> <input type="submit" value="Registration" > </form>
            </div>
        <?php endif ?> 
    </div> 

    <?php if($is_logged_in) : ?>
            <div id="logged">
                <span style="color: green;">You are currently logged in as <em style="font-size: larger;"><?=$current_username ?> </em></span><br>
                Click here to logout: 
                 <br>
                <form action="query_logout.php" method="POST" >
                    <input type="hidden" name="origin" value="index.php">
                    <input type="submit" value="Logout" >
                </form>                
            </div>
        <?php endif ?>

    <div id="ongoing"><h2>Ongoing polls</h2>
       
        
        <?php foreach($polls as $poll): ?>
            <?php if( strtotime(date("Y-m-d")) < strtotime($poll->deadline) ) : ?>
                <h4><?= 'id: ' . $poll->id . '  ' ?></h4> 
                <h4><?= 'Question: ' . $poll->question ?><h4> <br>
                <?= 'Date Created: ' . $poll->createdAt ?> <br><br>
                <?= 'Deadline: ' . $poll->deadline?> <br>
                <?php if($is_logged_in) : ?>
                    
                    <form  action="voting_page.php" method="POST">
                        <input type="hidden" name="origin" value="index.php">
                        <input type="hidden" name="poll_id" value="<?=$poll->id?>"><br>
                        <?php if(! check_for_voted_poll($current_user_id,$poll->id)) : ?>
                            <input type="submit" value="Sumbit Vote"><br> <br>
                        <?php endif ?>

                        <?php if(check_for_voted_poll($current_user_id,$poll->id)) : ?>
                            <input type="submit" value="Update Vote" style="color: green;"> <br> <br>
                        <?php endif ?>
                        <span style="color: blueviolet;">---------------------------------------------------------------------------------------------------</span>
                    </form>
                    
                    
                <?php endif ?> 
                <?php if(! $is_logged_in) : ?>
                    <form action="login_page.php" method="POST">
                        <input type="hidden" name="origin" value="index.php">
                    
                        <input type="submit" value="Sumbit Vote">
                    </form>
                <?php endif ?>
                
            <?php endif ?>
        <?php endforeach ?>
    </div>

    <div id="ended"><h2>Ended polls. The results are displayed below.<br> (Polls listed below are not available for voting anymore)</h2>
        <?php foreach($polls as $poll): ?>
            <?php if( strtotime(date("Y-m-d")) > strtotime($poll->deadline) ) : ?>
                <h4><?= 'id: ' . $poll->id . '  ' ?></h4> 
                <h4><?= 'Question: ' . $poll->question ?><h4> <br>
                <?= 'Date Created: ' . $poll->createdAt ?> <br><br>
                <?= 'Date ended: ' . $poll->deadline?> <br>
                Result: <br>
                <?php foreach($poll->answers as $key => $answer) :?>
                    <?= $key . ': ' . $answer ?> <br>
                <?php endforeach ?>
                <span style="color: blueviolet;">-------------------------------------------------------</span>
            <?php endif ?>
            
        <?php endforeach ?>
    </div>

    <div id="creation" > <h2>Poll Creation(Only for Admin).<br></h2>
        <span style="color:red"> Password for the user Admin is "Admin123#", NOTE: This credential information is provided specifically for assignment checking purpose.<br>
        
      </span><br>
        <?php if($current_username == "Admin") : ?>
            <form action="poll_creation.php">
                        <input type="hidden" name="origin" value="index.php">
                        <input type="submit" value="Create Poll">
            </form>
            <br> <br>
            Click here to delete poll:
            <form action="poll_deletion.php">
                        <input type="hidden" name="origin" value="index.php">
                        <input type="submit" value="Delete Poll">
            </form>
        <?php endif ?>
        <?php if($current_username != "Admin") : ?>
            In order to use admin features login as Admin.
        <?php endif ?>
    </div>
</body>
</html>