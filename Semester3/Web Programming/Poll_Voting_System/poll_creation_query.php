<?php
session_start();
include_once 'functions.php';

$isMultiple = $_POST['multiple'] == "yes" ? "True" : "False";
$options =  preg_split("/\r\n|\n|\r/", $_POST['options']);  //explode(PHP_EOL,$_POST['options']);

foreach($options as $key => $option)
{
    if(trim($option) == "")
    {
        // var_dump($option);
        unset($options[$key]);
    }
}

// var_dump(in_array("lala",$options));
// echo "ye dunia madarchod hai";
// var_dump($options);
// echo "ye dunia madarchod hai";
$array_for_value = array_fill(0, count($options), 0);
// echo "ye dunia madarchod hai";
$answers = array_combine($options,$array_for_value);
// var_dump($answers);
// echo "ye dunia madarchod hai";
// var_dump($_POST);

add_poll(
        [
        'id' => $_POST['id'],
        'question' => $_POST['question'],
        'options' => $options, //['Haan, realize abhi hua', 'Nahi, tu chutiya hai', 'Haan, par tere jitna bada nahi'],
        'isMultiple' => $isMultiple ,
        'createdAt' => $_POST['creation'],
        'deadline' => $_POST['deadline'],
        'answers' =>  $answers,//[
        //     'Haan, realize abhi hua' => 0,
        //     'Nahi, tu chutiya hai' => 0 ,
        //     'Haan, par tere jitna bada nahi' => 0
        // ],
        'voted' => []
    ]
);

redirect('index.php');

// $polls  = json_read('polls.json');
// var_dump($polls);


?>