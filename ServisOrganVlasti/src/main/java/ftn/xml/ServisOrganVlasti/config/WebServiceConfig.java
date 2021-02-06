package ftn.xml.ServisOrganVlasti.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "zahtevi")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema zahtevSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ZahtevPort");
        wsdl11Definition.setLocationUri("/ws/zahtev");
        wsdl11Definition.setTargetNamespace("http://www.ftn.uns.ac.rs/zahtev/soap");
        wsdl11Definition.setSchema(zahtevSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema zahtevSchema() {
        return new SimpleXsdSchema(new FileSystemResource("ServisOrganVlasti/src/main/resources/seme/zahtevWSDL.xsd"));
    }
}