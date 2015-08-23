The computer chooses a 4-digit number in secret. The digits must all be different.  The user then guesses the number and the computer provides the number of matching digits. If the matching digit is in the right position it is a "bull", if it is on a different position it is a "cow".For example:

Computer chooses:  3691

User guesses:  1649

Computer answers: 1 bull and 2 cows

If the user guesses a number with repeat digits that is partially correct the rule is that a correct digit can only count once and bulls count before cows. So for example

Computer chooses:  3691

User guesses:   4211

Computer answers: 1 bull and 0 cows

Oracle.java: represents "computer" player

Game.java: simulates playing one round of the game continuously until the user wins
