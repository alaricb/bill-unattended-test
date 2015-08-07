package org.beaucom.bank;

import junit.framework.Assert;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.apache.log4j.Logger;
import java.io.IOException;
import org.apache.http.HttpStatus;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
//import org.hamcrest.core.*;
//import static org.hamcrest.CoreMatchers.*;

public class EndpointTest {

	protected static Logger logger = Logger.getLogger("service");
    private EndpointTest classUnderTest;
    
    @Mock
    private HttpClient mockHttpClient;
    
	// TODO move URL to props file
    private final static String BILLURL = "http://safe-plains-5453.herokuapp.com";
    private final static String BILLDATA = "/bill.json";
    private final static String ENDPOINT = BILLURL + BILLDATA;
    
    private final static String CONTAINS_STATEMENT = "statement";
    private final static String CONTAINS_PERIOD = "period";
    private final static String CONTAINS_TOTAL = "total";

    protected String billContent = null;

    @Test
    public void EndPointIsActive() throws IOException {
        //given
        HttpClient client = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(ENDPOINT);
		HttpResponse response = null;
		String responseString = null;

		try {
			response = client.execute(httpget);
			responseString = EntityUtils.toString(response.getEntity());
			this.setBillContent(responseString);

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//then
		Assert.assertEquals(response.getStatusLine().getStatusCode(),HttpStatus.SC_OK);
		//test content
		//assertThat(responseString, containsString(CONTAINS_STATEMENT));
		//assertThat(responseString, containsString(CONTAINS_PERIOD));
		//assertThat(responseString, containsString(CONTAINS_TOTAL));
    }

// TODO move into separate class?
//    @Test
//    public void Content() {
//		JsonUtilImpl json = new JsonUtilImpl();
//		JSONObject jsonObject = json.parseJsonObject(sCurrentLine);
//        JSONArray inputArray = (JSONArray) jsonObject.get("services");
//        logger.debug("Services array length: "+inputArray.toArray().length);
//    }

    @Before
    public void setUp() {
        classUnderTest = new EndpointTest();
        MockitoAnnotations.initMocks(this);
    }

    public String getBillContent() {
        return billContent;
    }

    public void setBillContent(String billContent) {
        this.billContent = billContent;
    }
}
