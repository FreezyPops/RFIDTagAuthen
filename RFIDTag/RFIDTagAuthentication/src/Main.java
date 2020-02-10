@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetupChannel();
	}
	
	private static void SetupChannel() {
		Client client = new Client("127.0.0.1", 5000);
		
		//Listen for set of {Ci, Cem}
		//Use fake PUF for generating responses {Ri, Rem}
		//Send responses
		//Listen for {TIDit, PID}
		
	}
	
	
	private static void Authenticate() {
		//
	}

}
