package org.terasoluna.batch.demo.common.dto;

import lombok.Data;

@Data
public abstract class BaseDto {

	private String createrName;
	private String createDate;
	private String updaterName;
	private String updateDate;

}
