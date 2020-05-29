package org.terasoluna.batch.demo.common.repository;

import org.apache.ibatis.cursor.Cursor;
import org.terasoluna.batch.demo.common.dto.Info2Dto;

public interface Info2Repository {
	Cursor<Info2Dto> cursor();

	int updatePointAndStatus(Info2Dto info);

	int delete(Info2Dto info);
}
