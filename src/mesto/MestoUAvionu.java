package mesto;


public class MestoUAvionu {
    private boolean slobodno = true;
    private String imePrezime = null;
    private int starost = 0;

    
    
    public boolean isSlobodno() {
        return slobodno;
    }

    public void setSlobodno(boolean slobodno) {
        this.slobodno = slobodno;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public int getStarost() {
        return starost;
    }
    
    public void setStarost(int starost) {
        this.starost = starost;
    }

    @Override
    public String toString() {
        if (slobodno) return "Slobodno";
        else return imePrezime + " " + starost;
    }
    
    
    
    
}
