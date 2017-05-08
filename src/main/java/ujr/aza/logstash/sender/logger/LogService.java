package ujr.aza.logstash.sender.logger;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

public class LogService {
	
	public enum Direction {
		REQUEST, RESPONSE;
	}
	
	private String    orchestration = "";
	private String    service       = "Not_Filled";
	private Direction direction     = Direction.REQUEST; 
	private String    message       = "Not_Filled";
	private String    comment       = "";
	
	public LogService() {
		super();
	}

	public String getService() {
		return service;
	}
	
	public void setService(String service) {
		if ( service == null ) {
			throw new IllegalArgumentException("Service cannot be null");
		}
		this.service = StringUtils.substring(service, 0, 30).replaceAll(" ", "_");
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getOrchestration() {
		return orchestration;
	}

	
	public void setOrchestration(String orchestration) {
		this.orchestration = orchestration;
	}

	
	public Direction getDirection() {
		return direction;
	}

	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	
	public String getMessage() {
		return message;
	}

	
	public void setMessage(String message) {
		if ( message == null ) {
			throw new IllegalArgumentException("Message cannot be null");
		}
		String requestCleanXMLforJSON = StringEscapeUtils.escapeJson(message);
    	/*String requestCleanXML = request
    			.replaceAll("\\\\", "&#92;")
    			.replaceAll("\"", "\\\\\"")
    			.replaceAll("\\n", " ");*/
		this.message = requestCleanXMLforJSON;
	}

	/**
	 * I know, I know... there are superb ready libraries to convert a POJO Object to a JSON, fast, easily and with lots of resources. (like Jackson)
	 * But...  this class might be used (for now) at a very complex environment, that might be very complex to take with other 
	 * dependencies (like the JACKSON JSON library) JAR files, though...  the conversion will be realized in the most simple way.
	 */
	public String toJson() {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("    \"orchestration\":\"").append(this.orchestration)   .append("\",");
		sb.append("    \"service\":\"")      .append(this.service)         .append("\",");
		sb.append("    \"direction\":\"")    .append(this.direction.name()).append("\",");
		sb.append("    \"message\":\"")      .append(this.message)         .append("\",");
		sb.append("    \"comment\":\"")      .append(this.comment)         .append("\"");
		sb.append("}");
		return sb.toString();
	}
	
	public static Builder Instance(String service) {
		return new Builder(service);
	}
	
	public static class Builder {
		
		private LogService logService = new LogService();
				
		private Builder(String service) {
			this.logService.setService(service);
		}
		
		public Builder service(String service) {
			logService.setService(service);
			return this;
		}
		
		public Builder direction(Direction direction) {
			logService.setDirection(direction);
			return this;
		}
		
		public Builder comment(String comment) {
			logService.setComment(comment);
			return this;
		}
		
		public Builder message(String message) {
			logService.setMessage(message);
			return this;
		}
		
		public LogService build() {
			return this.logService;
		}
		
	}
	
	

}
