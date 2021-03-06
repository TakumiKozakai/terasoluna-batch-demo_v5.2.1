package org.terasoluna.batch.demo.common.callback;

import java.io.IOException;
import java.io.Writer;
import java.util.Calendar;

import javax.inject.Inject;

import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.terasoluna.batch.demo.common.dto.Header;
import org.terasoluna.batch.demo.common.repository.HeaderRepository;

@Component
@Scope("step")
public class Info1FlatFileHeaderWriter implements FlatFileHeaderCallback {

	@Inject
	HeaderRepository headerRepository;

	@Override
	public void writeHeader(Writer writer) throws IOException {

		Header header = new Header();
		header = this.headerRepository.select();

		Calendar cal = Calendar.getInstance();
		StringBuilder now = new StringBuilder();
		now.append("前回出力年月日," + header.getOutputDate());
		now.append(",今回出力年月日," + cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE));
		now.append("\n");

		writer.write(now.toString());
		writer.write("id,type,status,point,create_date,update_date");
	}

}
