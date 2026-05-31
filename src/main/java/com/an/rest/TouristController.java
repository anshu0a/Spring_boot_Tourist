package com.an.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.an.exceptions.MissingDataException;
import com.an.exceptions.TouristNotFoundException;
import com.an.svs.ITourtstService;
import com.an.vo.Vo_Tourist;

@RestController
@RequestMapping("/tourist")
public class TouristController {

	@Autowired
	private ITourtstService svs;

	@GetMapping("") // ----------------------------------------------------- [ get Tourist / filter ]

	public ResponseEntity<List<Vo_Tourist>> getAll(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String addr, 
			@RequestParam(required = false) String fromLoc,
			@RequestParam(required = false) String toLoc) {

		Vo_Tourist tour = new Vo_Tourist(name, addr, fromLoc, toLoc);

		List<Vo_Tourist> list = svs.getAllTouristByFilter(tour);
		ResponseEntity<List<Vo_Tourist>> re = new ResponseEntity<List<Vo_Tourist>>(list, HttpStatus.OK);
		return re;
	}

	@GetMapping("/get/{id}") // ---------------------------------------- [ get Tourist with id ]

	public ResponseEntity<Object> getById(@PathVariable Long id) {

		ResponseEntity<Object> re;
		try {
			Vo_Tourist vo = svs.getTouristById(id);
			re = new ResponseEntity<>(vo, HttpStatus.OK);

		} catch (TouristNotFoundException e) {
			System.err.println(e.getLocalizedMessage());
			re = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return re;
	}

	@DeleteMapping("/delete/{id}") // ---------------------------------------- [ delete Tourist with id ]
	public ResponseEntity<Object> deleteById(@PathVariable Long id) {
		ResponseEntity<Object> re;
		try {
			String msg = svs.deleteTourist(id);
			re = new ResponseEntity<>(msg, HttpStatus.OK);

		} catch (TouristNotFoundException e) {
			System.err.println(e.getLocalizedMessage());
			re = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return re;
	}

	@PostMapping("/add") // ---------------------------------------- [ add one Tourist ]
	public ResponseEntity<String> addTourist(@RequestBody Vo_Tourist vo) {

		ResponseEntity<String> re;
		try {
			String msg = svs.registerTourist(vo);
			re = new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (MissingDataException e) {
			System.err.println("Error: " + e.getLocalizedMessage());
			re = ResponseEntity.badRequest().body(e.getMessage());
		}
		return re;
	}
	
	@PatchMapping("/update/{id}") // ---------------------------------------- [ update one Tourist ]
	public ResponseEntity<String> updateTourist(@PathVariable Long id, @RequestBody Vo_Tourist vo) {

		ResponseEntity<String> re;
		try {
			String msg = svs.updateTouristById(id, vo);
			re = new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (TouristNotFoundException e) {
			System.err.println("Error: " + e.getLocalizedMessage());
			re = ResponseEntity.badRequest().body(e.getMessage());
		}
		return re;
	}

//=================================================================================================================================================

	@GetMapping("/*") // ---------------------------------------- [ get wrong url ]
	public ResponseEntity<String> getdefault() {
		ResponseEntity<String> re = new ResponseEntity<String>("Wrong url path for Get Request, \ncheck wisely.",
				HttpStatus.BAD_REQUEST);
		return re;
	}

	@PostMapping("/*") // ---------------------------------------- [ post wrong url ]
	public ResponseEntity<String> postDefault() {
		ResponseEntity<String> re = new ResponseEntity<String>("Wrong url path for Post request, \ncheck wisely.",
				HttpStatus.BAD_REQUEST);
		return re;
	}

}
