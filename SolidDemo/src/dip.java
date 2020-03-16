/*High-level modules/classes should not depend on low-level modules/classes. Both should depend upon abstractions.

DIP Violating Example */

package com.demo.deckOfCards;
//High-Level Module
class PaymentSystem{
	private GooglePay googlepay;
	private PhonePay phonepe;
	public void doGooglePay(String id,int amt) {
		googlepay=new GooglePay(id, amt);
		googlepay.sendMoney();
	}
	public void doPhonePay(String id,int amt) {
		phonepe=new PhonePay(id, amt);
		phonepe.sendMoney();
	}
}
//Low-level Module 1
class GooglePay{
	private String id;
	int amt;
	public GooglePay(String id, int amt) {
		this.id = id;
		this.amt = amt;
	}
	public void sendMoney() {
		System.out.println("Money transferred using GooglePay to "+id+", "+"Amount Transferred is "+amt);
	}
	
}
//Low-level Module 2
class PhonePay{
	private String id;
	int amt;
	public PhonePay(String id, int amt) {
		this.id = id;
		this.amt = amt;
	}
	public void sendMoney() {
		System.out.println("Money transferred using PhonePe to "+id+", "+"Amount Transferred is "+amt);
	}
	
}
public class DIP {

	public static void main(String[] args) {
		PaymentSystem broker=new PaymentSystem();
		broker.doGooglePay("1234", 5000);
		broker.doPhonePay("2345", 2000);

	}

}

/*Dip resolved using an interface */

package com.demo.di;

public interface PaymentVendor {
	void pay();
}



//..................



package com.demo.di;
class GooglePay implements PaymentVendor{
	private String id;
	private int amount;
	public GooglePay(String id,int amount) {
		this.id=id;
		this.amount=amount;
	}
	public void pay() {
		System.out.println("Money transferred using GooglePay to "+id+", "+"Amount Transferred is "+amount);
	}
}
class PhonePe implements PaymentVendor{
	private String id;
	private int amount;
	public PhonePe(String id, int amount) {
		this.id = id;
		this.amount = amount;
	}
	public void pay() {
		System.out.println("Money transferred using PhonePe to "+id+", "+"Amount Transferred is "+amount);
	}
	
}	
class PaymentSystem{
	private PaymentVendor vendor;

	public PaymentSystem(PaymentVendor vendor) {
		this.vendor = vendor;
	}
	public void pay() {
		vendor.pay();
	}
	
}
public class DIPresolve {

	public static void main(String[] args) {
		PaymentSystem vendor;
		vendor=new PaymentSystem(new GooglePay("1234", 5000));
		vendor.pay();
		vendor=new PaymentSystem(new PhonePe("5678", 10000));
		vendor.pay();

	}

}

