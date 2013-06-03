package net.tomoyamkung;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * 「友だち」を表すクラス。
 * 
 * @author tomoyamkung
 *
 */
public class Friend {
	
	/**
	 * ID
	 */
	@Expose
	public String id;
	
	/**
	 * ユーザ名
	 */
	@Expose
	@SerializedName("user_name")
	public String name;
	
	/**
	 * 管理番号
	 */
	@Expose
	@SerializedName("user_number")
	public String number;
	
	/**
	 * コンストラクタ。
	 * 
	 * @param id ID
	 * @param name 名前
	 * @param number 管理番号
	 */
	public Friend(String id, String name, String number) {
		this.id = id;
		this.name = name;
		this.number = number;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("ID:%s, ユーザ名:%s, 管理番号:%s", id, name, number);
	}

}
