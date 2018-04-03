IT 323 Midterm Project
Client/Server programming using Sockets
Problem Specification
Create a project management application having the modules stated below:

A. Admin module functionalities
  o Starting and stopping the server.
  o Registering users (updating and setting users to inactive state).
  o Creating a project and eventually assigning the project leader from the registered users.
  o Viewing the list of projects. Filtering must also be applied on the list (on-going and completed).
B. Project leader module functionalities
  o Viewing of the list of projects assigned to him/her both as leader and as member (filtering the list
    must be present).
  o Assigning members of the project assigned to him/her as leader from the list of registered users.
  o Updating the list of members.
  o Setting the status of the project to completed once the project is already done.
  Note: the effect of this would disable the project from the viewpoint of the members.
  o Uploading file/s for modification by the members.
C. Project member module functionalities
  o Viewing of the list of projects assigned to him/her as member.
  o Uploading file/s for modification by other members or by the leader.

Other Specifications
  o All modules should have a login facility. For users other than the admin, part of the login credentials
    should be the IP address and port of the server.
  o Uploaded files
       Restricted to the project where the file was uploaded
       Newly uploaded
  Creates a “node” which is named after the filename of the uploaded file.
  This node is expandable showing a sub-node showing the details: user who uploaded the file,
  date and time when the file was uploaded, and a brief description what the file is about.
       Update of a previously uploaded file
         Should be placed as a sub-node with the details specified above.
         Sub-nodes must be shown with the most current as the first item.
    o Chat facility
       Every project should have a chat facility confined only to the users of the project.
       Users must be notified of the “unseen” messages when the user has not opened a project.
 
Notes
  o Each group must be comprised of 6 members maximum.
     The details above are the basic requirements of the project. You are to provide additional
      functionalities such as (but not limited to): posting of announcements, calendar - schedule of
      tasks, private messaging of users, buzzing of a user, and conferencing (for 3 or more users).
  o Rating of the project will be based on the following:
       Completeness of the basic requirements – 50 pts.
       Provision of additional functionalities – 15 pts.
       Documentation – 15 pts.
      
Project description, users’ manual, and data design
   Peer evaluation – 20 pts.
    o Be creative in designing your user interfaces keeping “user-friendliness” in mind.

What to submit
o Flash Drive – 3 folders: Source codes (and resources), Archived files (executable *.rar), and
Documentation o Hard copy of the documentation
