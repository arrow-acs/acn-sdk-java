/*******************************************************************************
 * Copyright 2021 Konexios, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.konexios.acn.client.model;

import java.io.Serializable;

public class SshTunnelModel implements Serializable {
	private static final long serialVersionUID = 7782369592963322583L;

	private String remoteHost;
	private int remotePort;
	private String remoteUser;
	private String remotePassword;
	private int localPort;
	private String localUser;
	private String localPassword;

	public SshTunnelModel withRemoteHost(String remoteHost) {
		setRemoteHost(remoteHost);
		return this;
	}

	public SshTunnelModel withRemotePort(int remotePort) {
		setRemotePort(remotePort);
		return this;
	}

	public SshTunnelModel withRemoteUser(String remoteUser) {
		setRemoteUser(remoteUser);
		return this;
	}

	public SshTunnelModel withRemotePassword(String remotePassword) {
		setRemotePassword(remotePassword);
		return this;
	}

	public SshTunnelModel withLocalPort(int localPort) {
		setLocalPort(localPort);
		return this;
	}

	public SshTunnelModel withLocalUser(String localUser) {
		setLocalUser(localUser);
		return this;
	}

	public SshTunnelModel withLocalPassword(String localPassword) {
		setLocalPassword(localPassword);
		return this;
	}

	public String getRemoteHost() {
		return remoteHost;
	}

	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}

	public int getRemotePort() {
		return remotePort;
	}

	public void setRemotePort(int remotePort) {
		this.remotePort = remotePort;
	}

	public String getRemoteUser() {
		return remoteUser;
	}

	public void setRemoteUser(String remoteUser) {
		this.remoteUser = remoteUser;
	}

	public String getRemotePassword() {
		return remotePassword;
	}

	public void setRemotePassword(String remotePassword) {
		this.remotePassword = remotePassword;
	}

	public int getLocalPort() {
		return localPort;
	}

	public void setLocalPort(int localPort) {
		this.localPort = localPort;
	}

	public String getLocalUser() {
		return localUser;
	}

	public void setLocalUser(String localUser) {
		this.localUser = localUser;
	}

	public String getLocalPassword() {
		return localPassword;
	}

	public void setLocalPassword(String localPassword) {
		this.localPassword = localPassword;
	}
}
