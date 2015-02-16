package gene.toolkit.handlers;

import gene.toolkit.Activator;
import gene.toolkit.prefs.Options;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.IStreamListener;
import org.eclipse.debug.core.model.IStreamMonitor;
import org.eclipse.debug.core.model.IStreamsProxy;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.MessageConsoleStream;


public class GenerateHibernateEntitiesHandler extends AbstractHandler implements IStreamListener {

	private MessageConsoleStream out = null;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ILaunchConfigurationType type = DebugPlugin.getDefault().getLaunchManager().getLaunchConfigurationType("gene.toolkit.generate.hibernate");
		
		ILaunch launch;
		try {
			out = Activator.getDefault().getConsole().newMessageStream();
			Activator.getDefault().getConsole().clearConsole();
			ConsolePlugin.getDefault().getConsoleManager().showConsoleView(Activator.getDefault().getConsole());
			out.println(Options.GENERATE_HIBERNATE_TEXT + "...");
			
			ILaunchConfigurationWorkingCopy wc = type.newInstance(null, "Hbm2Java");
			launch = wc.launch(ILaunchManager.RUN_MODE, new NullProgressMonitor());
			IStreamsProxy sp = launch.getProcesses()[0].getStreamsProxy();
			sp.getOutputStreamMonitor().addListener(this);
			sp.getErrorStreamMonitor().addListener(this);
		} catch (CoreException e) {
			Activator.getDefault().getConsole().newMessageStream().println(e.getMessage());
		}
	
		return null;
	}

	@Override
	public void streamAppended(String line, IStreamMonitor arg1) {
		out.println(line);
	}

	
	
}
