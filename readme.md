# Build Team Application

Design and build a small application for a football team selection based on input (player profiles ) and provided selection criterion (to qualify as either Striker or Defender).
The final team must have an equal number of Strikers and Defenders .
Output should either have both selection groups(Strikers & Defenders) or none. Select the best candidate if there is a clash.
Below are the class diagrams for selection criteria :
FitnessFactor
- minHeight = 5.8
- maxBmi = 23


StrikerExperienceFactor
- minGoalScored = 50


DefenderExperienceFactor
- minGoalDefended = 30


Sample Input:
Sorted based on name and space separated.
First line: number of rows
Second line: number of columns
Next Lines: Name(string) Height(decimal) BMI(decimal) Scores(int) Defends(int)
4
5
Boateng 6.1 22 24 45
Kaka 6 22 1 1
Ronaldo 5.8 21 120 0
Suarez 5.9 20 100 1
Sample Output:
Sorted based on name.
Boateng SELECT DEFENDER
Kaka REJECT NA
Ronaldo SELECT STRIKER
Suarez REJECT NA
As you can see, selection comprises an equal number (one in this case) of both strikers (Ronaldo) and defenders (Boateng) while the rest (Kaka, Suarez) have been rejected despite one of them (Suarez) matching the selection criteria.
General Guideline :
Your code should be in working condition. Either your code should work from the main method accepting the given input as some data structure or it should read the request from file and run. You can share your zipped code to <<>>. Please write your approach in the README file.


## Solution logic

0. Read input from cmd line
```text
4
5
Boateng 6.1 22 24 45
Kaka 6 22 1 1
Ronaldo 5.8 21 120 0
Suarez 5.9 20 100 1
```

1. classify players as strikers, defenders, rejects and both striker and defenders

2. redistribute both striker and defenders as either striker or defender

3. calculate team size

4. sort the best strikers and defenders and form team

5. generate output 
   
