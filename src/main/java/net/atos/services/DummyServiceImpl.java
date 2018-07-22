package net.atos.services;

import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

@WebService(name="echo",
            endpointInterface="net.atos.services.DummyService",
            targetNamespace = "http://net.atos",
            wsdlLocation = "classpath:cxf-test.wsdl",
            serviceName = "dummyService",
            portName = "dummyPort"
            )
@HandlerChain(file="classpath:handlers.xml")
public class DummyServiceImpl implements DummyService {
	
  @Resource(name = "wsContext")
  WebServiceContext ctx;

  public String echo(String message) {
    return message;
  }

  public String reverse(String message) {
	return new StringBuilder(message).reverse().toString();
  }

}