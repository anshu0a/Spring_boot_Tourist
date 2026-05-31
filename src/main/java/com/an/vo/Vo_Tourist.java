package com.an.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vo_Tourist {
	private Long id;
	private String name;
	private String addr;
	private Double budget;
	private String fromLoc;
	private String toLoc;
	
	public Vo_Tourist(String name, String addr, String fromLoc, String toLoc) {
		super();
		this.name = name;
		this.addr = addr;
		this.fromLoc = fromLoc;
		this.toLoc = toLoc;
	}
	
}
