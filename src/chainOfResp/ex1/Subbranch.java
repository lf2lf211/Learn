package chainOfResp.ex1;

//分店接口（相当于Hanlder）
public interface Subbranch {

	void setSuccessor(Subbranch subbranch);

	boolean handleOrder(Order order);

}