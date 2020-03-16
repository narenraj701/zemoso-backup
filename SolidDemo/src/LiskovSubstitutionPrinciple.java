//Derived or child classes must be substitutable for their base or parent classes“.
// This principle ensures that any class that is the child of a parent class should be
// usable in place of its parent without any unexpected behavior.
//violation
abstract class CiscoMember{
    String name;
    String memberType;
    public abstract addToDatabase();
    public abstract confirmBooking();
}
class LifeTimeMember extends CiscoMember{
    void addToDatabase(){
        System.out.println("Added to database");
    }
    void confirmBooking(){
        System.out.println("Booking Confirmed");
    }
}
class AnnualMember extends CiscoMember{
    void addToDatabase(){
        System.out.println("Added to database");
    }
    void confirmBooking(){
        System.out.println("Booking Confirmed");
    }
}
class Enquiry extends CiscoMember{
    void addToDatabase(){
        System.out.println("Added to database");
    }
    void confirmBooking(){
    }
}

//resolved using interfaces


interface Book{
    void confirmBooking();
}

class CiscoMember{
    String name;
    String memberType;
    public CiscoMember(String name,String memberType){
        this.name=name;
        this.memberType=memberType;
    }
    public abstract void addToDatabase();
}

class LifeTimeMember extends CiscoMember implements Book{
    void addToDatabase(){
        System.out.println("Added to database");
    }
    void confirmBooking(){
        System.out.println("Booking Confirmed");
    }
}
class AnnualMember extends CiscoMember implements Book{
    void addToDatabase(){
        System.out.println("Added to database");
    }
    void confirmBooking(){
        System.out.println("Booking Confirmed");
    }
}
class Enquiry extends CiscoMember{
    void addToDatabase(){
        System.out.println("Added to database");
    }
}












