package se.disabledsecurity.borg.alcove.functions;

import io.vavr.Function1;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import se.disabledsecurity.borg.alcove.entity.County;

public class JpaExampleFunctions {
    private JpaExampleFunctions() {
    }

    public static final Function1<String, Example<County>> findCountyByName = name -> Example.of(County.builder().name(name).build(),
                                                                                                 ExampleMatcher
                                                                                                         .matching()
                                                                                                         .withIgnorePaths("id", "municipalities","code")
                                                                                                         .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                                                                                                         .withIgnoreCase());


}
