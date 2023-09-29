package com.multitenant.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "API_METADATA_OUTBOUND")
public class APIMetaDataOutbound implements Serializable {
	
	private static final long serialVersionUID = 1591284770889957130L;
	
	public APIMetaDataOutbound() {
	}

	public APIMetaDataOutbound(Integer id, Integer scenarioId, String endpoint, String requestMethod, String username,
			String password, String queryParameters, String authMechanism, String criteria, String tenantId,
			String tenantName) {
		this.id = id;
		this.scenarioId = scenarioId;
		this.endpoint = endpoint;
		this.requestMethod = requestMethod;
		this.username = username;
		this.password = password;
		this.queryParameters = queryParameters;
		this.authMechanism = authMechanism;
		this.criteria = criteria;
		this.tenantId = tenantId;
		this.tenantName = tenantName;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name ="SCENARIO_ID")
	private Integer scenarioId;
	
	@Column(name = "ENDPOINT")
	private String endpoint;
	
	@Column(name = "REQUEST_METHOD")
	private String requestMethod;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "QUERY_PARAMETERS")
	private String queryParameters;
	
	@Column(name = "AUTH_MECHANISM")
	private String authMechanism;
	
	@Column(name = "CRITERIA")
	private String criteria;
	
	@Column(name = "TENANT_ID")
	private String tenantId;
	
	@Column(name = "TENANT_NAME")
	private String tenantName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getScenarioId() {
		return scenarioId;
	}

	public void setScenarioId(Integer scenarioId) {
		this.scenarioId = scenarioId;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthMechanism() {
		return authMechanism;
	}

	public void setAuthMechanism(String authMechanism) {
		this.authMechanism = authMechanism;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	
	public String getQueryParameters() {
		return queryParameters;
	}

	public void setQueryParameters(String queryParameters) {
		this.queryParameters = queryParameters;
	}

	@Override
	public String toString() {
		return "APIMetaDataOutbound [id=" + id + ", scenarioId=" + scenarioId + ", endpoint=" + endpoint
				+ ", requestMethod=" + requestMethod + ", username=" + username + ", password=" + password
				+ ", queryParameters=" + queryParameters + ", authMechanism=" + authMechanism + ", criteria=" + criteria
				+ ", tenantId=" + tenantId + ", tenantName=" + tenantName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(authMechanism, criteria, endpoint, id, password, queryParameters, requestMethod, scenarioId,
				tenantId, tenantName, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		APIMetaDataOutbound other = (APIMetaDataOutbound) obj;
		return Objects.equals(authMechanism, other.authMechanism) && Objects.equals(criteria, other.criteria)
				&& Objects.equals(endpoint, other.endpoint) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password) && Objects.equals(queryParameters, other.queryParameters)
				&& Objects.equals(requestMethod, other.requestMethod) && Objects.equals(scenarioId, other.scenarioId)
				&& Objects.equals(tenantId, other.tenantId) && Objects.equals(tenantName, other.tenantName)
				&& Objects.equals(username, other.username);
	}
}
