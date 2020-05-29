package org.terasoluna.batch.demo.common.dto;

public abstract class Info {

	private int updateKbn;
	private String createDate;
	private String updateDate;

	public int getUpdateKbn() {
		return updateKbn;
	}

	public void setUpdateKbn(int updateKbn) {
		this.updateKbn = updateKbn;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}
