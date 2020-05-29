package org.terasoluna.batch.demo.csvtodb.tasklet;

import javax.inject.Inject;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.terasoluna.batch.demo.common.dto.Info2Dto;
import org.terasoluna.batch.demo.common.repository.Info2Repository;

@Component
@Scope("step")
public class Info2Tasklet implements Tasklet {

	@Inject
	ItemStreamReader<Info2Dto> reader;

	@Inject
	Info2Repository repository;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		Info2Dto item = null;

		try {
			reader.open(chunkContext.getStepContext().getStepExecution().getExecutionContext());

			while ((item = reader.read()) != null) {

				if (item.getUpdateKbn() == 2)
					repository.updatePointAndStatus(item);
				else if (item.getUpdateKbn() == 3)
					repository.delete(item);

			}
		} finally {
			try {
				reader.close();
			} catch (ItemStreamException e) {
				// do nothing.
			}
		}

		return RepeatStatus.FINISHED;
	}
}
