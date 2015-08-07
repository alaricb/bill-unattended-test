package org.beaucom.bill.domain;

import java.io.Serializable;
import java.util.List;

public class StorePurchases implements Serializable {

    private static final long serialVersionUID = -5527566248002296049L;
    protected Statement statement;
    protected Packages skyPackages;
    protected CallCharges callCharges;
    protected StorePurchases skyStore;

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

    public Packages getSkyPackages() {
        return skyPackages;
    }

    public void setSkyPackages(Packages skyPackages) {
        this.skyPackages = skyPackages;
    }

    public CallCharges getCallCharges() {
        return callCharges;
    }

    public void setCallCharges(CallCharges callCharges) {
        this.callCharges = callCharges;
    }
}
