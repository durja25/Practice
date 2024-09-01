@echo off
set "MainFolder=E:\Phoenix_WS\application\phoenix\phoenix-main\tmp\"

@REM  Delete all files inside the main folder
del /s /q \\?\"%MainFolder%*.*"

@REM  del /s /q \\?\"C:\Users\gkamble\testdelete"
@REM for /d %i in ("C:\Users\gkamble\testdelete - Copy\*") do rmdir /s /q "%i"
@REM  Delete all subdirectories inside the main folder
for /d %%i in ("%MainFolder%*") do (
    rmdir /s /q "%%i"
)
