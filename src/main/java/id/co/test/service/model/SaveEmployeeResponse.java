package id.co.test.service.model;

import java.sql.Timestamp;

public class SaveEmployeeResponse extends StandardResponse {
	public SaveEmployeeResponse(String responseCode, String responseDesc) {
		super(responseCode, responseDesc, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
	}

}
