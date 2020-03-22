Inventory-management-system

This project is to create an application for an inventory management managament system that an end user can interact with via Command line interface. This project has CRUD functionality for Users,Items and Orders

#Prequisites

To create this system
- Dowload an integrated development environment. The one used for this project is Eclipse - (https://www3.ntu.edu.sg/home/ehchua/programming/howto/EclipseJava_HowTo.html)

-Download Java which is used to craete the source code - (https://www3.ntu.edu.sg/home/ehchua/programming/howto/EclipseJava_HowTo.html)

-Create a Google cloud account (GCP) to create an instance to host the database -(https://cloud.google.com/sql/docs/mysql/quickstart)

-Download MySQL to craete the database-(https://dev.mysql.com/doc/mysql-installation-excerpt/8.0/en/windows-install-archive.html

-Download Maven as the build tool-(https://howtodoinjava.com/maven/how-to-install-maven-on-windows/

-Git is used as the VCS in this project-(https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

After setting up, follow these steps:

1)	You can use git to perform a pull request
2)	Open an IDE and,
3)Run the Application to add update delete and read customers and items from your database.


#Installation

Install Eclipse -Ensure that when java is being installed you download both jdk and jre (mainly jdk).

-After downloading eclipse you should then install maven ensuring that it is added to your path file.

-Download the MySQL workbench.

-Create a GCP Instance and generate an IP address to host your database and connect your database to it.

-Add the relevant to plugins such as mockito, apache.maven, junit, mysql connector and other dependencies needed. 

-Ensure that you connect your workspace to your database (via mysql connector plugin).

-Test the connection between your workspace and database by inserting data and querying data.

-Ensure that all relevant JDBC drivers are installed and contain your database name and GCP instance ip address.

#Authors
* **Christopher Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Tapiwa Tiyemba** - *Main body of work*- [ttiyemba](https://github.com/ttiyemba)

##SonarQube Code Quality

![Image description](http://35.189.123.196/sonarqube/dashboard?id=com.qa.ims%3Atapiwa-ims)

## License

This project is licensed under the MIT license - see the LICENSE.md file for details
Apache License, Version 2.0 (LICENSE-APACHE or http://www.apache.org/licenses/LICENSE-2.0)
MIT license (LICENSE-MIT or http://opensource.org/licenses/MIT)
