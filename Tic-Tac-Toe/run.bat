@echo off
setlocal enabledelayedexpansion
cd /d "%~dp0"

javac *.java
if errorlevel 1 goto :eof
java TicTacToe


