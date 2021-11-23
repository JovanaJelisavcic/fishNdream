package com.fishNdream.backend.entity.basic;

public class Views {
	
	public interface UserInfo {}

	
	public interface UnauthoCottages {
    }
	
	public interface UnauthoBoats {
    }
	
	public interface UnauthoInstuctors extends UserInfo {
    }
	
	public interface AdditionalServices {}
	public interface ReservationView extends UnauthoBoats, UnauthoCottages, UnauthoInstuctors, AdditionalServices{}
	
	public interface ActionInfo extends  ReservationView {}
	
	
	
}
