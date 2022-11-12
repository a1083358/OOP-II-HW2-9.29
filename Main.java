//買票系統，有4台機器，隨機買1-4張票
import java.security.SecureRandom;

class device implements Runnable{
  Thread ticket;
  static int total=10000;
  int num=0;//注意：一定要用 inner variable，不可以用static，否則機器1234可以取得對方的數字，num是每台機器都有屬於自己的變數
  int all_ticket=0;//all_ticket是每台機器都有屬於自己的變數
  public device(String name){//name為名字
    ticket=new Thread(this,name);
    ticket.start();
  }
  public void run(){
    SecureRandom randomNumbers=new SecureRandom();
    num=randomNumbers.nextInt(4)+1;
    while(totalnumber(ticket.getName(),num)==true){
      all_ticket+=num;
      System.out.println(ticket.getName()+"賣出："+num+"張票");
      num=randomNumbers.nextInt(4)+1;
    }
    System.out.println(ticket.getName()+"總共賣出："+all_ticket+"張票");
  }
  private synchronized static boolean totalnumber(String name,int num){//確定有票可以買
    if(total>0){
      if((total-num)<0){//注意:要先確認賣完票是否變負數的票
        return false;
      }else{//注意：應用if-else去寫，否則很可能即使return false了，但不知道為甚麼仍然會執行到return true，所以還是多一層保險比較好
        total-=num;
        return true;
      }
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
