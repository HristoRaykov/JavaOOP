package P10AndP11Tuple;

public class Threeuple<E1,E2,E3> extends Tuple<E1,E2> {
	
	private E3 item3;
	
	public Threeuple(E1 item1, E2 item2, E3 item3) {
		super(item1, item2);
		this.item3 = item3;
	}
	
	public E3 getItem3() {
		return item3;
	}
	
	public void setItem3(E3 item3) {
		this.item3 = item3;
	}
	
	@Override
	public String toString() {
		return String.format("%s -> %s -> %s",super.getItem1(),super.getItem2(),this.getItem3());
	}
}
