<?php
session_start();
include_once 'functions.php';
// add_poll(
//     [
//         'id' => 'polltry1',
//         'question' => 'Chutiya hai kya bsdk????',
//         'options' => ['Haan, realize abhi hua', 'Nahi, tu chutiya hai', 'Haan, par tere jitna bada nahi'],
//         'isMutliple' => "False",
//         'createdAt' => '2022-12-06',
//         'deadline' => '2024-12-14',
//         'answers' => [
//             'Haan, realize abhi hua' => 0,
//             'Nahi, tu chutiya hai' => 0 ,
//             'Haan, par tere jitna bada nahi' => 0
//         ],
//         'voted' => ['userid1']
//     ]
// );

// $polls  = json_read('polls.json');
// var_dump($polls);

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="style.css" rel="stylesheet" type="text/css">
    <title>Poll Creation Page</title>
</head>
<body>
    <h2>Create a new poll here</h2>
    <form action="poll_creation_query.php" method="POST" >
    <h5> Enter the id of the poll: <input name="id" type="text"></h5><br>
    <h5> Enter the question of the poll: <input name="question" type="text"></h5><br>
    <h5> Enter the options for the poll:<br> <textarea name="options"></textarea></h5><br>
    <h5> Can multiple options be selected:  <br>   <input type="radio" name="multiple" value="yes"> Yes <br>
    <input type="radio" name="multiple" value="no"> No <br>
    </h5><br>
    <h5> Enter the deadline for the poll: <input name="deadline" type="date"></h5><br>
    <h5> Enter the time of creation of the poll: <input name="creation" type="date"></h5><br>
    <h5><input  type="submit" value="Add"></h5>
    </form>
</body>
</html>