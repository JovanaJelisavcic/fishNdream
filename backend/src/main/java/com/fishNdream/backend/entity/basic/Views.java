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
	
	public interface AdventureInfo{}
	
	public interface BoatProfile extends UnauthoBoats, UserInfo{}
	public interface CottageProfile extends UnauthoCottages, UserInfo{}
	public interface InstructorProfile extends UnauthoInstuctors, AdventureInfo{}
	
	public interface Complaint extends UnauthoCottages, UserInfo, UnauthoBoats, UnauthoInstuctors {}
	
	public interface DeleteRq extends UserInfo{}
	
	public interface CottageOwner extends UserInfo, UnauthoCottages{}
	public interface BoatOwner extends UserInfo, UnauthoBoats{}

	
	
	
	
	
}
