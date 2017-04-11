package com.arrow.acn.client.model;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import com.arrow.acs.client.model.ModelAbstract;

public class DeviceStateModel extends ModelAbstract<DeviceStateModel> {
	private static final long serialVersionUID = -7961247436531023595L;

	private String deviceHid;
	private Map<String, DeviceStateValueModel> states = new HashMap<>();

	public DeviceStateModel withDeviceHid(String deviceHid) {
		setDeviceHid(deviceHid);
		return this;
	}

	public DeviceStateModel withStates(Map<String, DeviceStateValueModel> states) {
		setStates(states);
		return this;
	}

	public DeviceStateModel withState(String name, String value) {
		states.put(name, new DeviceStateValueModel().withValue(value).withTimestamp(Instant.now()));
		return this;
	}

	public String getDeviceHid() {
		return deviceHid;
	}

	public void setDeviceHid(String deviceHid) {
		this.deviceHid = deviceHid;
	}

	public Map<String, DeviceStateValueModel> getStates() {
		return states;
	}

	public void setStates(Map<String, DeviceStateValueModel> states) {
		this.states = states;
	}

	@Override
	protected DeviceStateModel self() {
		return this;
	}
}
