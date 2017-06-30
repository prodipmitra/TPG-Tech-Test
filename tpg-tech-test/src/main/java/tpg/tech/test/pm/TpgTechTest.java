package tpg.tech.test.pm;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class TpgTechTest {

	private static final Logger log = Logger.getLogger(TpgTechTest.class);

	
	public void doIpValidation(){
		
		BufferedReader br = null;
		try 
		{
			String fileName=TpgEnvironmentProperties.getProperty("iptextfile_location");
			br = new BufferedReader(new FileReader(fileName));
			String sCurrentLine;

			ArrayList<String> Ips = new ArrayList<String>();
			ArrayList<String> validIps = new ArrayList<String>();
			
			while ((sCurrentLine = br.readLine()) != null) {
				Ips.add(sCurrentLine);
			}
			
			IPValidationRegex ipValidationRegex=new IPValidationRegex();
			validIps=ipValidationRegex.getVlaidIPList(Ips);
			
			log.info("[doIpValidation] List of input ips for validation:");
			for(String ipsTochk:Ips){
				System.out.println(ipsTochk);
			}
			
			if(validIps.size()>0){
				log.info("[doIpValidation] Tolal valid ips="+validIps.size()+"\n Valid Ips:");
				for(String validIp:validIps){
					System.out.println(validIp);
				}
			}
			else{
				log.info("[doIpValidation] No valid IP found in the list");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void sortStudentByGPA()
	{
		
		String studnetIds[]=TpgEnvironmentProperties.getProperty("student_ids").split(",");
		
		Student[] students = new Student[5];
		
		if(studnetIds.length>0)
		{
			for(int inddex=0;inddex<studnetIds.length;inddex++)
			{
				log.info(studnetIds[inddex]);
				int studentid=(Integer.parseInt(studnetIds[inddex].toString()));
				String studentName=TpgEnvironmentProperties.getProperty("student_"+studentid+"_name").toString();
				double studentGpa=Double.parseDouble(TpgEnvironmentProperties.getProperty("student_"+studentid+"_gpa").toString());
				
				Student student=new Student(studentid, studentName,studentGpa);
				students[inddex]=student;
			}
		}	
			
		Arrays.sort(students, Student.getStudentGPAComparator());
		int i=0;
		for(Student temp: students){
		   System.out.println("Student " + ++i + " : " + temp.getName());
		}

	}
		


	public static void main(String[] args) 
	{
		try
		{
			TpgTechTest tpgTechTest = new TpgTechTest();
			
			
			if(args.length>0)
			{
				String confPath1=args[1];
				new TpgEnvironmentProperties(confPath1);
				
				String log4jConfigFile=TpgEnvironmentProperties.getProperty("logfile_location");
				DOMConfigurator.configure(log4jConfigFile);
				
				
				long startTime=0;
				long stopTime=0;
				long elapsedTime=0;
				
				if(args[0].toString().equals("q1"))
				{
					startTime = System.currentTimeMillis();
					tpgTechTest.doIpValidation();
					stopTime = System.currentTimeMillis();
				    elapsedTime = stopTime - startTime;
				    log.info("[main] Time requied to complete[IP validation]in Mili seconds: "+elapsedTime);
				}
				else if(args[0].toString().equals("q2"))
				{
					startTime = System.currentTimeMillis();	
					tpgTechTest.sortStudentByGPA();
					stopTime = System.currentTimeMillis();
				    elapsedTime = stopTime - startTime;
					log.info("[main] Time requied to complete[Sort Students by GPA]in Mili seconds: "+elapsedTime);
				}
				
			}
			else
			{
				log.info("Please provide two parametes. Example: q1 or q2 and config file location.");
				
			}
		}
		catch(Exception e){
			log.info("[main]: Error orrcured @line: "+e.getStackTrace()[0].getLineNumber(),e);
		}
	}
	

}
