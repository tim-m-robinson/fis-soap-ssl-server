package net.atos;

import javax.xml.ws.Endpoint;
import net.atos.services.BasicCallbackHandler;
import net.atos.services.DummyServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceConfig {
  @Autowired
  private Bus bus;

  @Bean
  public Endpoint endpoint() {
    EndpointImpl endpoint = new EndpointImpl(bus, new DummyServiceImpl());
    endpoint.publish("/dummy");

    endpoint.getProperties().put("ws-security.callback-handler", BasicCallbackHandler.class.getName());

    return endpoint;
  }
}