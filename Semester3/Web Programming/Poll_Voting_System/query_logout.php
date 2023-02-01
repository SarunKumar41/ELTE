<?php
session_start();
require_once 'functions.php';

$origin = $_POST['origin'] ?? 'index.php';
session_unset();
session_destroy();
redirect($origin);
