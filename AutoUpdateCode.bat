git add .
set /p commit= What commit was made?
git commit -m "%commit%"
git push origin master
PAUSE