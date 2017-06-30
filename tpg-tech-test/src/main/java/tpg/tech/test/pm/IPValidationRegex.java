package tpg.tech.test.pm;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

public class IPValidationRegex {

	private static final Logger log = Logger.getLogger(IPValidationRegex.class);
	private Pattern pattern;
    private Matcher matcher;

    private static final String IPADDRESS_PATTERN =TpgEnvironmentProperties.getProperty("regexp");
    		
    		
    public IPValidationRegex()
    {
	  pattern = Pattern.compile(IPADDRESS_PATTERN);
    }

   
    public ArrayList<String> getVlaidIPList(ArrayList<String> ipList)
    {
    	ArrayList<String> validList=new ArrayList<String>();
    	try
    	{
	    	for(String ip:ipList){
	    		boolean isValid=validateIP(ip);
	    		if(isValid){
	    			validList.add(ip);
	    		}
	    	}
    	}
    	catch (Exception e) {
			log.error("[getVlaidIPList] Error found during generationg list of valid ips:"+e.getMessage());
		}
    	return validList;
	}
   
    /**
     * Validate ip address with regular expression
     * @param ip address for validation
     * @return true valid ip address, false invalid ip address
     */
     public boolean validateIP(String ip)
     {
    	 try
    	 {
    		 matcher = pattern.matcher(ip);
    	 }	
    	 catch (Exception e) {
 			log.error("[validateIP] Error found during validatin ip:"+e.getMessage());
 		}
    	 return matcher.matches();
     }

}
