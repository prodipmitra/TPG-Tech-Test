# TPG-Tech-Test

## Created by Prodip Mitra(PM) on 30 June 2017
## Purpose: Technical test - submitted to TPG
## Jar file name: tpg.tech.test-1.0-SNAPSHOT-jar-with-dependencies.jar
## version : 1.0

## Technologies used:
  ### Java 8
  ## Eclipse 
  ## Maven


#### Instructions to execute the jar:
 You have to configure the config.properties file to run the jar.
	- For question 1:
    iptextfile_location i.e. the text file where the list of ips will be supplied to validate (q1)
	- regexp - to validate the ips. You don't need to provide unless you want to create a new regular expression
	- Student information for question 2.
For question 3 you can check the time applied for q1 and q2.
	 
For executing the jar file you have to supply two parameters :
	1. q1 or q2 as the first parameter:
		- q1 means the implementaion of question 01
		- q2 means the implementaion of question 02
	2. File path for config.properties
		- for example F:/TPG/config.properties
		
Example: java -jar tpg.tech.test-1.0-SNAPSHOT-jar-with-dependencies.jar q1 F:/TPG/config.properties

