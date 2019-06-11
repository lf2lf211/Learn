package designpattern.interpreter.T1;

public abstract class Expression {
	public void Interpret(Context context) {

		if (context.getText().length() > 0) {
			// 取得前面第一個分隔字串
			int spacePos = context.getText().indexOf(" ");
			String word = "";
			if (-1 != spacePos) {
				word = context.getText().substring(0, spacePos);
				// 將剩下的字串重新設定到未解譯的資料
				context.setText(context.getText().substring(spacePos + 1));

			} else {
				// 最後一個字串
				word = context.getText();
				context.setText("");
			}

			// 單字解譯
			int num = (Integer.parseInt(word.substring(1)) + 9) % 12;
			if (0 == num) {
				num = 12;
			}
			Excute(num);
		}
	}

	public abstract void Excute(int num);
}