param($fname)

$content=@()
$words=@()
$content+=get-content $fname 
for($i=0;$i -lt $content.Length;$i++)
{
    $line=$content[$i]
    $first=$line.split(";")[0]
    $second=$line.split(";")[1]
    if($first -ne $second)
    {
          $words+=$second 
    }  
}
[string]$result=$words
$result.replace(" ",",")