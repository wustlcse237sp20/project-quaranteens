# cse237-project
--------------------------------------ITERATION 2--------------------------------------
WHAT WAS COMPLETED:
- Issues in Iteration 1:
	- Fixed JUnit Tests for FrontPage
	- Finished up Progress Bar
	- Program now reads and generate's tip from a .txt file
	- Created new branches to be organized by feature
- Added a Recommendations page, which generates a random book/music/movie recommendation per day
- Created UI for the Diary page and methods
- Added JUnit testing for both Recommendation and Diary tabs

WHAT WE INTEND TO COMPLETE NEXT ITERATION:
- Finish Diary so that it works
- Maybe a Checklist???

THINGS THAT ARE IMPLEMENTED BUT DON'T NECESSARILY WORK:
- There is a bash script, but right now running it does not run the program properly
- The Diary does not save/remove/navigate entries yet


--------------------------------------ITERATION 1--------------------------------------
WHAT WAS COMPLETED:

- Tab functionality (user can switch between the tabs)
- Counter that shows the “quarantine day” (counts up per day)
- Tip of the day (that changes upon opening the program each time)
- Progess bar?

WHAT WE INTEND TO COMPLETE NEXT ITERATION:
- Add content for each tab (recs, menu items)
- Let user create a journal entry and store it as a file
- Create a working checklist that user can add to

THINGS THAT ARE IMPLEMENTED BUT DON’T NECESSARILY WORK:

- Currently the tips are randomly selected from an array that is hard-coded into the program. We plan to change this so that the tips are instead randomly selected from a external file.
- The program doesn’t save things between opening and closing, so it cannot exactly detect when the date is changed. It can only count the days by subtracting the current date from a set date.
- Progress bar is doing this weird thing where the maximum and current values are not registering.
- The Diary feature can be edited, but there is no save function.
- Many tabs still have yet to implement their features.

OTHER NOTES

- Some of the commits are empty files that will be developed further later.
