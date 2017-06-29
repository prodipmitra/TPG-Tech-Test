# TPG-Tech-Test

##### Author:Prodip Mitra(PM)
##### Purpose: a) Validate a list of ips, b) sort a list of students  and c) Measure the time for execution of a method in a class
##### Module: tpg.tech.test-1.0-SNAPSHOT-jar-with-dependencies.jar
##### version : 1.0

##### Technologies used: ####### Java 8 ####### Eclipse ####### Maven

Here I have uploaded the source code and executable jar as well. If you want to run the code please execute the jar. You can also run the raw code from eclipse as well. Here I did'nt use any hard coded input parameters and that's why I used confg.properties configuration file. For testing you can change any input parameters and you don't need to build the jar again.This is the benefit of reading input from configuration file. Normally during PROD environment, if we can manage the configuration properly, lots of time we can avoid re deployment for minor changes.

#### Instructions to execute the jar:
 	You have to configure the config.properties file to run the jar.
	- For question 1: iptextfile_lcation i.e. the text file where the list of ips will be supplied to validate
	- For question 2: Student information
	- For question 3 you can check the time by testing the code for q1 and q2.
	 	
	## To execute the jar file you have to supply two parameters :
	## 1. q1 or q2 as the first parameter:
		- q1 means the implementaion of question 01
		- q2 means the implementaion of question 02
	## 2. File path for config.properties
		- for example F:/TPG/config.properties
		
	### Example: java -jar tpg.tech.test-1.0-SNAPSHOT-jar-with-dependencies.jar q1 F:/TPG/config.properties

