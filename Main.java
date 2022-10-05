import java.security.SecureRandom;

class device implements Runnable{
  Thread ticket;
  static int total=10000;
  static int num=0;
  int all_ticket=0;
  public device(String name){
    ticket=new Thread(this,name);
    ticket.start();
  }
  public void run(){
    while(totalnumber()==true){
      all_ticket+=num;
      System.out.println(ticket.getName()+"賣出："+num+"張票");
    }
    System.out.println(ticket.getName()+"總共賣出："+all_ticket+"張票");
  }
  synchronized static boolean totalnumber(){
    SecureRandom randomNumbers=new SecureRandom();
    if(total>0){
      num=randomNumbers.nextInt(4)+1;
      total-=num;
      return true;
    }else{
      return false;
    }
  }
}

class Main {
  public static void main(String[] args) {
    device ta=new device("售票機1");
    device tb=new device("售票機2");
    device tc=new device("售票機3");
    device td=new device("售票機4");
  }
}