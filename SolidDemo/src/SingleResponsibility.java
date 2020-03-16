//Single Responsibility Principle- every class should have a single responsibility or single job or single purpose
//violation
public class Developer {
    void developCode(){
    
	}
    void testCode(){

    }
    void deployCode(){

    }
}

//resolved

class Developer{
	private Tester tester=new Tester();
	private Deploy deploy=new Deploy();    
	void DevelopCode(){
		//.........
		tester.test();
		deploy.deployCode();
    		}    
	}
class Tester{
    void testCode(){

    }
}
class Deploy{
    void deployCode(){

    }

