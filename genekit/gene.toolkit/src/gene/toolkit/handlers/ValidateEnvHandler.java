package gene.toolkit.handlers;

import gene.toolkit.Activator;
import gene.toolkit.prefs.Options;
import gene.toolkit.utils.EnvValidator;
import gene.toolkit.utils.InvalidEnvironmentException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.MessageConsoleStream;

public class ValidateEnvHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Activator.getDefault().getConsole().clearConsole();
		ConsolePlugin.getDefault().getConsoleManager().showConsoleView(Activator.getDefault().getConsole());
		MessageConsoleStream out = Activator.getDefault().getConsole().newMessageStream();
		
		
		out.println("Validating environment...");
		
		EnvValidator validator = new EnvValidator();
		boolean valid = true;
		
		try {
			validator.validate();
		} catch (InvalidEnvironmentException e) {
			valid = false;
			out.println(e.getMessage());
			out.println("Enviroment is not in valid state.");
		}
		
		if (valid) {
			out.println("----------------------------------------------");
			out.println("NSDIR: " + validator.getVariables().get(Options.NSDIR));
			out.println("NDRIVE: " + validator.getVariables().get(Options.NDRIVE));
			out.println("JCLASS_DIR: " + validator.getVariables().get(Options.JCLASS_DIR));
			out.println("JBOSS_HOME: " + validator.getVariables().get(Options.JBOSS_HOME));
			out.println("ANT_HOME: " + validator.getVariables().get(Options.ANT_HOME));
			out.println("----------------------------------------------");
			out.println("Environment is valid.");
		}
		
		return null;
	}


}
