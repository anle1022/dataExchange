package gz.jszx.webService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName="deptWebService", portName="deptWebServicePort", name="PojoPortType", targetNamespace="http//:DeptWS")
public interface DeptWebService {

	@WebMethod
	public String findDepts();
	
	@WebMethod
	public int add(@WebParam(name="i") int i,@WebParam(name="j")int j);
}
