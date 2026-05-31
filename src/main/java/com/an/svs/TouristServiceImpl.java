package com.an.svs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.an.entity.Tourist;
import com.an.exceptions.MissingDataException;
import com.an.exceptions.TouristNotFoundException;
import com.an.repo.ITouristRepository;
import com.an.vo.Vo_Tourist;

@Component
public class TouristServiceImpl implements ITourtstService {

	@Autowired
	private ITouristRepository repo;

//	@Override   //------------------------------------------------------------get all tourist
//	public List<Vo_Tourist> getAllTourist() {
//		List<Tourist> list = repo.findAll();
//		return convert(list);
//	}
	
	@Override //--------------------------------------------------------------- address filter
	public List<Vo_Tourist> getAllTouristByFilter(Vo_Tourist vo) {
		Tourist tourist = new Tourist();
		
		if (vo.getName() != null) tourist.setName(vo.getName());
		if (vo.getAddr() != null) tourist.setAddr(vo.getAddr());
		if (vo.getFromLoc() != null) tourist.setFromLoc(vo.getFromLoc());
		if (vo.getToLoc() != null) tourist.setToLoc(vo.getToLoc());
		
		Example<Tourist> exp = Example.of(tourist);
		List<Tourist> list = repo.findAll(exp);
		
		return convert(list);
	}
	
	@Override //------------------------------------------------------------------register
	public String registerTourist(Vo_Tourist vo) throws MissingDataException {
		
		if (vo.getAddr() == null) throw new MissingDataException("Adderss is missing.");
		else if (vo.getName() == null) throw new MissingDataException("Name is missing.");
		else if (vo.getToLoc() == null) throw new MissingDataException("Destination location is missing.");
		else if (vo.getFromLoc() == null) throw new MissingDataException("Source location is missing.");
		else if (vo.getBudget() == null) throw new MissingDataException("Budget is missing.");

		Tourist t = new Tourist();t.setCreatedBy(System.getProperty("user.name"));BeanUtils.copyProperties(vo,t);
		Tourist tr = repo.save(t);return"Tourist registerd with id: "+tr.getId()+" successfuly.";
	}

	@Override //-------------------------------------------------------------------get one by id
	public Vo_Tourist getTouristById(Long id) throws TouristNotFoundException {
		Tourist tour = repo.findById(id)
				.orElseThrow(() -> new TouristNotFoundException("Tourist with id " + id + ", not found."));
		Vo_Tourist vo = new Vo_Tourist();
		BeanUtils.copyProperties(tour, vo);
		return vo;
	}

	
	@Override //---------------------------------------------------------------delete one tourist
	public String deleteTourist(Long id) throws TouristNotFoundException {
		getTouristById(id);
		repo.deleteById(id);
		return "Tourist deleted with id: " + id +" successfuly. ";
	}

	@Override //---------------------------------------------------------------update one tourist
	public String updateTouristById(Long id, Vo_Tourist vo) throws TouristNotFoundException {
		Tourist tourist = repo.findById(id)
				.orElseThrow(() -> new TouristNotFoundException("Tourist with id " + id + ", not found."));
		
		if (vo.getName() != null) tourist.setName(vo.getName());
		if (vo.getAddr() != null) tourist.setAddr(vo.getAddr());
		if (vo.getFromLoc() != null) tourist.setFromLoc(vo.getFromLoc());
		if (vo.getToLoc() != null) tourist.setToLoc(vo.getToLoc());
		if (vo.getBudget() != null) tourist.setBudget(vo.getBudget());
		
		tourist = repo.save(tourist);
		return "Tourist with id: "+tourist.getId()+" updated successfuly.";
	}

	
	//---------------------------------------------------help
	
	private List<Vo_Tourist> convert(List<Tourist> list){
		
		List<Vo_Tourist> volist = new ArrayList<>();
		for (Tourist t : list) {
			Vo_Tourist vo = new Vo_Tourist();
			BeanUtils.copyProperties(t, vo);
			volist.add(vo);
		}
		
		return volist;
	}
	
	

}

