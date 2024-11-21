Meeting Scheduler App
🚀 Overview
The Meeting Scheduler App is an Android application designed to streamline the process of scheduling, viewing, and managing meetings. The app allows users to easily schedule meetings by providing necessary details such as title, location, date/time, and participants. It also includes search functionality to find scheduled meetings and provides an intuitive summary view of each meeting.

🛠 Features
Schedule a Meeting: Input the title, location, participants, and date/time of the meeting.
Meeting Summary: View a detailed summary of scheduled meetings.
Search Meetings: Search meetings by participant names or meeting dates.
Edit Meetings: Update meeting details when necessary.
Intuitive UI: Simple and user-friendly interface to make scheduling efficient.
🖥 Technologies Used
Android SDK: The core platform used to build the app.
Java: Programming language used for app development.
XML: Used for designing the app's user interface.
Intents & Activities: For screen navigation and data passing between different views.
💻 App Workflow
1. MainActivity: Schedule a Meeting
The user inputs the following details:
Meeting Title
Meeting Location
Participants' Names
Date and Time
After submitting, the user is taken to the Meeting Summary screen that displays all the entered details.
2. SearchMeetingActivity: Search for a Meeting
Users can search for meetings based on:
Participant’s Name
Meeting Date/Time
The search results will display matching meetings.
3. MeetingSummaryActivity: View Meeting Details
Displays a detailed summary of the meeting, including:
Meeting Title
Location
Date and Time
Participants
Provides the option to update meeting details.
4. Meeting Class: Representing Meeting Data
The Meeting class holds all the necessary details for a meeting:
Title
Location
Participants
Date/Time
Implements the Parcelable interface to pass meeting data between activities.
📦 Setup Instructions
Clone this repository to your local machine:

bash
Copy code
git clone https://github.com/yourusername/meeting-scheduler-app.git
Open the project in Android Studio.

Ensure all necessary SDKs are installed.

Build and run the app on an Android emulator or a physical device.
