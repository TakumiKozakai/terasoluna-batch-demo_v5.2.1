package org.terasoluna.batch.demo.common.listener;

import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobExecutionLoggingListener implements JobExecutionListener {

	private static final Logger logger = LoggerFactory.getLogger(JobExecutionLoggingListener.class);
	private static long startMillisTime = 0;
	private static long endMillisTime = 0;

	@Override
	public void beforeJob(JobExecution jobExecution) {
		logger.info("job started. [JobName:{}]", jobExecution.getJobInstance().getJobName());

		// 処理開始時間計測
		startMillisTime = System.currentTimeMillis();
		logger.trace("job TRACE started. [JobName:{}]", jobExecution.getJobInstance().getJobName());
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		logger.info("job finished.[JobName:{}][ExitStatus:{}]", jobExecution.getJobInstance().getJobName(),
				jobExecution.getExitStatus().getExitCode());

		// 処理終了時間計測
		endMillisTime = System.currentTimeMillis();
		// 処理経過時間算出
		long processingMillisTime = endMillisTime - startMillisTime;
		// 処理経過時間をログ出力
		logger.trace("job TRACE finished. [JobName:{}] : 処理時間（ミリ）： " + processingMillisTime + " ms", jobExecution.getJobInstance().getJobName());

		// 処理経過時間をファイルに外出し
		try {
			PrintWriter pw = new PrintWriter("/log/processing-time.txt");
			pw.println("[JobName:{}] : 処理時間（ミリ）： " + processingMillisTime + " ms");
			pw.close();
		} catch (IOException e) {
			logger.error("When print processing-time, IOException. [JobName:{}]", jobExecution.getJobInstance().getJobName());
		}
	}
}