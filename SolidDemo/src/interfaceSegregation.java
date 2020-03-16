// do not force clients to implement all functionalities or irrelevant functionalities

interface Mobiles{
	void getTouchPhones();
	void getKeypadPhones();
	void getTouchAndKeypadPhones();
	}


//resolve by creating many interfaces


interface TouchPhones{
	void getTouchPhones();
	}

interface KeypadPhones{
	void getKeypadPhones();
	}
interface TouchAndKeyPadPhones{
	void getTouchAndKeyPadPhones();
	}



//if client needs both touch and keypad

class client1 implements TouchPhones,KeypadPhones{
	void getTouchPhones(){};
	void getKeypadPhones(){};
}
