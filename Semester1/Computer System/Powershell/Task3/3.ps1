param($fname)

if (Test-Path $fname )
{
    get-content $fname | ForEach-Object {
        $_[1]+""+$_[2]
    } 
}
else 
{
    Write-Host "The file does not exist"
}