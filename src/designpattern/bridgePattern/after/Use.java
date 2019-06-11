package designpattern.bridgePattern.after;

import designpattern.bridgePattern.after.appearance.Loser;
import designpattern.bridgePattern.after.appearance.TRH;
import designpattern.bridgePattern.after.skill.Invisible;
import designpattern.bridgePattern.after.skill.ReadMind;
import designpattern.bridgePattern.after.skill.Volant;


public class Use {

	// 定义：在软件系统中，某些类型由于自身的逻辑，它具有两个或多个维度的变化，那么如何应对这种“多维度的变化”？
	// 如何利用面向对象的技术来使得该类型能够轻松的沿着多个方向进行变化，而又不引入额外的复杂度？这就要使用Bridge模式。
	// 而具体使用的方式，则是将抽象部分与他们的实现部分分离，使得它们都可以独立的变化。

	// 優點
	// 第一，子类的数目减少了。
	// 第二，实现部分的切换非常容易，主要表现在抽象部分和实现部分的耦合度很低，因为使用聚合取代了继承。
	// 第三，扩展的时候很简单，可以更好的容纳变化，不论是维度的增加还是每一个维度中子类的个数的增加，都会变得非常简单。

	// 按照before的方式的话，至少需要添加两个子类，要是拥有新的外貌的话，则至少需要添加四个子类，而after的话，不管是那种情况，我都只需要添加一个子类，就可以随意切换
	public static void main(String[] args) {
		Soul soul = new Doppelganger();
		soul.setAppearance(new TRH());// 设置分身外貌为高富帅
		soul.setSkills(new Invisible());// 设置隐身技能
		soul.doAllLikePeople();
		System.out.println("----------------------------");
		soul.show();
		soul.releaseSkills();
		System.out.println("----------------------------");
		// 切换技能
		soul.setSkills(new ReadMind());
		soul.releaseSkills();
		System.out.println("----------------------------");
		// 切换外貌
		soul.setAppearance(new Loser());
		soul.show();
		System.out.println("----------------------------");
		// 切换技能
		soul.setSkills(new Volant());
		soul.releaseSkills();
	}
}
