/*
 *  
 *  Fosstrak LLRP Commander (www.fosstrak.org)
 * 
 *  Copyright (C) 2008 ETH Zurich
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/> 
 *
 */

package org.fosstrak.llrp.commander.repository;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;
import org.fosstrak.llrp.client.ROAccessReportsRepository;
import org.fosstrak.llrp.commander.repository.log.DerbyROAccessReportsRepository;

/**
 * The LLRP message repository implementation based on Sun JavaDB.
 * Please make sure the derby.jar in the build path before you can
 * start the database.
 *
 * @author Haoning Zhang
 * @author sawielan
 * @version 1.0
 */

public class JavaDBRepository extends AbstractSQLRepository {

	// Log4j instance.
	private static Logger log = Logger.getLogger(JavaDBRepository.class);
	
	// a handle to the RO_ACCESS_REPORTS logging table.
	protected DerbyROAccessReportsRepository repoROAccessReports = null;
	
	// Database connection string
	
	private static final String DB_PROTOCOL = "jdbc:derby:";
	private static final String DB_CREATE = ";create=true";
	
    
	/** the location of the repository. */
	private final String repoLocation;
	
	/**
	 * construct a new java db repository.
	 * @param repoLocation the location where to create/load the repository.
	 */
	public JavaDBRepository(String repoLocation) {
		if (repoLocation == null) {
			repoLocation = DB_NAME;
		}
		this.repoLocation = repoLocation + DB_NAME;
	}

	@Override
	protected Connection openConnection() throws Exception {
		 return DriverManager.getConnection(DB_PROTOCOL + repoLocation + DB_CREATE);
	}

	public ROAccessReportsRepository getROAccessRepository() {
		if (null == repoROAccessReports) {
			log.debug("No RepoROAccessReports handle yet - Create a new one.");
			repoROAccessReports = new DerbyROAccessReportsRepository();
		}
		return repoROAccessReports;
	}
}

