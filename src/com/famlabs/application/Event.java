/*
 * Copyright (c) 2015 Famlabs.com. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * 
 * This code is free software. You can redistribute it and/or modify it
 * under the terms of the GNU General Public License, as published by the
 * Free Software Foundation.
 * 
 * FAMLABS MAKES NO REPRESENTATIONS OR WARRANTIES ANOUT THE SUITABILITY
 * OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BU NOT LIMITED TO
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE,
 * OR NON-INFRINGEMENT. FAMLABS WILL NOT BE LIABLE FOA NAY DAMAGES SUFFERED
 * BY A LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE.
 */

package com.famlabs.application;

import java.util.Calendar;

/**
 * This Event class represents events.
 * 
 * <p>
 * The methods of this class provide control over class instances.
 * </p>
 * 
 * @author Famlabs
 * @version 0.1
 */

public class Event {

	/**
	 * Class fields allow user to set up event's:
	 * <ul>
	 * <li>Guest number
	 * <li>Date
	 * <li>Organizer
	 * <li>Host
	 * <li>Country
	 * <li>City
	 * </ul>
	 * All fields must be private.
	 */

	private int eventGuestsNumber;
	private Calendar eventDate;
	private String eventName;
	private String eventOrganizer;
	private String eventHost;
	private String eventCountry;
	private String eventCity;

	/**
	 * No parameter constructor for the class.
	 */

	public Event() {

	}

	/**
	 * This constructor initializes all class instance fields with user defined
	 * values.
	 */

	public Event(int number, Calendar date, String name, String organizer,
			String host, String country, String city) {
		
		eventGuestsNumber = number;
		eventDate = date;
		eventName = name;
		eventOrganizer = organizer;
		eventHost = host;
		eventCountry = country;
		eventCity = city;

	}
	
	
	/**
	 * This constructor initializes name and organizer of the event with user defined
	 * values. Other parameters are set to predefined values.
	 */

	public Event(String name, String organizer){
		
		eventName = name;
		eventOrganizer = organizer;
		
		//predefined data
		eventGuestsNumber = 100;
		eventDate = Calendar.getInstance();		
		eventHost = "Hilton";
		eventCountry = "UK";
		eventCity = "London";

	}
	
	//Getter and setter methods below
	
	public int getEventGuestsNumber(){
		return eventGuestsNumber;
	}
	
	public void setEventGuestsNumber(int eventGuestsNumber){
		this.eventGuestsNumber = eventGuestsNumber;
	}
	
	public String getEventOrganizer(){
		return eventOrganizer;
	}
	
	public void setEventOganizer(String eventOrganizer){
		this.eventOrganizer = eventOrganizer;
	}
	
	public Calendar getEventDate(){
		return eventDate;
	}
	
	public void setEventDate(Calendar eventDate){
		this.eventDate = eventDate;
	}
	
	
	public String getEventName(){
		return eventName;
	}
	
	public void setEventName(String eventName){
		this.eventName = eventName;
	}
	
	public String getEventHost(){
		return eventHost;
	}
	
	public void setEventHost(String eventHost){
		this.eventHost = eventHost;
	}
	
	public String getEventCountry(){
		return eventCountry;
	}
	
	public void setEventCountry(String eventCountry){
		this.eventCountry = eventCountry;
	}
	
	public String getEventCity(){
		return eventCity;
	}
	
	public void setEventCity(String eventCity){
		this.eventCity = eventCity;
	}
	
}
