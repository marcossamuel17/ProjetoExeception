package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private int number;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}
	
	public Reservation(int number, Date checkIn, Date checkOut) {
		super();
		this.number = number;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getChecIn() {
		return checkIn;
	}

	public Date getChecOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			throw new IllegalArgumentException("Erro nas datas!");
		}
		if(checkOut.after(checkIn)) {
			throw new IllegalArgumentException("Erro nas datas!");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Quarto" +
				number +
				", Entrada: " +
				sdf.format(checkIn) +
				", Saída: " +
				sdf.format(checkOut)+
				", " + 
				duration()+
				" noites.";
	}
	

}
