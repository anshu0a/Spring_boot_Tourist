package com.an.svs;

import java.util.List;

import com.an.exceptions.MissingDataException;
import com.an.exceptions.TouristNotFoundException;
import com.an.vo.Vo_Tourist;

public interface ITourtstService {
	
	//public List<Vo_Tourist> getAllTourist();
	public List<Vo_Tourist> getAllTouristByFilter(Vo_Tourist vo);
	public String registerTourist(Vo_Tourist vo) throws MissingDataException;
	public Vo_Tourist getTouristById(Long id) throws TouristNotFoundException;
	public String deleteTourist(Long id)  throws TouristNotFoundException ;
	public String updateTouristById(Long id, Vo_Tourist vo) throws TouristNotFoundException;

}
