package org.terasoluna.batch.demo.csvtodb.chunk;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import org.terasoluna.batch.demo.common.dto.Info2Dto;

@Component
public class Info2DeleteProcessor implements ItemProcessor<Info2Dto, Info2Dto> {

	@Override
	public Info2Dto process(Info2Dto item) throws Exception {

		if (item.getUpdateKbn() == 3)
			return item;
		else
			return null;

	}
}
