package org.terasoluna.batch.demo.dbtocsv.tasklet;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.ItemStreamWriter;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.terasoluna.batch.demo.common.dto.Info1Dto;

@Component
@Scope("step")
public class Info1Tasklet implements Tasklet {

	@Inject
	ItemStreamReader<Info1Dto> reader;

	@Inject
	ItemStreamWriter<Info1Dto> writer;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		Info1Dto item = null;
		List<Info1Dto> items = new ArrayList<>();

		try {
			reader.open(chunkContext.getStepContext().getStepExecution().getExecutionContext());
			writer.open(chunkContext.getStepContext().getStepExecution().getExecutionContext());

			while ((item = reader.read()) != null) {
				items.add(item);
			}

			writer.write(items);

		} finally {
			try {
				writer.close();

			} catch (ItemStreamException e) {
				// do nothing.
			}
		}

		return RepeatStatus.FINISHED;
	}

}
