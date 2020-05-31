package org.terasoluna.batch.demo.common.dto;

import javax.validation.constraints.Max;

import lombok.Data;

@Data
public class Info1Dto extends Info {

	private String id;
	private String type;
	private String status;
	@Max(1000000)
	private int point;
	private int deleteFlg;

}
