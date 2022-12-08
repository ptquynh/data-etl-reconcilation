# data-etl-reconcilation
## Structure framework
 |Folders/Files| Package | Class | Description |
 |:---| :---    | :----|         :---|
 |src/main/java|com.etl.common||Includes all common class java|
 |||ExcelToObjectMapper.java|Used to map columns in the excel with table''s columns|
 |||TestBase.java|Define contanst variables|
 |||TestLogger.java|Use to print message in test log|
 |||Utils.java|All common functions which will be used in all other classes|
 ||com.etl.common.database||Includes all common class java which related to Connection Database or Excel|
 |||DatabaseUtils.java|All common function as get/delete/compare data in database|
 |||ExcelUtils.java|All common function as get/delete/compare data in the excel file|
 |||DBConn.java|Use to create connection to a Database|
 ||com.etl.common.email||
 |||SendEmail.java|Use to send report via email|
 ||com.etl.common.tables||Use to store Table Model classes java|
 ||com.etl.generate.test.data||
 |||GenerateTestData.java|Use to insert and update test data into the Database|
 ||com.etl.generate.classJava||
 |||CreateTableModelClass.java|Use to create Table Model Class java|
 |||CreateTestScriptClass.java|Use to create Test Script Class java|
 ||com.etl.testReport||
 |||CustomReporter.java|Use to generate Test Report|
 |src/main/resources|input-excel-file||Use to store all excel file where has test cases and test data|
 ||output-sql-file||Use to store all insert sql statement queries after generate test data from the excel file|
 |src/test/java|com.etl.test.testconfig||Use to store Test Configuration as connection Database before running test scripts|
 ||com.etl.test.testscripts||Use to store test scripts classess|
 |src/test/resources|test-suites||Use to store test suite xml|
 |pom.xml|||Use to store configuration's information to execute test|
## How to Generate Test data and Save into Database
```
Step 1: Go to the Project's folder
Step 2: Sure that the test data excel file is stored in src/main/resources/input-excel-file
Step 3: Open Pom.xml file
Step 4: Find <profile> tag with id = gen-table-model
Step 5: Add <argument> tag with database information
Step 6: Add <argument> tag with table name in the databsae in step 5 above
Step 7: Save all changes in POM xml file
Step 8: Open Window Terminal or Git bash Terminal
Step 3: Generate Table model by following command: mvn compile exec:java -Pgen-table-model
Step 4: Go to src/main/java folder
Step 5: Open "GenerateTestData.java" in package "com.etl.generate.test.data"
Step 6: Clone "genSqlStatementBookTable" funtion
Step 7: Modify the new funtion in step 6 above with new table model which is created in step 3
Step 8: Save all changes of the file
Step 9: Open Pom.xml file
Step 10: Find <profile> tag with id = gen-test-data
Step 11: Add <argument> tag with databse information where you want to insert test data into
Step 12: Add <argument> tag with table name where you want to insert test data into
Step 13: Add <argument> tag with the test data excel file where stored test data
Step 14: Add <argument> tag with sql output file where will store INSERT SQL STATEMENTS
Step 15: Save all changes in POM xml file
Step 16: Open Window Terminal or Git bash Terminal
Step 17: Run following commands: mvn compile exec:java -Pgen-test-data
```
## How to Generate Test Script from Test Case file
```
Step 1: Go to the Project's folder
Step 2: Sure that the test case excel file is stored in src/main/resources/input-excel-file
Step 3: Open Pom.xml file
Step 4: Find <profile> tag with id = gen-test-script
Step 5: Add <argument> tag with file name and path as in step 3 above
Step 6: Add <argument> tag with sheet index where stored test data
Step 7: Save all changes in POM xml file
Step 8: Open Window Terminal or Git bash Terminal
Step 9: Run following commands: mvn compile exec:java -Pgen-test-script
```
## How to Run Test Suite
```
Step 1: Go to the Project's folder
Step 2: Sure that test suite xml file is stored in src/test/resources/test-suites
Step 3: Open Pom.xml file
Step 4: Find <systemPropertyVariables> tag
Step 5: Update database information for source and target database
Step 6: Find <suiteXmlFiles> tag
Step 7: Add more <suiteXmlFile> tage for new test suite xml
Step 8: Save all changes in POM xml file
Step 9: Open Window Terminal or Git bash Terminal
Step 10: Go to the Project's folder
Step 11: Run following commands: mvn test -Prun-test-suite
```
## How to Send Test Report via Email
```
Step 1: Go to the Project's folder
Step 2: Open Pom.xml file
Step 3: Find <profile> tag with id ="send-email"
Step 4: Update email address which will be received Test Report
Step 5: Save all changes in POM xml file
Step 6: Open Window Terminal or Git bash Terminal
Step 7: Go to the Project's folder
Step 8: Run following commands: mvn compile exec:java -Psend-email
```
