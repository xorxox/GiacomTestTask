#Automation Tester Tech Test

## How to run tests

Cukes are aggregators of features, each cuke can contain many different features. 
Tests in cukes can be run via maven. Run following command in project directory (you will however need to have
installed maven on your PC). 

mvn clean install test -Dcuke=GiacomCuke

With this command, all tests will be executed.

## Why this framework was selected

I did not have much free time to actually study C# framework provided, therefore I selected something in which
I can finish all tests quickly. I did not have much time for final touch, therefore there is missing logging throughout 
application. However, it's prepared for its addition.
