set /p commit= What commit was made?
git add .
git commit -m "%commit%"
git push -f origin master
PAUSE