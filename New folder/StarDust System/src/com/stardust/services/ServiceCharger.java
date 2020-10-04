package com.stardust.services;

public class ServiceCharger {
	
	
	//Calculate the Amount for the Service
	public int calculateAmount(String serviceType, String vehicleType)
	{		
		if(serviceType.equals("Wash"))
		{
			if(vehicleType.equals("Car") || vehicleType.equals("Van"))
			{
				return 150;
			}
			
			else if(vehicleType.equals("Bus") || vehicleType.equals("Lorry"))
			{
				return 200;
			}
			
			else
			{
				return 100;
			}
		}
		
		else if(serviceType.equals("Basic"))
		{
			if(vehicleType.equals("Car") || vehicleType.equals("Van"))
			{
				return 1000;
			}
			
			else if(vehicleType.equals("Bus") || vehicleType.equals("Lorry"))
			{
				return 2000;
			}
			
			else
			{
				return 500;
			}
		}
		
		else if(serviceType.equals("Full"))
		{
			if(vehicleType.equals("Car") || vehicleType.equals("Van"))
			{
				return 2000;
			}
			
			else if(vehicleType.equals("Bus") || vehicleType.equals("Lorry"))
			{
				return 4000;
			}
			
			else
			{
				return 1000;
			}
		}
		
		else if(serviceType.equals("Regular Repair"))
		{
			if(vehicleType.equals("Car") || vehicleType.equals("Van"))
			{
				return 1000;
			}
			
			else if(vehicleType.equals("Bus") || vehicleType.equals("Lorry"))
			{
				return 2000;
			}
			
			else
			{
				return 750;
			}
		}
		
		else if(serviceType.equals("Mobile Repair"))
		{
			if(vehicleType.equals("Car") || vehicleType.equals("Van"))
			{
				return 1500;
			}
			
			else if(vehicleType.equals("Bus") || vehicleType.equals("Lorry"))
			{
				return 2500;
			}
			
			else
			{
				return 1250;
			}
		}
		
		return 0;
	}

}
