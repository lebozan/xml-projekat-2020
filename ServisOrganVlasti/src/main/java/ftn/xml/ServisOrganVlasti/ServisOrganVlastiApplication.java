package ftn.xml.ServisOrganVlasti;

import ftn.xml.ServisOrganVlasti.model.korisnik.Korisnik;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@SpringBootApplication
public class ServisOrganVlastiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServisOrganVlastiApplication.class, args);
	}

	@Bean
	public MarshallingHttpMessageConverter marshallingHttpMessageConverter()
	{
		MarshallingHttpMessageConverter marshallingHttpMessageConverter = new MarshallingHttpMessageConverter();

		marshallingHttpMessageConverter.setMarshaller(jaxb2Marshaller());
		marshallingHttpMessageConverter.setUnmarshaller(jaxb2Marshaller());

		return marshallingHttpMessageConverter;
	}

	@Bean
	public Jaxb2Marshaller jaxb2Marshaller()
	{
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		FileSystemResource[] fsr = new FileSystemResource[] {
				new FileSystemResource(".//src//main//resources//seme//korisnik.xsd")
		};
		jaxb2Marshaller.setSchemas(fsr);
		Class[] classes = new Class[] {Korisnik.class};
		jaxb2Marshaller.setClassesToBeBound(classes);
		return jaxb2Marshaller;
	}

}
