package se.disabledsecurity.borg.alcove.functions;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import io.vavr.Function0;
import se.disabledsecurity.borg.alcove.model.internal.County;
import se.disabledsecurity.borg.alcove.model.internal.Location;
import se.disabledsecurity.borg.alcove.model.internal.Locations;

import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Functions {

	private Functions() {
	}

	public static final Function0<CsvSchema> locationsSchema = Function0
			.of(() -> CsvSchema
					.builder()
					.addColumn("county")
					.addColumn("municipality")
					.addColumn("code")
					.build()
					.withSkipFirstDataRow(true)
					.withColumnSeparator(';'))
			.memoized();

	public static final Function0<CsvMapper> csvMapper = Function0
			.of(CsvMapper::new)
			.memoized();

	public static final UnaryOperator<String> trim = String::trim;
	public static final Function<List<County>, List<Location>> mapToFrontendModel = counties -> counties
			.stream()
			.map(county -> Location
					.builder()
					.county(county)
					.build())
			.toList();

	private static final Function<List<Location>, Locations> mapToInternalModel = Locations::from;

	public static final Function<List<County>, Locations> map = mapToFrontendModel.andThen(mapToInternalModel);

}
