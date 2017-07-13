package com.hotelsoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.opentravel.ota.HotelReservationsType.HotelReservation;
import org.opentravel.ota.OTAHotelResNotifRQ;

public class OTAProcessor implements Processor {
	 public void process(Exchange exchange) throws Exception {
		 	OTAHotelResNotifRQ payload = (OTAHotelResNotifRQ) exchange.getIn().getBody();
	        // do something with the payload and/or exchange here
	       //exchange.getIn().setBody("Changed body");
		    Connection c = null;
		    Statement stmt = null;
		      try {
		         Class.forName("org.apache.ignite.IgniteJdbcDriver");
		         c = DriverManager.getConnection("jdbc:ignite://hotelsoft-ovh7.hotelsoft.com:31450");
		         
		         //Connection conn = DriverManager.getConnection("jdbc:ignite:cfg://streaming=true@file:///etc/config/ignite-jdbc.xml");
		         
		         System.out.println("Opened database successfully");
		         /*stmt = c.createStatement();
		         
		         if(payload != null && payload.getHotelReservations() != null && payload.getHotelReservations().getHotelReservation() != null) {
		        	 List<HotelReservation> reservations = payload.getHotelReservations().getHotelReservation();
		        	 String reservationSql = "Insert into integration.reservations "+
		        	 "(property, snapshotdt, reservationid, confnum, creationdt, status, arrivaldt, departuredt, stayrange, "
		        	 + "adults, children, nights, ratecode, roomnum, roomtype, quantity, reservationtype, marketcd, marketname, "
		        	 + "sourcecd, sourcename, companyid, companyname, agentid, agentname, blockid, blockname, guestid, prefix, "
		        	 + "lastname, firstname, email, address, phone1, phone2, rates, notes, externalid) "
		        	 + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		        	 for(HotelReservation reservation: reservations) {
		        		 
		        	 }
		        	 
		         }
		         
		         
		         
		         
		         ResultSet rs = stmt.executeQuery( "SELECT * FROM integration.reservations limit 10;" );
		         while ( rs.next() ) {
		        	 System.out.println(rs);
		         }
		         rs.close();
		         stmt.close();
		         c.close();*/
		         
		      } catch (Exception e) {
		         e.printStackTrace();
		         System.err.println(e.getClass().getName()+": "+e.getMessage());
		         System.exit(0);
		      }
	        System.out.println("payload-------------->"+ payload.getHotelReservations().getHotelReservation().size());
	}
}
