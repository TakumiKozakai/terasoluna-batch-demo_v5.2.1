package org.terasoluna.batch.demo.common.repository;

import org.apache.ibatis.cursor.Cursor;
import org.terasoluna.batch.demo.common.dto.Info1Dto;

public interface Info1Repository {
	Cursor<Info1Dto> cursor();

	int update(Info1Dto info);

	int delete(Info1Dto info);
}
