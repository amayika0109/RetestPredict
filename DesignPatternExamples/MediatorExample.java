import java.io.*;

public class MediatorExample{
 
    public static void main(String args[])  
    { 
  
        WSMediator wsMediator = new WSMediator(); 
        TMRSColleague tmrs = new TMRSColleague(wsMediator); 
        LobetoColleague lobeto = new LobetoColleague(wsMediator); 
        LotRetestColleague lotretest = new LotRetestColleague(wsMediator); 
        wsMediator.registerTMRS(tmrs); 
        wsMediator.registerLobeto(lobeto); 
        wsMediator.registerLotRetest(lotretest);
        //tmrs.getReady(); 
        //lobeto.readyColleagues(); 
        //tmrs.readyColleagues(); 
        lobeto.getReady(); 
        lotretest.readyColleagues(); 
        lobeto.readyColleagues(); 
    } 

}

interface  IMediator{
    public void registerTMRS(TMRSColleague tmrs);
    public void registerLobeto(LobetoColleague lobeto);
    public void registerLotRetest(LotRetestColleague lotretest);
    public boolean isOk(); 
    public void setStatus(boolean status);
}

class WSMediator implements IMediator{
    private TMRSColleague tmrs1;
    private LobetoColleague lobeto1;
    private LotRetestColleague lotretest1;
    public boolean ready;
    
    public void registerTMRS(TMRSColleague tmrs)
    {
        this.tmrs1 = tmrs;
    }
    
    
    public void registerLobeto(LobetoColleague lobeto)
    {
        this.lobeto1 = lobeto;
    }
    
    public void registerLotRetest(LotRetestColleague lotretest)
    {
        this.lotretest1 = lotretest;
    }
    
    public boolean isOk()
    {
        return ready;
    }
    
    public void setStatus(boolean status)
    {
        ready = status;
    }
    
}

interface Colleague{
    void readyColleagues();
}

class TMRSColleague implements Colleague{
    private WSMediator mediator1;
    
    public TMRSColleague(WSMediator mediator){
        this.mediator1 = mediator;
        
    }
    public void readyColleagues(){
        System.out.println("TMRS is ready to start"); 
    }
    
    public void getReady(){
        System.out.println("TMTRS is Ready."); 
    }

}

class LobetoColleague implements Colleague{
    private WSMediator mediator1;   
    
    public LobetoColleague(WSMediator mediator){
        this.mediator1 = mediator;
        mediator1.setStatus(true);
        
    }
    public void readyColleagues(){
        System.out.println("Lobeto is ready to start and receive"); 
        mediator1.setStatus(true); 
    }
    
    public void getReady(){
        System.out.println("Lobeto is Ready to trigger."); 
    }

}

class LotRetestColleague implements Colleague{
    private WSMediator mediator1;   
    
    public LotRetestColleague(WSMediator mediator){
        this.mediator1 = mediator;
        mediator1.setStatus(true);
        
    }
    public void readyColleagues(){
        System.out.println("LotRetest is ready to receive"); 
        mediator1.setStatus(true); 
    }
    

}

