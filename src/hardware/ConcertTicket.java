package hardware;
import hardware.PurchasedTicket;
import hardware.ReservedTicket;

public abstract class ConcertTicket extends Concert{
	private double price;
	private int seat;
	private PurchasedTicket purchased; //Still confused on if we should include available tickets
	private ReservedTicket reserved;
	
	//Constructors
	public ConcertTicket() {
		this.price = -1.0;
		this.seat = -1;
		this.purchased = new PurchasedTicket();
		this.reserved = new ReservedTicket();
	}
	
	public ConcertTicket(double price, int seat, PurchasedTicket purchased, ReservedTicket reserved) {
		super();
		this.price = price;
		this.seat = seat;
		this.purchased = purchased;
		this.reserved = reserved;
	}

	//Getters and setters
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public PurchasedTicket getPurchased() {
		return purchased;
	}

	public void setPurchased(PurchasedTicket purchased) {
		this.purchased = purchased;
	}

	public ReservedTicket getReserved() {
		return reserved;
	}

	public void setReserved(ReservedTicket reserved) {
		this.reserved = reserved;
	}
	
	//Print functions
	public void printTicket() {
		System.out.println("Printing ticket info...");
		//System.out.println();
	}
	
	public void purchaseTicket() {
		
	}
	
	public void reserveTicket() {
		
	}
	
	public void addTicketToList(ConcertTicket ticket) {
		
	}
}
