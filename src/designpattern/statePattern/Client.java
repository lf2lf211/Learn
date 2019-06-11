package designpattern.statePattern;

public class Client {
	// [Design Pattern] 狀態模式(State Pattern)
	// State Pattern 主要是解決控制一個物件狀態條件表達過於複雜的情況(簡化複雜的判斷邏輯)。
	// 我們常看到很多流程判斷幾乎都使用一連串 if else..或 switch 來判斷某個狀態後得到什麼結果，
	// 雖然一開始需求很少判斷條件寫起來也很少，當然 if else 自然也就沒啥問題，
	// 但需求變動在這行是不可避免的，後續只要需求有異動，
	// 大部分的開發人員會很直覺的添加if else或 switch 條件，
	// 以至於最後整個程式碼變的相當攏長也相當難維護，
	// 而 State Pattern 將每個條件分支抽取成獨立類別，
	// 每一個狀態都視成一個獨立物件(減少物件彼此依賴)，
	// 這樣往後需求有變更時，大多也不用有太大的變更，
	// 但由於把每個條件分支抽取成獨立類別，所以無法去避免類別變多的情況發生。
	public static void main(String[] args) {
		Context context = new Context();

		System.out.println("Start工作單現在狀態:" + context.GetState());
		System.out.println("Start工作單現在狀態:" + context.GetState());
		System.out.println("Start工作單現在狀態:" + context.GetState());
		System.out.println("Start工作單現在狀態:" + context.GetState());

	}

}
