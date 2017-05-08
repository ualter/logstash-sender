package ujr.aza.logstash.sender.logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ujr.aza.logstash.sender.logger.LogService.Direction;

/**
 * Hello world!
 *
 */
public class HttpLogStashSender
{
    private final String logStashURL;
    private final int logStashPort;
    
    public HttpLogStashSender(String url, int port) {
    	this.logStashURL = url;
    	this.logStashPort = port;
    }
    
    public void log(String orchestration, String service, Direction direction, Object jaxbObject, String comment) {
    	String resultXML = "";
    	try {
    		StringWriter sw = new StringWriter();
    		javax.xml.bind.JAXB.marshal(jaxbObject, sw);
    		resultXML = sw.toString();
    	} catch (Throwable e) {
    		// Any failed attempt to cast the Object to XML, using JAXB, let's inform the user that this failed with some
    		// possibly useful information, and not stop the process, as this is just a Logging process
    		resultXML = "Failed attempted ("+ e.getMessage() +") to convert the object \"" + jaxbObject + "\" to XML. Try yourself and send to log as Text for now. Sorry! :(";
    	}
    	this.log(orchestration,service,direction,resultXML,comment);
    }
    
    public void log(String orchestration, String service, Direction direction, String message, String comment) {
    	try {
	    	String json = LogService.Instance(service)
	    							.direction(direction)
	    							.message(message)
	    							.comment(comment)
	    							.build()
	    							.toJson();
	        log(json);
    	} catch (Throwable e) {
    		// This is just a log system, if it failed, it cannot stop and disturb nothing of the main program, let it go for now
    		e.printStackTrace();
    	}
    }
    
    private void log(final String formattedMessage) {
    	ExecutorService executor = Executors.newSingleThreadExecutor();
    	executor.execute(new Runnable() {
			public void run() {
				HttpURLConnection connection = null;
				try {
					URL url = new URL("http://" + logStashURL + ":" + logStashPort);
					connection = (HttpURLConnection)url.openConnection();
					
					connection.setRequestMethod("POST");
					connection.setUseCaches (false);
			        connection.setDoOutput(true);
			        
			        connection.setRequestProperty("Content-Length", String.valueOf(formattedMessage.toString().length()));
			        
			        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
			        out.write(formattedMessage.toString());
			        out.flush();
			        out.close();
			        
			        int responseCode = connection.getResponseCode();
					out("\nSending 'POST' request to URL: " + url);
					out("Content: " + formattedMessage.toString());
					out("Response Code: " + responseCode);

					BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					StringBuffer response = new StringBuffer();
					String inputLine;
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();
					
				} catch (MalformedURLException e) {
					// This is just a log system, if it failed, it cannot stop and disturb nothing, let it go
					e.printStackTrace();
				} catch (IOException e) {
					// This is just a log system, if it failed, it cannot stop and disturb nothing, let it go
					e.printStackTrace();
				} finally {
					if ( connection != null ) {
						connection.disconnect();
					}
				}
			}
		});
    	executor.shutdown();
    }
    
    private void out(String msg) {
    	System.out.println(msg);
    }
  
}
