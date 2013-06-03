package net.tomoyamkung;

/**
 * JSON のシリアライズ・デシリアライズに失敗したときの例外クラス。
 * 
 * @author tomoyamkung
 *
 */
public class JsonException extends Exception {

	private static final long serialVersionUID = 5099000259963379836L;

	/**
	 * コンストラクタ。
	 * 
	 * @param message エラーメッセージ
	 */
	public JsonException(String message) {
		super(message);
	}

}
