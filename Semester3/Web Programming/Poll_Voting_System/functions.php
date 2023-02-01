<?php

/**
 * Read a JSON file and converts the content to and Array or an Object.
 * @param string $filename The name of the JSON file with the extension.
 * @param bool|null $associative [optional] When TRUE, returned objects will be converted into associative arrays.
 * @return (Array|Object) Depending on the content of the JSON file, an Array or an Object of the data that was inside.
 */
function json_read($filename, $associative = false){
    return json_decode(file_get_contents($filename), $associative);
}

/**
 * Write an Array or Object into a JSON file. It OVERWRITES the content of the file.
 * @param string $filename The name of the JSON file with the extension.
 * @param (Array|Object) $data The data to be converted to string.
 */
function json_write($filename, $data){
    file_put_contents($filename,json_encode($data, JSON_PRETTY_PRINT));
}

function compare_date($element1, $element2) {
    $datetime1 = strtotime($element1['deadline']);
    $datetime2 = strtotime($element2['deadline']);
    return $datetime1 - $datetime2;
} 

/**
 * A function to sort polls.json file and overwrite it all again in ascending order
 */
function sort_polls()
{
    $polls = json_read('polls.json', true);
    usort($polls, 'compare_date');

    json_write('polls.json',$polls);
}

/**
 * Checks if a given string matches the password criteria of atleast one a-z and A-Z and 0-9 and (# or @) character.
 * @param string $pword The password to check.
 */
function regex_password($pword){
    return preg_match('/[a-z]/',$pword) &&
           preg_match('/[A-Z]/',$pword) &&
           preg_match('/[0-9]/',$pword) &&
           preg_match('/[#@]/',$pword);
}

/**
 * Checks if a given string matches the username criteria of only a-z A-Z 0-Z characters.
 * @param string $uname The username to check.
 */
function regex_username($uname){
    return preg_match('/^[a-zA-Z0-9]+$/',$uname);
}

/**
 * Redirects you to a page and stops the originating script.
 * @param string $page The page you want to redirect the user to.
 */
function redirect($page){
    header('Location: ' . $page);
    die;
}


function get_user_by_username($uname){
    $users = json_read('users.json');
    foreach($users as $user){
        if($user->username == $uname) return $user;
    }
    return null;
}

function auth_password_verify($uname, $pword){
    $user = get_user_by_username($uname);
    if($user == null) return false;
    return password_verify($pword, $user->password);
}


/**
 *  Checks if a user already exists in the database with the given name.
 */
function user_exists($uname){
    $users = json_read('users.json');

    // Linear search for the user
    foreach($users as $user){
        if(strtolower($uname) == strtolower($user->username)){
            return true;
        }
    }
    return false;
}

/**
 * Tells whether the user a user is already logged in or not using a session.
 * @return bool Is anyone logged in?
 */
function auth_is_logged_in(){
    $user = $_SESSION['user'] ?? '';
    return trim($user) != '';
}

/**
 * @param object It takes a user and a new user to local storage of user.json 
 */
function add_user($new_user)
{
    $users = json_read('users.json');
    $max = -1;
    foreach($users as $user_max){
        if($user_max->id > $max) $max = $user_max->id;
    }
    $new_id = $max + 1;
    $new_user->id = $new_id;
    $new_user->isAdmin = "False";
    $new_user->voted_for_poll = [];
    // $new_id = $new_user->id;
    $users->$new_id = $new_user;
    json_write('users.json',$users);
}




/**
 * @param object Function to submit answer of a specific poll for the first time by a specific user from local polls.json.
 */
function submit_poll_answer($poll_response,$user_id)
{
    $polls = json_read('polls.json');
    foreach($polls as $poll)
    {
        if($poll->id == $poll_response->id)
        {
            foreach($poll->answers as $key => $answer)
            {
                if($poll->isMultiple == "True")
                {
                    foreach($poll_response->answers as $response_answer )
                    {
                        if($response_answer == $key)
                        {
                            // $poll->key = intval($answer ) + 1;
                            $ans_aux = intval($answer ) + 1;
                            // $poll->answer = $ans_aux;
                            $poll_aux = $poll->answers;
                            $poll_aux->$key = $ans_aux; 
                            // $poll_aux = $ans_aux;
                            
                        }
                    }
                }
                else
                {
                    if($poll_response->answer == $key)
                    {
                        // $poll->key = intval($answer ) + 1;
                        $ans_aux = intval($answer ) + 1;
                        // $poll->answer = $ans_aux;
                        $poll_aux = $poll->answers;
                        $poll_aux->$key = $ans_aux; 
                        // $poll_aux = $ans_aux;
                        
                    }
                }
                
            }

            $voted = $poll->voted;
            if(!in_array($user_id,$voted))
            {
                $voted[] = $user_id;
                $poll->voted = $voted;
            }
            
        }
    }
    // print_r($polls);
    json_write('polls.json',$polls);
}

function add_poll($poll)
{
    $polls = json_read('polls.json',true);
    $polls[] = $poll;
    // $new_id = $poll->id;
    // $polls->$new_id = $poll;
    json_write('polls.json',$polls); 
}

function check_for_voted_poll($user_id,$poll_id)
{
    $polls = json_read('polls.json');
    foreach($polls as $poll)
    {
        if($poll->id == $poll_id)
        {
            return in_array($user_id,$poll->voted);
        }
    }
    return false;
}

function get_username_by_id($user_id)
{
    $users = json_read('users.json');
    foreach($users as $user)
    {
        if($user->id == $user_id)
        {
            return $user->username;
        }
    }
    return null;
}

// function update_poll_response($response )
// {
//     $polls = json_read('polls.json');
//     foreach( $polls as )
// }

function check_poll_exists($poll_id)
{
    $polls = json_read('polls.json');
    foreach($polls as $poll)
    {
       if($poll->id == $poll_id) return true;
    }
    return false;
}

function delete_poll($poll_id)
{
    
    if(check_poll_exists($poll_id))
    {
        $polls = json_read('polls.json',true);
        $data = [];
        foreach($polls as $poll)
        {
            if($poll['id'] != $poll_id)
            {
                $data[] = $poll; 
            } 
        }
        json_write('polls.json', $data);

        return "Poll deleted successfully";
    }

    return "Error! The poll doesn't exist";

}

?>