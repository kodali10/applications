# User Management

#### Status of App: 
Backend side of app is completed and endpoints are ready to take requests. Client Side app need's to be build(Angular). 

### Functionality
* Here we can create, get all users, get user by id, get user by name, delete user by id & delete all users


### View
<img width="363" alt="screen shot 2017-08-15 at 4 35 21 pm" src="https://user-images.githubusercontent.com/26859920/29338025-325a2604-81d9-11e7-982a-56429738c0f5.png">


### Environment

Java 8, Spring 4, Hibernate 5.4.1, Jsp, Jstl, JSON, xml, CSS3, MySQL, Maven, Apache Tomcat v9.0, Eclipse, Git. 

### How to run?
* Download the userManagement folder and UserManagement.sql file.
* Run .sql with MySQL workbench and create the required database.
* Add resource in context.xml file in the tomcat server folder.
```
<bean id="dataSource"
		class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
		<property name="url" value="jdbc:mysql://localhost:3306/UserManagement"></property>
		<property name="username" value="DBUserName"></property>
		<property name="password" value="DBpassword"></property>
	</bean>
```
* Import the userManagement folder into eclipse as a maven project.
* Build a war using Maven and deploy it into Tomcat server.
* To start the application start the server.`http://localhost:8080/UserManagement/`
