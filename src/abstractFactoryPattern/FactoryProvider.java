package abstractFactoryPattern;

public class FactoryProvider {
    /**
     * 客戶端獨立於我們如何在系統中創建和組合對象
     * 該系統由多個對象族組成，這些族被設計為一起使用
     * 我們需要一個運行時值來構造一個特定的依賴項
     * @param choice
     * @return
     */
    public static AbstractFactory getFactory(String choice){

        if("Animal".equalsIgnoreCase(choice)){
            return new AnimalFactory();
        }
        else if("Color".equalsIgnoreCase(choice)){
            return new ColorFactory();
        }

        return null;
    }
}
