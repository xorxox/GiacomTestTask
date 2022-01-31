
# Automation Tester Tech Test

## How to run tests

Cukes are aggregators of features, each cuke can contain many different features. 
Tests in cukes can be run via maven. Run following command in project directory (you will however need to have
installed maven on your PC).

mvn clean install test -Dcuke=GiacomCuke

With this command, all tests will be executed.

### How to setup Maven and Java

Please follow instruction on following link:
https://howtodoinjava.com/maven/how-to-install-maven-on-windows/

## Why this framework was selected

I did not have much free time to actually study C# framework provided, therefore I selected something in which
I can finish all tests quickly. I am also very familiar with it.

## Technicalities

Chromedriver is part of application, it's in source root, so this framework can run on both Windows and Linux, and it is 
present for case application cannot connect to outer world from test server where executed.

WebElements xpath could be simplified, however it is good practice having more than just straight forward element ID.

Same as all pages are extension of BasePage, to get all WebElement and Webdriver operations, 
Steps are extension of BaseTest for similar reason, to be able to reuse shared operations (for example reading from files), 
or to inject shared components into project (for example verification component class). It's not used in this test, 
however is good practice to always think ahead when creating anything. 
