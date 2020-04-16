package com.arrow.acn.client.cloud.aws;

import java.io.Serializable;

public class ShadowDocument implements Serializable {
	private static final long serialVersionUID = 6461967977077487220L;

	private long messageNumber;
	private ShadowRequest payload;
	private int qos;
	private long timestamp;
	private String topic;

	public long getMessageNumber() {
		return messageNumber;
	}

	public void setMessageNumber(long messageNumber) {
		this.messageNumber = messageNumber;
	}

	public ShadowRequest getPayload() {
		return payload;
	}

	public void setPayload(ShadowRequest payload) {
		this.payload = payload;
	}

	public int getQos() {
		return qos;
	}

	public void setQos(int qos) {
		this.qos = qos;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (messageNumber ^ (messageNumber >>> 32));
		result = prime * result + ((payload == null) ? 0 : payload.hashCode());
		result = prime * result + qos;
		result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShadowDocument other = (ShadowDocument) obj;
		if (messageNumber != other.messageNumber)
			return false;
		if (payload == null) {
			if (other.payload != null)
				return false;
		} else if (!payload.equals(other.payload))
			return false;
		if (qos != other.qos)
			return false;
		if (timestamp != other.timestamp)
			return false;
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		return true;
	}
}
