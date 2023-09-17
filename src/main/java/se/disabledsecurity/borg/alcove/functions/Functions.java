package se.disabledsecurity.borg.alcove.functions;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import io.vavr.Function0;

import java.util.function.UnaryOperator;

public class Functions {

	private Functions() {}
	public static final Function0<CsvSchema> locationsSchema = Function0.of(() -> CsvSchema
			.builder()
			.addColumn("county")
			.addColumn("municipality")
			.addColumn("code")
			.build()
			.withSkipFirstDataRow(true)
			.withColumnSeparator(';')).memoized();

	public static final Function0<CsvMapper> csvMapper = Function0.of(CsvMapper::new).memoized();

	public static final UnaryOperator<String> trim = String::trim;
}
