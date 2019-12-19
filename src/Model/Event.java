package Model;

public class Event {
<<<<<<< HEAD
    private String name;
    private int organizerId;
    private int ticketNumber;
    private String date;
    private String location;
    private int price;
    private String IBAN;

    public Event(String name, int organizerId, int ticketNumber, String date, String location, int price, String IBAN) {
        this.name = name;
        this.organizerId = organizerId;
        this.ticketNumber = ticketNumber;
        this.date = date;
        this.location = location;
        this.price = price;
        this.IBAN = IBAN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(int organizerId) {
        this.organizerId = organizerId;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String iBAN) {
        IBAN = iBAN;
    }
=======
	private String name;
	private int organizerId;
	private int ticketNumber;
	private int date;
	private String location;
	private int price;
	private int IBAN;

	public Event(String name, int organizerId, int ticketNumber, int date, String location, int price, int IBAN) {
		this.name = name;
		this.organizerId = organizerId;
		this.ticketNumber = ticketNumber;
		this.date = date;
		this.location = location;
		this.price = price;
		this.IBAN = IBAN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrganizerId() {
		return organizerId;
	}

	public void setOrganizerId(int organizerId) {
		this.organizerId = organizerId;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getIBAN() {
		return IBAN;
	}

	public void setIBAN(int iBAN) {
		IBAN = iBAN;
	}
>>>>>>> 3e0dbe078127b415a413f642058ec6423f06bc10
}
