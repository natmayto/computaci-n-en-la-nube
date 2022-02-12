
public class kronos {

	 public static void main(String[] args) {

	        int segundos= 100;

	        for (int i = 0; i < segundos; i++) {
	            System.out.println(i+1);
	            delaySegundos();
	        }


	    }


	    public static void delaySegundos() {
	        try{
	            Thread.sleep(1000);
	        }catch(InterruptedException e){

	        }
	    }
	
}
