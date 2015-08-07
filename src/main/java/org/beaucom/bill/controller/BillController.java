package org.beaucom.bill.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;
import org.apache.http.HttpResponse;
import javax.json.*;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import org.beaucom.bill.domain.Bill;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import java.lang.NullPointerException;
import javax.annotation.Resource;
import javax.naming.NamingException;
import java.lang.reflect.Field;

@Controller
@RequestMapping("/bill")
public class BillController {
	
	protected static Logger logger = Logger.getLogger("controller");
    // TODO move URL to props file
    private final static String BILLURL = "http://safe-plains-5453.herokuapp.com";
    private final static String BILLDATA = "/bill.json";
    private final static String ENDPOINT = BILLURL + BILLDATA;

	 /**
	* retrieves bill from endpoint and show it in a JSP page
	*
	* @return the name of the JSP page
	*/
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public String getBill(Model model) {
        logger.info("Received request to display bill");
		Bill bill = null;

		RestTemplate restTemplate = new RestTemplate();
        logger.info("ENDPOINT: "+ENDPOINT);
logger.info("restTemplate: "+restTemplate);
		ResponseEntity<Bill> response = restTemplate.getForEntity(ENDPOINT, Bill.class);
logger.info("response: "+response);

         //logger.info(response.getBody().getStream().getDocWrapper()
                    //.getLocation());

//logger.info("Bill.total: "+response.getTotal());
        // Attach to the template Model
        model.addAttribute("bill", bill);

        // This will resolve to /WEB-INF/jsp/bill.jsp
        return "bill";
    }
}
