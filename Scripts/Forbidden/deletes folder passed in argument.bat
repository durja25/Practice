@echo off

REM Check if folders are provided as arguments
if "%~1"=="" (
    echo Please provide folder paths to delete.
    echo Usage: %~nx0 "Folder1" "Folder2" "Folder3" ...
    exit /b 1
)

REM Loop through each provided folder and delete files and subdirectories
for %%A in (%*) do (
    set "MainFolder=%%~A"

    REM Delete all files inside the main folder
    del /s /q \\?\"%MainFolder%\*.*"

    REM Delete all subdirectories inside the main folder
    for /d %%i in ("%MainFolder%\*") do (
        rmdir /s /q "%%i"
    )
)

echo Deletion completed for all specified folders.
