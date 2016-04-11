import org.apache.ws.axis2.*;

public class Client {

	public static void main(String[] args) throws Exception {
		// Create the stub object
		HelloServiceStub stub = new HelloServiceStub();

		// Create the request
		HelloServiceStub.Add request = new HelloServiceStub.Add();

		// Set the parameters
		request.setArgs0(10);
		request.setArgs1(20);

		// Invoke the service
		HelloServiceStub.AddResponse response = stub.add(request);
		int ans = response.get_return();	// 10 + 20 = 30
		System.out.println("Response : " + ans);
	}

}