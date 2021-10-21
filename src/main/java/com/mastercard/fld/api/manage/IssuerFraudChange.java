package com.mastercard.fld.api.manage;

import com.mastercard.developer.encryption.EncryptionException;
import com.mastercard.fld.BaseClassUtil;
import com.mastercard.fld.api.fld.ApiException;
import com.mastercard.fld.api.fld.ApiResponse;
import com.mastercard.fld.api.fld.api.ConfirmedFraudManagementApi;
import com.mastercard.fld.api.fld.model.Fraud;
import com.mastercard.fld.api.fld.model.UpdatedIssuerFraud;

public class IssuerFraudChange {

	public static void main(String[] args) {
		ApiResponse<Fraud> fraudResp = submitIssuerFraudChange(createChangeRequest("292328194169030", "2742"));
	}

	public static ApiResponse<Fraud> submitIssuerFraudChange(UpdatedIssuerFraud changeIssuer) {
		ConfirmedFraudManagementApi manageApi = null;
		try {
			BaseClassUtil.setUpEncryptionEnv();
			manageApi = new ConfirmedFraudManagementApi(BaseClassUtil.getClient());
			return manageApi.updateIssuerFraudWithHttpInfo(changeIssuer);
		} catch (ApiException | EncryptionException exception) {
			return null;
		}
	}

	public static UpdatedIssuerFraud createChangeRequest(String acn, String ica) {
		UpdatedIssuerFraud request = new UpdatedIssuerFraud();
		request.setRefId("ecb2d943-eabd-42y6-87wd-69c19792vjg2");
		request.setTimestamp("2021-07-04T01:34:37-06:00");
		request.setIcaNumber(ica);
		request.setAcquirerId("2742");
		request.setAuditControlNumber(acn);
		request.setCardNumber("5587450000000009197");
		request.setFraudTypeCode("01");
		request.setFraudSubTypeCode("U");
		request.setCardProductCode("CIR");
		request.setMerchantId("6698696");
		request.setMerchantName("1234");
		request.setMerchantCity("city");
		request.setMerchantStateProvinceCode("CO");
		request.setMerchantCountryCode("USA");
		request.setMerchantPostalCode("78786");
		request.setMerchantCategoryCode("6010");
		request.setTerminalAttendanceIndicator("1");
		request.setTerminalId("0");
		request.setTerminalOperatingEnvironment("1");
		request.setTerminalCapabilityIndicator("0");
		request.setCardholderPresenceIndicator("0");
		request.setCardPresenceIndicator("0");
		request.setCardInPossession("Y");
		request.setCatLevelIndicator("2");
		request.setPosEntryMode("06");
		request.setCvcInvalidIndicator("M");
		request.setAvsResponseCode("A");
		request.setAuthResponseCode("40");
		request.setSecureCode("0");
		request.setAccountDeviceType("A");
		request.setMemo("Fraud change");
		return request;
	}
}