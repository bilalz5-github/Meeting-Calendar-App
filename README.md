Meeting Scheduler App
Overview
This Android application is designed to help users schedule, search, and update meetings. It allows users to input meeting details such as title, place, participants, and date/time. The app supports a date and time picker, displaying meeting summaries, and provides search functionality based on meeting date, time, or participants.

Features
Schedule a Meeting: Users can input meeting details, including the title, place, participants, and date/time.
View Meeting Summary: After scheduling a meeting, a summary of the meeting is displayed.
Search Meetings: Users can search for meetings based on the participants or the meeting date/time.
Update Meetings: Users can update previously scheduled meetings.
Technologies Used
Android SDK
Java
XML for UI design
Android Intents and Activities
App Flow
MainActivity:

Users can input meeting details (title, place, participants, date/time).
Users can view a summary of the meeting after submitting.
Users can search for meetings or update existing ones.
SearchMeetingActivity:

Users can search for meetings by entering a participant's name or meeting date/time.
MeetingSummaryActivity:

Displays a summary of the scheduled meeting once it is created.
Meeting Class:

Represents a meeting object with attributes like title, place, participants, and date/time.
Implements Parcelable to allow passing data between activities.
