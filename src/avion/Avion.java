package avion;

import exception.AvionException;
import mesto.MestoUAvionu;


public class Avion {
    private MestoUAvionu mesta[];
  
    public Avion() {
        mesta = new MestoUAvionu[120];
        for (int i = 0; i < mesta.length; i++) {
            mesta[i] = new MestoUAvionu();
        }
    }
    
    public void uvediPutnika(int brMesta, String imePrezime, int godine){
        if (brMesta > 119 || brMesta < 0) throw new AvionException("Izabrano mesto ne postoji!");
        if (!mesta[brMesta].isSlobodno()) throw new AvionException("Mesto je vec zauzeto");
        
        mesta[brMesta].setSlobodno(false);
        mesta[brMesta].setImePrezime(imePrezime);
        mesta[brMesta].setStarost(godine);
        
    } 
    
        public void izvediPutnika(int brMesta){
        if (brMesta > 119 || brMesta < 0) throw new AvionException("Izabrano mesto ne postoji!");
        if (mesta[brMesta].isSlobodno()) throw new AvionException("Mesto je vec slobodno");
        
        mesta[brMesta].setSlobodno(true);
        mesta[brMesta].setImePrezime("");
        mesta[brMesta].setStarost(0);
        
    }
        public boolean daLiJeUAvionu(String ime, int godine){
            for (MestoUAvionu mesto : mesta) {
                if (!mesto.isSlobodno() && mesto.getImePrezime().equals(ime) && mesto.getStarost() == godine)
                    return true;
            }
            return false;
        }
        public String zauzuetost(){
            int brojac = 0;
            for (MestoUAvionu mesto : mesta) {
                if (!mesto.isSlobodno())
                    brojac++; // ovde racunamo broj ZAUZETIH mesta u avionu
            }
            return ((double)brojac/120 * 100) + "%";
            
        }
        public boolean daLiImaSlobodnihMesta (){
        for (MestoUAvionu mesto : mesta) {
                if (mesto.isSlobodno())
                    return true;
            }
        return false;
        }
    public int prosecnaStarostPutnika (){
        int brojac = 0;
        int godineUkupno = 0;
             for (MestoUAvionu mesto : mesta) {
                if (!mesto.isSlobodno()){
                    brojac++; // ovde racunamo broj ZAUZETIH mesta u avionu
                    godineUkupno+=mesto.getStarost();
                }
            }
             return (int) Math.round((double)godineUkupno/brojac);
    }
    public int najstarijiPutnik (){
        int max = 0;
        
             for (MestoUAvionu mesto : mesta) {
                if (!mesto.isSlobodno() && mesto.getStarost() > max){
                    max = mesto.getStarost();
                }
            }
             return max;
    }
    public int najmladjiPutnik (){
        int min = Integer.MAX_VALUE;
        
             for (MestoUAvionu mesto : mesta) {
                if (!mesto.isSlobodno() && mesto.getStarost() < min){
                    min = mesto.getStarost();
                }
            }
             return min;
    }
    public String svakoMesto (){
        String ceo = "";
        int br = 0;
             for (MestoUAvionu mesto : mesta) {
                 ceo += br + ": " + mesto.toString() + "\n";
                 br++;
            }
             return ceo;
    }
    public String jovanovici(){
        String ceo = "";
        for (MestoUAvionu mesto : mesta) {
            if(!mesto.isSlobodno() && mesto.getImePrezime().split(" ")[1].equals("Jovanovic"))
                    ceo += mesto.toString() + "\n";
                }
        return ceo;
    }
}
