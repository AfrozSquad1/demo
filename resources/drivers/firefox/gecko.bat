@echo off
echo "Starting gecko driver on windows"
set "MYPATH=%*"             
set "MYPATH=chdir /d %MYPATH%"
echo "%MYPATH%"

%~dp0\geckodriver.exe %* 2>&1 | findstr /V addons.manager | findstr /V DEBUG | findstr /V INFO

