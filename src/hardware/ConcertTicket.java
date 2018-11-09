package hardware;

public class ConcertTicket extends Concert{
	private double price;
	private int seat;
	//private PurchasedTicket purchased; //Still confused on if we should include available tickets
	//private ReservedTicket reserved;
	
	//Constructors
	public ConcertTicket() {
		this.price = -1.0;
		this.seat = -1;
		//this.purchased = new PurchasedTicket();
		//this.reserved = new ReservedTicket();
	}
	
	public ConcertTicket(double price, int seat) {
		super();
		this.price = price;
		this.seat = seat;
		//this.purchased = purchased;
		//this.reserved = reserved;
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
	
	//Print functions
	public void printTicket() {
		System.out.println("Printing ticket info...");
		System.out.println("");
	}
	
	public void purchaseTicket() {
		//Removes ticket from array of available tickets
	}
	
	public void reserveTicket() {
		//Removes ticket from array of available tickets, but returns if time limit passes
		int time = 1000; //random num
		while(time > 0) {
			time--;
			//Put more code here
		}
		System.out.print("Time ran out!");
	}
	
	public void addTicketToList(ConcertTicket ticket) { //still confused on this one, but I'll figure it out
		
	}
}