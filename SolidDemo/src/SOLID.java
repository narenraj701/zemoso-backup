//SRP
class Transaction{
	private String receiverId;
	void commit(){}
	void rollBack(){}
	void saveToDatabase(){}
	void deleteRecordDatabase(){}
	}
//open/closed

class MusicPlayer{
	void playAlbum(String Album){
		if(Album.equals("Movie1"))
			play("Movie1");
		}
	}

//Liskov
abstract class AppUser{
	private String name;
	void enquireMusicPlans(){}
	abstract void buyMuicPlan(String PlanId);
	}
class user1 extends AppUser{
	private String name;
	void buyMusicPlan(String PlanId){
		buyPlan(PlanId);
		}
	}
class EnquiryPerson extends AppUser{
	private String name;
	void buyMusicPlan(String PlanId){}
}
//interface Seggregation
interface Songs{
	void getTeluguSongs();
	void getEnglishSongs();
	}
//DIP
//High-level Module
class PaymentSystem{
	private GooglePay googlepay;
	public void doGooglePay(String id,int amt) {
		googlepay=new GooglePay(id, amt);
		googlepay.sendMoney();
	}
}
//Low-level Module
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

















