package net.tomoyamkung;

import com.google.gson.annotations.Expose;

/**
 * JSON をシリアライズ・デシリアライズする基底クラス。
 * 
 * @author tomoyamkung
 *
 */
public class BaseJson {
	
	private static final String RESULT_OK = "OK";

	/**
	 * 実行結果を格納する。
	 * 
	 * <ul>
	 * <li>実行結果が成功 → OK</li>
	 * <li>実行結果が失敗 → NG</li>
	 * </ul>
	 */
	@Expose
	public String result;
	
	/**
	 * エラーメッセージを格納する。
	 * 
	 * 実行結果が失敗だった場合にエラーメッセージを格納する。
	 */
	@Expose
	public String message;

	/**
	 * 実行結果が正しかったかを問い合わせる。
	 * 
	 * @return 正しかった場合は true
	 */
	public boolean isSuccess() {
		return RESULT_OK.equals(result);
	}
}
