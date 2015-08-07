package org.beaucom.bill.domain;

import java.io.Serializable;
import java.util.List;

public class Packages implements Serializable {

    private static final long serialVersionUID = -5527566248002296049L;
    protected Packages skyPackages;

    public Packages getSkyPackages() {
        return skyPackages;
    }
    public void setSkyPackages(Packages skyPackages) {
        this.skyPackages = skyPackages;
    }
}
