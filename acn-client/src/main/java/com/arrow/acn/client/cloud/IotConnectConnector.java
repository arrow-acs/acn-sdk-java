/*******************************************************************************
 * Copyright (c) 2017 Arrow Electronics, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License 2.0
 * which accompanies this distribution, and is available at
 * http://apache.org/licenses/LICENSE-2.0
 *
 * Contributors:
 *     Arrow Electronics, Inc.
 *******************************************************************************/
package com.arrow.acn.client.cloud;

import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

import com.arrow.acn.MqttConstants;
import com.arrow.acn.client.IotParameters;

public class IotConnectConnector extends MqttConnectorAbstract {
    private String iotConnectMqttVHost;
    private String apiKey;

    public IotConnectConnector(String url, String iotConnectMqttVHost, String apiKey, String gatewayHid) {
        super(url, gatewayHid);
        this.iotConnectMqttVHost = iotConnectMqttVHost;
        this.apiKey = apiKey;
    }

    @Override
    protected MqttConnectOptions mqttConnectOptions() {
        MqttConnectOptions options = super.mqttConnectOptions();
        options.setUserName(String.format("%s:%s", iotConnectMqttVHost, getGatewayHid()));
        options.setPassword(apiKey.toCharArray());
        return options;
    }

    @Override
    protected String publisherTopic(IotParameters payload) {
        return MqttConstants.gatewayToServerTelemetryRouting(getGatewayHid());
    }

    @Override
    protected String publisherBatchTopic(List<IotParameters> payload) {
        return MqttConstants.gatewayToServerTelemetryBatchRouting(getGatewayHid());
    }

    @Override
    protected String publisherGzipBatchTopic(List<IotParameters> payload) {
        return MqttConstants.gatewayToServerTelemetryGzipBatchRouting(getGatewayHid());
    }

    @Override
    protected String subscriberTopic() {
        return MqttConstants.serverToGatewayCommandRouting(getGatewayHid());
    }
}
