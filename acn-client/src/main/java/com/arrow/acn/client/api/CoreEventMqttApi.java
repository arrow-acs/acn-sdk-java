/*******************************************************************************
 * Copyright (c) 2018 Arrow Electronics, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License 2.0
 * which accompanies this distribution, and is available at
 * http://apache.org/licenses/LICENSE-2.0
 *
 * Contributors:
 *     Arrow Electronics, Inc.
 *******************************************************************************/
package com.arrow.acn.client.api;

import java.net.URI;
import java.util.Collections;

import com.arrow.acn.client.AcnClientException;
import com.arrow.acs.JsonUtils;
import com.arrow.acs.client.api.ApiConfig;
import com.arrow.acs.client.model.CloudMqttRequestParams;
import com.arrow.acs.client.model.CloudRequestMethodName;
import com.arrow.acs.client.model.CloudResponseModel;
import com.arrow.acs.client.model.StatusModel;

public class CoreEventMqttApi extends MqttApiAbstract {

	CoreEventMqttApi(ApiConfig apiConfig, CouldResponseProcessorApi couldResponseProcessorApi) {
		super(apiConfig, couldResponseProcessorApi);
	}

	public void putFailed(String requestId, String hid, String error) {
		String method = "putFailed";
		try {
			// build the same URI as for http call
			URI uri = buildUri(CoreEventApi.PUT_FAILED_URL.replace("{hid}", hid));
			// get string path
			String strPath = getUrlString(uri);
			// build JSON body similar as for http call
			String jsonBody = JsonUtils.toJson(Collections.singletonMap("error", error));
			// prepare message params
			// NOTE: encrypted is false by default
			CloudMqttRequestParams params = new CloudMqttRequestParams();
			params.setRequestId(requestId);
			params.setHttpMethod(CloudRequestMethodName.PUT);
			params.setUrl(strPath);
			params.setJsonBody(jsonBody);
			// send message
			send(params);
			logDebug(method, "message sent with requestId: " + requestId);
		} catch (Throwable e) {
			logError(method, e);
			throw new AcnClientException(method, e);
		}
	}

	public void putReceived(String requestId, String hid) {
		String method = "putReceived";
		try {
			// build the same URI as for http call
			URI uri = buildUri(CoreEventApi.PUT_RECEIVED_URL.replace("{hid}", hid));
			// get string path
			String strPath = getUrlString(uri);
			// prepare message params
			// NOTE: encrypted is false by default
			CloudMqttRequestParams params = new CloudMqttRequestParams();
			params.setRequestId(requestId);
			params.setHttpMethod(CloudRequestMethodName.PUT);
			params.setUrl(strPath);
			// send message
			send(params);
			logDebug(method, "message sent with requestId: " + requestId);
		} catch (Throwable e) {
			logError(method, e);
			throw new AcnClientException(method, e);
		}
	}

	public void putSucceeded(String requestId, String hid) {
		String method = "putSucceeded";
		try {
			// build the same URI as for http call
			URI uri = buildUri(CoreEventApi.PUT_SUCCEEDED_URL.replace("{hid}", hid));
			// get string path
			String strPath = getUrlString(uri);
			// prepare message params
			// NOTE: encrypted is false by default
			CloudMqttRequestParams params = new CloudMqttRequestParams();
			params.setRequestId(requestId);
			params.setHttpMethod(CloudRequestMethodName.PUT);
			params.setUrl(strPath);
			// send message
			send(params);
			logDebug(method, "message sent with requestId: " + requestId);
		} catch (Throwable e) {
			logError(method, e);
			throw new AcnClientException(method, e);
		}
	}

	public static StatusModel parsePutFailedResponse(CloudResponseModel responseModel) {
		return parseAnyResponse(responseModel);
	}

	public static StatusModel parsePutReceivedResponse(CloudResponseModel responseModel) {
		return parseAnyResponse(responseModel);
	}

	public static StatusModel parsePutSucceededResponse(CloudResponseModel responseModel) {
		return parseAnyResponse(responseModel);
	}

	private static StatusModel parseAnyResponse(CloudResponseModel responseModel) {
		verifyCloudResponseResponse(responseModel);
		try {
			StatusModel statusModel = new StatusModel();
			statusModel.setStatus(responseModel.getParameters().get(CloudResponseModel.STATUS_PARAMETER_NAME));
			statusModel.setMessage(responseModel.getParameters().get(CloudResponseModel.MESSAGE_PARAMETER_NAME));
			return statusModel;
		} catch (Throwable e) {
			// TODO: handle exception
		}
		return null;
	}

}
