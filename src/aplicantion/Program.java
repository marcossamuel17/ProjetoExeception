package aplicantion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		
		try {
		
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			System.out.print("Número do quarto: ");
			int number = sc.nextInt();
			System.out.print("Data de entrada: (dd/MM/yyy)");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data de saida: (dd/MM/yyy)");;
			Date checkOut = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.print("Update de data: ");
			System.out.print("Data de entrada: (dd/MM/yyy)");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de saida: (dd/MM/yyy)");;
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservado: " + reservation);
		
		}
		catch(ParseException e) {
			System.out.println("Data invalida");
		}
		catch(IllegalArgumentException e) {
			System.out.println("Erro na reserva: " + e + e.getMessage());
		}

	}

}
