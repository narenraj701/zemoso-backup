//SRP
class Transaction{
	private String receiverId;
	void commit(){}
	void rollBack(){}
	}
class Database{
	void saveToDatabase(){}
	void deleteRecordDatabase(){}
}
//open/closed
class MusicPlayer{
	void playAlbum(){}
	}
class Movie1 extends MusicPlayer{
	void playAlbum(){
		playAlbum(Movie1);
		}

//Liskov
interface MusicPlan{
void buyMusicPlan(String PlanId);
}
class AppUser{
	private String name;
	void enquireMusicPlans(){}
	}
class user1 extends AppUser implements MusicPlan{
	private String name;
	void buyMusicPlan(String PlanId){
		buyPlan(PlanId);
		}
	}
class EnquiryPerson extends AppUser{
	private String name;
}
//interface Seggregation
interface Telugu{
	void getTeluguSongs();
	}
interface English{
	void getEnglishSongs();
}
//DIP
public interface PaymentVendor {
	void pay();
}
//High-level Module
class PaymentSystem{
	private PaymentVendor vendor;

	public PaymentSystem(PaymentVendor vendor) {
		this.vendor = vendor;
	}
	public void pay() {
		vendor.pay();
	}	
}
//Low-level Module
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

















