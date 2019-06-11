package designpattern.facadePattern;

import designpattern.facadePattern.computer.Computer;


class You {

	// 用的時間點
	// 程式這個東西往往愈做愈大，許多類別彼此間的影響讓關係更加錯綜複雜。因此在使用類別時，要確實了解類別之間的關係，正確依序呼叫方法。
	// 利用大型程式進行資料處理時，必須精確控制相關的類別。既然如此，就乾脆設個處理專用的"窗口"，如此一來就不需要個別控制類別，只要把要求丟給"窗口"即可。
	//
	// 如何設計
	// Facade Pattern 能整合錯綜複雜的來龍去脈，提供較為高級的介面。Facade 參與者則是讓系統外埠看到較簡單的介面。而且 Facade
	// 參與者還會兼顧系統內部各類別功能和互動關係，以最正確的順序利用類別。

	// 優點
	// 減少介面
	// Facade 讓複雜的內容看起來很單純。躲在背後工作的那些類別間的關係和用法相當複雜，Facade 可以把這些複雜的方法組合隱藏在背後，讓 designpattern.visitorPattern 只專注在 Facade 上面。
	// 這部份的重點就在減少介面。看了太多的類別和方法，只會讓程式設計師猶豫不知道該使用哪一個才對，而且還得注意呼叫順序不能搞錯。要注意的事情愈多，就愈是容易弄錯。所以不如把精神放在介面較少的
	// Facade 上，反而比較有效率。
	//
	// Facade Pattern 的遞迴應用
	// 假設現在有數個內含 Facade 的類別集合，這時候當然可以新增一個整合所有集合的 Facade。換句話說，就是遞迴應用 Facade Pattern。
	//
	// 如果是面對大型系統有大量的類別和 package 時，在適當的位置使用 Facade Pattern 會很方便。
	//

	public static void main(String[] args) {
		// 一班外觀
		Computer computer = new Computer();
		computer.startComputer();

		// Facade Pattern 的遞迴應用
		AfterWork afterWork = new AfterWork();
		afterWork.afterWork();

	}
}