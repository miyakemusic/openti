package openti.server;

public class SocketMessage {
	public enum Type {
		Command,
		Query,
		Message
	}
	
	public Type type;
	public String body;
	
	public SocketMessage() {}
	
	public SocketMessage(Type type, String body) {
		this.type =  type;
		this.body = body;
	}
}
