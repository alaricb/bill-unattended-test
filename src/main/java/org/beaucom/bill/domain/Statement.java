package org.beaucom.bill.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
/**
 * Class represents the entire JSON response
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Statement {

	private Statement statement;

	protected Date generated;
    protected Date due;
    protected Period period;

	@JsonSerialize(using=DateSerializer.class)
    public Date getGenerated() {
        return generated;
    }

    public void setGenerated(Date generated) {
        this.generated = generated;
    }

	@JsonSerialize(using=DateSerializer.class)
    public Date getDue() {
        return due;
    }

    public void setDue(Date dueDate) {
        this.due = dueDate;
    }

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	
	public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
}
