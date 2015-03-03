package bom;

import interfaces.IntBomObject;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import utils.MD5Digest;

public class BSMember implements IntBomObject{
	private String pseudo;
	private String password;
	private String token;
	private long userId;
	private boolean inAccount;
	private Map<Long, BSMemberShow> mapIdShow;
	
	public BSMember(String pseudo) {
		super();
		this.pseudo = pseudo;
	}
	
	
	public BSMember(String pseudo, String password) {
		super();
		this.pseudo = pseudo;
		try {
			this.password = MD5Digest.md5Digest(password);
		} catch (NoSuchAlgorithmException e) {
			this.password = null;
			e.printStackTrace();
		}
	}


	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId2) {
		this.userId = userId2;
	}
	public boolean isInAccount() {
		return inAccount;
	}
	public void setInAccount(boolean inAccount) {
		this.inAccount = inAccount;
	}
}
