<?php
session_start();
require_once 'functions.php';
require_once 'pages.php';

// if(auth_is_logged_in()) redirect('index.php');
$errors = [];
$_SESSION['errors'] = [];
// checks the validity of the data
$login_data = (object)[
    'uname' => trim($_POST['uname'] ?? ''),
    'pword' => trim($_POST['pword'] ?? ''),
    'origin' => trim($_POST['origin']) ?? 'index.php'
];

if(!user_exists($login_data->uname)){
    $errors[] = 'uname_unknown';
    // redirect('index.php');
}
// var_dump($_SESSION['errors']);

if(!auth_password_verify($login_data->uname, $login_data->pword)){
    $errors[] = 'login_error';
    page_errors($errors);
    // redirect('index.php');
}

if(count($errors) > 0) 
{
    $_SESSION['errors'] = $errors;
    redirect($_POST['origin']);
}


// logs the user in
$_SESSION['user'] = get_user_by_username($login_data->uname)->id ?? null;
// $forfun =  get_user_by_username($login_data->uname)->id;
// var_dump($forfun);
// var_dump($_SESSION['user']);
redirect('index.php');