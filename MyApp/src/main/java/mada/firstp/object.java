package mada.firstp;

import java.util.Date;

public class object{
    String minute = Integer.toString(new Date().getMinutes());
    String heure = Integer.toString(new Date().getHours());

    public String getMinute(){
        return this.minute;
    }

    public String getHeure(){
        return this.heure;
    }
    public void setMinute(String x){
        this.minute = x;
    }

    public void setHeure(String x){
        this.heure = x;
    }
}

    
    