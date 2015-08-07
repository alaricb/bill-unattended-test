package org.beaucom.bill.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Period {

	protected Date from;
	protected Date to;

	@JsonSerialize(using=DateSerializer.class)
	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	@JsonSerialize(using=DateSerializer.class)
	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}
}
