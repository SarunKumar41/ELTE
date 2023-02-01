if($args.Count -eq 0){
    Write-Warning "Please enter at least one number!"
    Exit
}

$lt=$args[0]
foreach($num in $args){
    if($num -lt 0)
    {
        Write-Warning "Please enter only positive numbers!"
        Exit
    }
    if($num -lt $lt){
        $lt=$num
    }
}
Write-Host "The smallest number: $lt"