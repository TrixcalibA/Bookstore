# Bookstore
Resell your old textbooks to other students

# Deployed Project
[Bookstore](http://35.160.163.175/)
[Project Homepage](http://cs580.yusun.io/teams-winter2017/TrixcalibA/index.html)

# Running Locally
### Requirements

  - Eclipse
  - Grails 2.5.0
  - Groovy

### Environment Setup
  - Follow these [instructions](https://www.first8.nl/nieuws/eclipse-neon-grails-2-x-with-groovy-and-gsp-support/) to set up Eclipse with GGTS plugin for Grails
  - Install WTP Eclipse plugin [here](http://download.eclipse.org/webtools/updates) to enable reading *.js and *.html files.
  - Download grails-2.5.0.zip [here](https://grails.org/download.html), and unzip the folder

### Import Project into Eclipse
  1. Use Eclipse's import project feature to import this project's grails project files
  2. Click on the Configure Grails Configuration and select the path the the unzipped grails 2.5.0 folder
  3. To ensure to compiler mismatch error, right click project -> select Groovy Compiler to 2.4 

### Starting the Project Locally
  - Right click the project -> click Run As -> Grails Command (run-app)
  - The website will be launched at localhost:8080/Bookstore
