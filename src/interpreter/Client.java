package interpreter;

import interpreter.T1.Context;
import interpreter.T1.Expression;
import interpreter.T1.ExpressionA;
import interpreter.T1.ExpressionB;
import interpreter.T2.Add;
import interpreter.T2.Constant;
import interpreter.T2.Context2;
import interpreter.T2.Div;
import interpreter.T2.Expression2;
import interpreter.T2.Mul;
import interpreter.T2.Sub;
import interpreter.T2.Variable;
//https://www.itread01.com/articles/1475891485.html
//Interpreter的中文也被稱為翻譯者模式或解釋器模式。

//優點
//易于改变和扩展文法。每一条文法规则都可以表示为一个类，因此可以方便地实现一个简单的语言。
//实现文法较为容易。在抽象语法树中每一个表达式节点类的实现方式都是相似的，这些类的代码编写都不会特别复杂，还可以通过一些工具自动生成节点类代码。

//缺點
//解释器模式在实际的系统开发中使用的很少，因为他会引起效率、性能以及维护等问题。
//对于复杂文法难以维护。在解释器模式中，每一条规则至少需要定义一个类，因此如果一个语言包含太多文法规则，类的个数将会急剧增加，导致系统难以管理和维护，此时可以考虑使用语法分析程序等方式来取代解释器模式。
//执行效率较低。由于在解释器模式中使用了大量的循环和递归调用，因此在解释较为复杂的句子时其速度很慢，而且代码的调试过程也比较麻烦

//抽象解释器：Expression.java 声明一个所有具体表达式都要实现的抽象接口（或者抽象类），接口中主要是一个interpret()方法，称为解释操作。
//具体解释任务由它的各个实现类来完成，具体的解释器分别由终结符解释器TerminalExpression和非终结符解释器NonterminalExpression完成。

//终结符表达式：实现与文法中的元素相关联的解释操作，通常一个解释器模式中只有一个终结符表达式，但有多个实例，对应不同的终结符。终结符一班是文法中的运算单元，
//比如有一个简单的公式R=R1+R2，在里面R1和R2就是终结符，对应的解析R1和R2的解释器就是终结符表达式。

//非终结符表达式（相当于树的树杈）：文法中的每条规则对应于一个非终结符表达式，非终结符表达式一般是文法中的运算符或者其他关键字，比如公式R=R1+R2中，+就是非终结符，
//解析+的解释器就是一个非终结符表达式。非终结符表达式根据逻辑的复杂程度而增加，原则上每个文法规则都对应一个非终结符表达式。

//环境角色：Context.java这个角色的任务一般是用来存放文法中各个终结符所对应的具体值，比如R=R1+R2，我们给R1赋值100，给R2赋值200。这些信息需要存放到环境角色中，很多情况下我们使用Map来充当环境角色就足够了。


public class Client {
	public static void main(String[] args) {

		// t1();
		t2();
	}

	public static void t1() {

		// (a*b)/(a-b+15000)
		Context2 context = new Context2();
		Variable a = new Variable();
		Variable b = new Variable();
		Constant c = new Constant(15000);// 终结符表达式(Terminal Expression)

		context.addValue(a, 14);
		context.addValue(b, 10000);

		Expression2 expression = new Div(new Mul(a, b), new Add(new Sub(a, b), c));
		System.out.println("Result = " + expression.interpret(context));
	}

	public static void t2() {
		Context context = new Context();
		context.setText("b2002 a2002 b2013 a2013");

		// 解譯器
		Expression expression = null;

		while (context.getText().length() > 0) {
			switch (context.getText().substring(0, 1)) {
				case "a":
					expression = new ExpressionA(); // 生肖
					break;
				case "b":
					expression = new ExpressionB(); // 地支
					break;
			}

			expression.Interpret(context);
		}
	}
}
