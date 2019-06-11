package bridgePattern.before;

public class Use {

	// 每次切换技能的时候，都至少需要制造两次分身，这样切换技能非常不方便。以后又领悟一个技能，又或者增加了一种外貌，那么分身的数量会急剧增加。

	public static void main(String[] args) {
		InvisibleLoser invisibleLoser = new InvisibleLoser();
		invisibleLoser.releaseSkills();
		System.out.println("------------------------------------");
		ReadMindTRH readMindTRH = new ReadMindTRH();
		readMindTRH.releaseSkills();
		System.out.println("------------------------------------");
		InvisibleTRH invisibleTRH = new InvisibleTRH();
		invisibleTRH.releaseSkills();
	}
}
