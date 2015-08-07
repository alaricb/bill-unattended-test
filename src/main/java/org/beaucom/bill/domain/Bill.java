package org.beaucom.bill.domain;

//import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.codehaus.jackson.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bill 
	//implements Serializable 
	{

    //private static final long serialVersionUID = -5527566248002296049L;

    protected String total;
    protected Statement statement;
	@JsonProperty("package")
    protected Package packages;
	@JsonIgnore
    protected CallCharges callCharges;
	@JsonIgnore
    protected StorePurchases skyStore;

    public String getTotal() {
        return total;
    }

    public void setTotal(String jsonTotal) {
        this.total = jsonTotal;
    }

    public StorePurchases getSkyStore() {
        return skyStore;
    }

    public void setSkyStore(StorePurchases skyStore) {
        this.skyStore = skyStore;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public Package getSkyPackages() {
        return packages;
    }

    public void setSkyPackages(Package packages) {
        this.packages = packages;
    }

    public CallCharges getCallCharges() {
        return callCharges;
    }

    public void setCallCharges(CallCharges callCharges) {
        this.callCharges = callCharges;
    }
}
