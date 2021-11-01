package com.mastercard.fld.utility;

import java.io.IOException;

import com.mastercard.developer.encryption.EncryptionException;
import com.mastercard.fld.BaseClassUtil;
import com.mastercard.fld.api.fld.ApiCallback;
import com.mastercard.fld.api.fld.ApiClient;
import com.mastercard.fld.api.fld.api.ConfirmedFraudManagementApi;
import com.mastercard.fld.api.fld.api.ConfirmedFraudSubmissionApi;

import okhttp3.Call;
import okhttp3.Response;

public class RequestHelper {

	public void initiateNonEncryptClient() {
		BaseClassUtil.setUpEnv();
	}
	
	public void initiateEncryptClient() throws EncryptionException {
		BaseClassUtil.setUpEncryptionEnv();
	}
	
	public ConfirmedFraudManagementApi apiManageclient() {
		return new ConfirmedFraudManagementApi(BaseClassUtil.getClient());
	}
	
	public ConfirmedFraudSubmissionApi apiSubmissionclient() {
		return new ConfirmedFraudSubmissionApi(BaseClassUtil.getClient());
	}
	
	public ApiClient getClient() {
		return BaseClassUtil.getClient();
	}
	
	public ApiCallback getCallback() {
		return BaseClassUtil.getCallback();
	}
	
	public Response apiCall(Call call)throws IOException {
		return call.execute();
	}
}
