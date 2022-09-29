package com.xtd.ybls.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 冯瑞宁
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiveUser implements java.io.Serializable{

	private Integer id;
	
	private String name;
	
	private String password;
	
	private String station;
}
