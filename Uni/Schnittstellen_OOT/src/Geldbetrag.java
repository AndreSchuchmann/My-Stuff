


public class Geldbetrag implements Comparable {
  public int euros;
  public int cents;
  
  public Geldbetrag(int euros, int cents) {
	  this.euros = euros;
	  this.cents = cents;
  }
  
	public boolean greaterThan(Object o) {
		if (o instanceof Geldbetrag) {
			Geldbetrag oGeldbetrag = (Geldbetrag)o;
			return this.euros>oGeldbetrag.euros || 
					(this.euros==oGeldbetrag.euros && this.cents>oGeldbetrag.cents);
		} else {
			return false;
		}
	}
	
	public boolean equals(Object o) {
		if (o instanceof Geldbetrag) {
			Geldbetrag oGeldbetrag = (Geldbetrag)o;
			return 
					(this.euros==oGeldbetrag.euros && this.cents==oGeldbetrag.cents);
		} else {
			return false;
		}
	}
	
	public String toString() {
		return euros + "," + cents;
	}
}
