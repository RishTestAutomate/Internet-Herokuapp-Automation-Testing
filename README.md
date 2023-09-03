# Internet-Herokuapp-Automation-Testing
This project is a Selenium-based automation testing framework created using Java, Maven, and the Page Object Model (POM) design pattern. It aims to thoroughly test all elements and functionalities available on the website "the-internet.herokuapp.com."

_**Project Components:**_

**Maven Project Structure:**
The project follows a Maven directory structure to manage dependencies and build automation. It includes the following key directories:

**src/main/java:** Contains the Java source code for the Page Objects and utility classes.
**src/main/resources:** contains data files.
**src/test/java:** Contains the test scripts written in Java using TestNG annotations.

**Page Object Model (POM):**
The project adopts the Page Object Model (POM) design pattern to enhance code maintainability and reusability. Each web page on "the-internet.herokuapp.com" has a corresponding Page Object class. These classes encapsulate the page's elements and actions, making it easier to write and maintain test scripts.

**TestNG Framework:**
TestNG is used for organizing and executing test cases. TestNG provides annotations to define test methods, test suites, and test execution orders.

**Selenium WebDriver:**
Selenium WebDriver is employed for web automation. It interacts with the web elements on the pages and performs various actions such as clicking buttons, filling forms, and verifying results.
