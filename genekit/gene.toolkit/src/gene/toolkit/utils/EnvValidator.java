package gene.toolkit.utils;

import gene.toolkit.prefs.Options;

import java.io.File;
import java.util.Map;

public final class EnvValidator {

	private Map<String, String> variables = null;

	public Map<String, String> getVariables() {
		return variables;
	}
	
	public void validate() throws InvalidEnvironmentException {
		variables = System.getenv(); 
		
		
		// NSDIR, NDRIVE, JCLASS_DIR, JBOSS_HOME, ANT_HOME
		validateVariable(Options.NSDIR, true, true);
		validateVariable(Options.NDRIVE, true, true);
		validateVariable(Options.JCLASS_DIR, true, true);
		validateVariable(Options.JBOSS_HOME, true, true);
		validateVariable(Options.ANT_HOME, true, true);
	}
	
	private void validateVariable(String variable, boolean isFsEntry, boolean isDir) throws InvalidEnvironmentException {
		String path = "";
		String err = "";
		
		if (!variables.keySet().contains(variable)) {
			throw new InvalidEnvironmentException("'" + variable + "' variable is not set.");
		}
		
		if (isFsEntry) {
		   path = variables.get(variable);
		   err = getFileEntryError(path, true);
		   if (!err.equals("")) {
			   throw new InvalidEnvironmentException(err);
		   }
		}
	}
	
	
	private String getFileEntryError(String path, boolean isDir) {
		File entry = new File(path);
		
		if (!entry.exists()) {
			return path + " does not exists.";
		}
		
		if (!entry.canRead()) {
			return path + " is not read-accessible";
		}
		
		if (!entry.canWrite()) {
			return path + " is not write-accessible";
		}
		
		if (isDir && !entry.isDirectory()) {
			return path + " is not a directory.";
		}
		
		
		return "";
	}
	
}
