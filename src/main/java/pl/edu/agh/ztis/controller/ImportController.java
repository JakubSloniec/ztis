package pl.edu.agh.ztis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.ztis.configuration.Configuration;
import pl.edu.agh.ztis.importer.GeomediaFullDataClassImporter;

import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by Jakub Sloniec on 2016-04-03.
 */

@RestController
@RequestMapping("/api/import")
@Api(value = "import", description = "Import API")
public class ImportController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "import all notes to DB", notes = "imports all notes from files to database", response = Void.class)
	void importAll() {
		try {
			Files.walkFileTree(Configuration.GEOMEDIA_FULL_DATA_PATH, new GeomediaFullDataClassImporter());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
