# Offers

#### Status of App: Finished. 

### Functionality
* Any person can see the list of offers availabe by clicking show current offers
* To add an offer you must login
* Then you can submit offer by typing appropriate name, email & text.

### View
![collage](https://user-images.githubusercontent.com/26859920/29335717-36dcee8a-81d1-11e7-965a-e6eeab6e3590.jpg)


### Environment

Java 8, Spring 4, Hibernate 5.4.1, Jsp, Jstl, xml, CSS3, MySQL, Maven, Apache Tomcat v9.0, Eclipse, Git. 

### How to run?
* Download the offers folder and offers.sql file.
* Run .sql with MySQL workbench and create the required database.
* Add resource in context.xml file in the tomcat server folder.
```
<Resource name="jdbc/offers" auth="Container" type="javax.sql.DataSource"
		maxTotal="100" maxIdle="30" maxWaitMillis="10000" username="ReplaceWithYourUserName"
		password="ReplaceYourPassword" driverClassName="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/offers" />
```
* Import the Offers folder into eclipse as a maven project.
* Build a war using Maven and deploy it into Tomcat server.
* To start the application start the server.`http://localhost:8080/Offers/`
