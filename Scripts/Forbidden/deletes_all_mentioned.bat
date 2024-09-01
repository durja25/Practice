@echo off

setlocal enabledelayedexpansion

REM Set the folder paths as static arguments
set "folder1=E:\Phoenix_WS\application\phoenix\phoenix-main\tmp\"
set "folder2=E:\wildfly\standalone\log\"
set "folder3=E:\wildfly\standalone\tmp\"


REM Loop through each folder path in the array and delete files and subdirectories
for %%F in ("%folder1%" "%folder2%" "%folder3%") do (
    set "MainFolder=%%~F"


    REM Delete all files inside the main folder
    del /s /q \\?\"!MainFolder!*.*"

    REM Delete all subdirectories inside the main folder
    for /d %%i in ("!MainFolder!*") do (
        rmdir /s /q "%%i"
    )
)

echo Deletion completed for all specified folders.
endlocal