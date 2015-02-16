package gene.toolkit.handlers;

import gene.toolkit.prefs.Options;

import java.io.File;
import java.util.Date;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

public class RedeployHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent arg0) throws ExecutionException {
		
		String path = Options.SERVER_APP_FILE;
		
		File f = new File(path);
		
		if (f.exists()) {
			f.setLastModified(new Date().getTime());
		}
		
		return null;
	}

}
