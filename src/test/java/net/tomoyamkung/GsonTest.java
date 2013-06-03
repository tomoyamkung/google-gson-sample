package net.tomoyamkung;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Gson を使ったシリアライズ・デシリアライズのテストケース。
 * 
 * @author tomoyamkung
 *
 */
public class GsonTest {

	/**
	 * デシリアライズのテスト。
	 * 
	 * @throws Exception
	 */
	@Test
	public void デシリアライズ() throws Exception {
		// Setup
		StringBuilder expected = new StringBuilder();
		expected.append("{");
		expected.append("  \"result\"").append(":").append("\"OK\"").append(",");
		expected.append("  \"targets\"").append(":").append("[");
		expected.append("    {");
		expected.append("      \"id\"").append(":").append("\"123\"").append(",");
		expected.append("      \"user_name\"").append(":").append("\"友だち１\"").append(",");
		expected.append("      \"user_number\"").append(":").append("\"ABC\"");
		expected.append("    }").append(",");
		expected.append("    {");
		expected.append("      \"id\"").append(":").append("\"456\"").append(",");
		expected.append("      \"user_name\"").append(":").append("\"友だち２\"").append(",");
		expected.append("      \"user_number\"").append(":").append("\"DEF\"");
		expected.append("    }").append(",");
		expected.append("    {");
		expected.append("      \"id\"").append(":").append("\"789\"").append(",");
		expected.append("      \"user_name\"").append(":").append("\"友だち３\"").append(",");
		expected.append("      \"user_number\"").append(":").append("\"GHI\"");
		expected.append("    }");
		expected.append("  ]");
		expected.append("}");
		
		// Exercise
		JsonFriend actual = JsonFriend.fromJson(expected.toString());
		
		// Verify
		assertThat("デシリアライズされていること", actual, is(not(nullValue())));
		assertThat("「友だち」は3件取得できること", actual.friends.size(), is(3));
		
		Friend friend = actual.friends.get(0);
		assertThat("1人目の「友だち」の ID は 123 であること", friend.id, is("123"));
		assertThat("1人目の「友だち」の 名前 は 友だち１ であること", friend.name, is("友だち１"));
		assertThat("1人目の「友だち」の 管理番号 は ABC であること", friend.number, is("ABC"));
		
		friend = actual.friends.get(1);
		assertThat("2人目の「友だち」の ID は 456 であること", friend.id, is("456"));
		assertThat("2人目の「友だち」の 名前 は 友だち２ であること", friend.name, is("友だち２"));
		assertThat("2人目の「友だち」の 管理番号 は DEF であること", friend.number, is("DEF"));
		
		friend = actual.friends.get(2);
		assertThat("2人目の「友だち」の ID は 789 であること", friend.id, is("789"));
		assertThat("2人目の「友だち」の 名前 は 友だち３ であること", friend.name, is("友だち３"));
		assertThat("2人目の「友だち」の 管理番号 は GHI であること", friend.number, is("GHI"));
	}
	
	/**
	 * シリアライズのテスト。
	 * 
	 * @throws Exception
	 */
	@Test
	public void シリアライズ() throws Exception {
		// Setup
		JsonFriend jsonFriend = new JsonFriend();
		jsonFriend.add(new Friend("123", "友だち１", "ABC"));
		jsonFriend.add(new Friend("456", "友だち２", "DEF"));
		jsonFriend.add(new Friend("789", "友だち３", "GHI"));
		
		// Exercise
		String actual = jsonFriend.toJson();
		
		// Verify
		StringBuilder expected = new StringBuilder();
		expected.append("{");
		expected.append("\"targets\":[");
		expected.append("{");
		expected.append("\"id\":\"123\",\"user_name\":\"友だち１\",\"user_number\":\"ABC\"");
		expected.append("},");
		expected.append("{");
		expected.append("\"id\":\"456\",\"user_name\":\"友だち２\",\"user_number\":\"DEF\"");
		expected.append("},");
		expected.append("{");
		expected.append("\"id\":\"789\",\"user_name\":\"友だち３\",\"user_number\":\"GHI\"");
		expected.append("}");
		expected.append("]");
		expected.append("}");
		assertThat(actual, is(expected.toString()));
	}

}
