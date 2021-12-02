package com.fishNdream.backend.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fishNdream.backend.entity.helper.ActionType;
import com.fishNdream.backend.entity.helper.RevenueItem;
import com.fishNdream.backend.entity.intercations.ReservationAdventure;
import com.fishNdream.backend.entity.intercations.ReservationBoat;
import com.fishNdream.backend.entity.intercations.ReservationCottage;
import com.fishNdream.backend.repository.ReservationAdventureRepository;
import com.fishNdream.backend.repository.ReservationBoatRepository;
import com.fishNdream.backend.repository.ReservationCottageRepository;

@Component
public class RevenueUtil {
	
	@Autowired
	ReservationCottageRepository ctgResRepo;
	@Autowired
	ReservationBoatRepository btResRepo;
	@Autowired
	ReservationAdventureRepository AdResRepo;


	public List<RevenueItem> getNewReservationsRevenue() {
		List<RevenueItem> result = new ArrayList<>();
		List<ReservationBoat> unBoats = btResRepo.findUnrevenued();
		List<ReservationAdventure> unAdv = AdResRepo.findUnrevenued();
		List<ReservationCottage> unCtg= ctgResRepo.findUnrevenued();

		for(ReservationAdventure r: unAdv) {
			RevenueItem i = new RevenueItem();
			i.setFishermanPrice(r.getPrice());
			i.setPercentageActive(r.getPercentageRevenue());
			i.setReservationId(r.getReservationId());
			i.setResType(ActionType.ADVENTURE);
			i.setRevenue((r.getPrice()*r.getPercentageRevenue())/100);
			result.add(i);
		}
		for(ReservationBoat r: unBoats) {
			RevenueItem i = new RevenueItem();
			i.setFishermanPrice(r.getPrice());
			i.setPercentageActive(r.getPercentageRevenue());
			i.setReservationId(r.getReservationId());
			i.setResType(ActionType.BOAT);
			i.setRevenue((r.getPrice()*r.getPercentageRevenue())/100);
			result.add(i);
		}
		for(ReservationCottage r: unCtg) {
			RevenueItem i = new RevenueItem();
			i.setFishermanPrice(r.getPrice());
			i.setPercentageActive(r.getPercentageRevenue());
			i.setReservationId(r.getReservationId());
			i.setResType(ActionType.COTTAGE);
			i.setRevenue((r.getPrice()*r.getPercentageRevenue())/100);
			result.add(i);
		}
		return result;
	}

}
