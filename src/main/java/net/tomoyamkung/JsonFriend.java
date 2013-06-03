package net.tomoyamkung;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Friend オブジェクトのシリアライズ・デシリアライズを扱うクラス。
 * 
 * @author tomoyamkung
 *
 */
public class JsonFriend extends BaseJson {
	
	/**
	 * 「友だち」を格納するリスト
	 */
	@Expose
	@SerializedName("targets")
	public List<Friend> friends;

	/**
	 * JsonFriend オブジェクトにデシリアライズする。
	 * 
	 * @param json デシリアライズする JSON
	 * @return JsonFriend オブジェクト
	 * @throws JsonException デシリアライズに失敗した場合
	 */
	public static JsonFriend fromJson(String json) throws JsonException {
		JsonFriend fromJson = new Gson().fromJson(json, JsonFriend.class);
		if(!fromJson.isSuccess()) {
			throw new JsonException(fromJson.message);
		}
		
		return fromJson;
	}
	
	/**
	 * JsonFriend オブジェクトをシリアライズする。
	 * 
	 * @return シリアライズした文字列
	 */
	public String toJson() {
		return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(this);
	}

	/**
	 * 「友だち」をリストに追加する。
	 * 
	 * @param friend Friend オブジェクト
	 */
	public void add(Friend friend) {
		if(friends == null) {
			friends = new ArrayList<Friend>();
		}
		friends.add(friend);
	}
}
