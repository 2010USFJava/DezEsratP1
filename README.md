# DezEsratP1 #

## About The Project ##

  Tuition Reimbursement Management System purpose  is to provide a system that encourages quality knowledge growth relevant to an individual’s expertise. Each employee is allowed to claim up to $1000.00 in tuition reimbursement per year and  have different standard reimbursement coverage. Employees can login and submit requests for the reimbursement. Employees must complete the Tuition Reimbursement form with required information .Benefits Coordinator will view all reimbursement requests and based on their history he will approve and deny requests.

  ### Technologies Used ###
  
  - Spring Tools Suite
  - Java
  - PostgreSQL
  - Servlet
  - HTML
  - CSS
  - JavaScript
  - AJAX
  - JASON
  - SESSION
  - Tomcat
  - DBeaver
  
## Getting Started ##

 1. Set up your database in Amazon RDS through the AWS website.
 2. In the database.properties file add (endpoint connection(url), the username, and the password)
 3. Establish the connection in DBeaver
 4. create a new schema and create new tables.
 5. Installed Apache Tomcat Version 9.0.
 6. Start the server.
 7. Run the DezEsratP1 project in Spring Tool Suite.
 8. Go to http://localhost:8080/DezEsratP1/login.html
  
## Features ##
 -  Can login as 3 different types of user (requester, BenCo, and DirectSuperivisor)
 -  Requester 
    - Can create a new reimbursement request form
    - Can view all the status of all reimbursement forms asccociated with their user id
    - Can submit a final grade for any of their open reinmbursement forms ("open" as in not awarded or denied)
 - DirectSuperivor
    - Can view all the reimbursement request forms that have been submitted by any requester
    - Can approve or deny a reimbursement form
 - BenCo
    - Can view all the reimbursement request forms that have been approved by the DirectSupervisor
    - Can approve or deny a reimbursement form
 - Can logout and be sent back to the login page
 
## Contributers ##
Dezmanique Martin and Esrat Jahan
