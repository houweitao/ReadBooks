package headFirstDesign.singleton;

/**
 * @author houweitao
 * @date 2016年3月8日下午9:22:51
 */

public class GirlFriendSingleton {
	private static GrilFriend gf;

	public static GrilFriend getInstance() {
		if (gf == null) {
			gf = new GrilFriend();
		}
		return new GrilFriend();
	}
}
