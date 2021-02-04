package ftn.xml.ServisOrganVlasti.rdf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "conn")
public class AuthenticationProperties {



    private String connectionUri = "xmldb:exist://%1$s:%2$s/exist/xmlrpc";
    private String host="localhost";
    private String port="8081";
    private String endpoint;
    private String dataset;
    private String query;
    private String update;
    private String data;
    public String getEndpoint() {
        return endpoint;
    }
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
    public String getDataset() {
        return dataset;
    }
    public void setDataset(String dataset) {
        this.dataset = dataset;
    }
    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query;
    }
    public String getUpdate() {
        return update;
    }
    public void setUpdate(String update) {
        this.update = update;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public String getQueryEndpoint() {
        return String.join("/", endpoint, dataset, query);
    }

    public String getUpdateEndpoint() {
        return String.join("/", endpoint, dataset, update);
    }

    public String getDataEndpoint() {
        return String.join("/", endpoint, dataset, data);
    }

    public String getUri() {
        return String.format(this.connectionUri, this.host, this.port);
    }

}

