package org.arc.entity;
/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version ����ʱ�䣺2017��10��28�� ����5:00:23
 */
public class Token {
	private int tokenId;
	private String token;
	private int userId;
	
	public Token() {
		super();
	}
	public Token(int tokenId, String token, int userId) {
		super();
		this.tokenId = tokenId;
		this.token = token;
	}
	
	public int getTokenId() {
		return tokenId;
	}
	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
