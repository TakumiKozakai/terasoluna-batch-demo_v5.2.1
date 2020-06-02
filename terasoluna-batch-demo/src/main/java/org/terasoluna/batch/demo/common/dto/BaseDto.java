package org.terasoluna.batch.demo.common.dto;

import lombok.Data;

@Data
public abstract class BaseDto {

	private int updateKbn;
	private String createDate;
	private String updateDate;

}
