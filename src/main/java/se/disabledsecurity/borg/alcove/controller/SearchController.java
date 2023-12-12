package se.disabledsecurity.borg.alcove.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.disabledsecurity.borg.alcove.model.internal.Locations;
import se.disabledsecurity.borg.alcove.service.SearchService;

@RequestMapping("api")
@RestController
public class SearchController {

	private final SearchService searchService;

	public SearchController(SearchService searchService) {
		this.searchService = searchService;
	}

	@GetMapping("/counties/search")
	public Locations searchCountiesByName(@RequestParam String name) {
		// Implement the logic to search for counties by name using countyService
		return searchService.searchCountiesByName(name);
	}

	@GetMapping("/municipalities/search")
	public Locations searchMunicipalitiesByName(@RequestParam String name) {
		// Implement the logic to search for municipalities by name using municipalityService
		return searchService.searchMunicipalitiesByName(name);
	}
}