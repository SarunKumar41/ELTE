param ([Int]$n)

if($n -lt 0)
{
    Write-Warning "Please enter only positive number"
    Exit
}

$num=0
for($i=0;$i -ne $n;$i++){
    $num = $num + $n
    Write-Host -NoNewline "$num "
}