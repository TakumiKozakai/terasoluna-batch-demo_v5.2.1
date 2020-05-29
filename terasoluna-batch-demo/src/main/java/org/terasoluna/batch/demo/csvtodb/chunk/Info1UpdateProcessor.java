package org.terasoluna.batch.demo.csvtodb.chunk;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import org.terasoluna.batch.demo.common.dto.Info1Dto;

@Component
public class Info1UpdateProcessor implements ItemProcessor<Info1Dto, Info1Dto> {

	@Override
	public Info1Dto process(Info1Dto item) throws Exception {

		if (item.getUpdateKbn() == 2)
			return item;
		else
			return null;

	}
}
