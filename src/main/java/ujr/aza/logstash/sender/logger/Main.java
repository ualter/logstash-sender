package ujr.aza.logstash.sender.logger;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import ujr.aza.logstash.sender.logger.LogService.Direction;
import ujr.aza.logstash.sender.logger.tests.CodeReason;
import ujr.aza.logstash.sender.logger.tests.DetailsAppl;
import ujr.aza.logstash.sender.logger.tests.JaxbObjectForTestingOne;

public class Main {
	
	public static void main( String[] args )
    {
    	HttpLogStashSender httpSender = new HttpLogStashSender("localhost",31311);
    	
    	testComplexJAXBObject(httpSender);
    	testSimpleJAXBObject(httpSender);
    	testStringMessage(httpSender);
    	testNotPreparedJAXBObject(httpSender);
    }

	private static void testStringMessage(HttpLogStashSender httpSender) {
		StringBuilder fileRequest = mockXMLMessage();
    	httpSender.log("","testStringMessage",Direction.REQUEST,fileRequest.toString(),"comentarios");
	}
	
	

	private static void testSimpleJAXBObject(HttpLogStashSender httpSender) {
		JaxbObjectForTestingOne d = new JaxbObjectForTestingOne();
    	d.setRepeatingBlockName(1002);
    	d.setValue(232);
    	httpSender.log("","testSimpleJAXBObject",Direction.REQUEST,d,"comentarios");
	}
	
	private static void testNotPreparedJAXBObject(HttpLogStashSender httpSender) {
		List<String> list = new ArrayList<String>();
    	list.add("UALTER");
    	list.add("JUNIOR");
    	httpSender.log("","testNotPreparedJAXBObject",Direction.REQUEST,list,"");
	}

	private static void testComplexJAXBObject(HttpLogStashSender httpSender) {
		DetailsAppl a = new DetailsAppl();
    	List<CodeReason> list = new ArrayList<CodeReason>();
    	CodeReason c = new CodeReason();
    	c.setCode("456");
    	c.setDocumentEvidenceRequired("123");
    	c.setRepeatingBlockName(45);
    	c.setText("Ualter");
    	list.add(c);
    	a.reasonCode = list;
    	httpSender.log("","testComplexJAXBObject",Direction.REQUEST,a,"comentarios");
	}

	private static StringBuilder mockXMLMessage() {
		StringBuilder fileRequest = new StringBuilder();
    	try {
			Path path = Paths.get( HttpLogStashSender.class.getClassLoader().getResource("soap-request.xml").toURI() );
			Files.lines(path).forEach(s -> fileRequest.append(s).append("\n"));
			//List<String> list = Files.lines(path).collect(Collectors.toList());
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
		return fileRequest;
	}

}
