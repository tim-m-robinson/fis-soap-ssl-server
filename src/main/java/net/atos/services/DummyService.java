package net.atos.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(targetNamespace = "http://net.atos")
@SOAPBinding(style = Style.RPC)
public interface DummyService {

  @WebMethod(action="echoAction", operationName = "echoOperation")
  public String echo(String message);

  @WebMethod(action="reverseAction", operationName = "reverseOperation")
  public String reverse(String message);

}
