package com.fishNdream.backend.security;


import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String username;
	private List<String> roles;
	private boolean isFirst;
	private boolean isSuperAdmin;

	public JwtResponse(String accessToken, String username, List<String> roles, boolean isFirst, boolean isSuperAdmin) {
		this.token = accessToken;
		this.username = username;
		this.roles = roles;
		this.setFirst(isFirst);
		this.setSuperAdmin(isSuperAdmin);
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public boolean isFirst() {
		return isFirst;
	}

	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}

	public boolean isSuperAdmin() {
		return isSuperAdmin;
	}

	public void setSuperAdmin(boolean isSuperAdmin) {
		this.isSuperAdmin = isSuperAdmin;
	}
}