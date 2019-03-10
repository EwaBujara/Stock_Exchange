## `Stock Exchange`
>Spring MVC, Hibernate

Application imitating action of *Stock Exchange*

(Minimally Viable Product)

`User` can:
* create an account
* define his `Balance` using `deposit` and `withdraw` 
* can `buy` and `sell` stocks 
(the possibility of transaction depends of `User's` balance and `Stock` available quantity) 

Technologies:
* Spring MVC
* Hibernate 
* JSP

===== TO DO: ====
* Getting `Stock` current course from external server (HTTP, JSON) 
* Developed data validation
* `User` personal data edition

=================
This application is complete Maven-Project. Contains all necessary files.
  
Steps needed to launch application:
* create mySQL database `stock_exchange`
* import project to Your IDE
* in `persistence.xml` define:
property name="javax.persistence.jdbc.user" value="YOUR mySQL USERNAME"
property name="javax.persistence.jdbc.password" value="YOUR mySQL PASSWORD"
* define Your local server configuration: http://localhost:8080
* launch Your local server
* In browser use: http://localhost:8080 and then create a new account :)
   


