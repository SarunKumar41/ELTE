<?php 
session_start();
include_once 'functions.php';
include_once 'pages.php';

$pword1 = trim($_POST['pword1'] ?? '');
$pword2 = trim($_POST['pword2'] ?? '');

$form_data = (object)[
    'username' => trim($_POST['uname'] ?? ''),
    'password' => password_hash($pword1,PASSWORD_DEFAULT) ,
    'email' => trim($_POST['email'] ?? '')
];

$errors = [];
if(strlen($form_data->username) < 5){
    $errors[] = 'uname_short';
}else if(!regex_username($form_data->username)){
    $errors[] = 'uname_complex';
}else if(user_exists($form_data->username)){
    $errors[] = 'uname_exists';
}

if($pword1 != $pword2){
    $errors[] = 'pword_nomatch';
}else if($pword1 < 8){
    $errors[] = 'pword_short';
}else if(!regex_password($pword1)){
    $errors[] = 'pword_complex';
}

if(filter_var($form_data->email, FILTER_VALIDATE_EMAIL) == false ) $errors[] = 'email_invalid'; 

if(count($errors) > 0){
    $_SESSION['errors'] = $errors;
    $_SESSION['origin'] = 'query_register.php';
    $_SESSION['kept_data'] = $form_data;
    // page_errors($errors);
    redirect('registration_page.php');
    // var_dump($errors);
}
else
{
    $_SESSION['origin'] = 'index.php';
    add_user($form_data);
    $users = json_read('users.json');
    // var_dump($users);

    redirect('login_page.php');
}

?>