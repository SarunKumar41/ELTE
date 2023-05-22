
# Poll Voting System (PHP assignment - home project)

**This is a general poll voting system implemented using PHP. [Click here to check it out]http://webprogramming.inf.elte.hu/students/iwcyyd/Poll_Voting_System/ **

## Task description

The system is based on the task description provided below :

In this home assignment you need to create a web application where logged-in users can cast their votes on polls (questionnaires/forms). Admin users can create polls for which users can vote by selecting one or more options. On the main page, all polls in the system are listed. Polls that have already ended are at the bottom, while the ongoing polls appear at the top of the page.

### Preparation

* The application will need to store the polls, the users, and the votes that have been submitted by the users on a poll. We have included one possible storage format below as an example, but you may freely choose any other format.
* Your submission also needs to contain some already prepared polls that the users can vote on. Each user can cast only one vote per poll but can change it before the deadline expires. If your site does not include authentication, a user can cast an unlimited number of votes.
* A special administrative user must be created whose login details are fixed. See the description for admin functions below.

### Main page
* On the listing page (a.k.a. the main/index page) a creative title and a short description about the application should be visible as static text.
* The main page is also accessible to unauthenticated users who are free to browse the polls displayed here.
* The most recently created poll should always appear at the top of the page. Following it must be the other polls ordered descending by the date of creation. The polls should be listed in two sections on the page:
    * Polls whose deadline has not yet expired are displayed in the top section.
    * Polls that have already been closed are displayed in the bottom section. Their results are displayed as well.
* The following elements should appear for each poll:
    * the ID / number of the poll;
    * the time of creation;
    * the voting deadline;
    * a button to vote.
* A button belongs to each poll where votes can be submitted to that poll on the voting page. If your site contains session management and authentication but the user is not logged in yet, redirect the user to the login page instead.

### Voting page
* The voting page should display the following information about a given poll:
    * the text (description) of the poll;
    * the possible options/choices;
    * the voting deadline;
    * the time of creation.
* A submit button should appear below the possible options. By clicking on it, your vote will be stored persistently. Verify that the user has selected a (valid) option and notify them if they haven't. Also notify the user if the vote has successfully been submitted.

### Poll creation page
* Show a form on the poll creation page where the following fields are present and can be saved:
    * the text of the poll (text);
    * the possible options/choices (textarea - with one option per line for simplicity);
    * whether multiple options can be selected (radio);
    * the voting deadline (date);
    * the time of creation (date - not a required field but needs to be stored);submit button (submit).
* If your solution contains authentication and authorization, then poll creation should only be accessible to the admin user. (See: admin features)

### Authentication pages
* The login and registration page should be accessible from the main page.
* During registration users must enter their username, email address, and their password. The password must be entered twice. All fields are required, the email must be a valid email format, and the two passwords must match. In case of an error, display appropriate error messages! The form must be persistent, so after an error, previously filled data should remain in the form. Upon successful registration, save the data and redirect the user to the login page!
* On the login page users can identify themselves with their username and password. If there was an error logging in, display a message about it under the login form! After successful login, redirect the user to the main page.

### Admin features
Create a special user named admin with password admin who can:
* create new polls
* delete polls
