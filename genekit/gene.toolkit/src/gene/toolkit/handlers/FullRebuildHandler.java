package gene.toolkit.handlers;

import gene.toolkit.Activator;
import gene.toolkit.utils.EnvValidator;
import gene.toolkit.utils.InvalidEnvironmentException;

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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.MessageConsoleStream;

public class FullRebuildHandler extends AbstractHandler implements IStreamListener {

	private MessageConsoleStream out = null;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		MessageDialog dlg = new MessageDialog(null, "Full Rebuild", null, "Perform full rebuild?", MessageDialog.QUESTION, new String[] { "Yes",  "No" }, 0);
		
		EnvValidator validator = new EnvValidator();
		try {
			validator.validate();
		} catch (InvalidEnvironmentException e) {
			Activator.getDefault().getConsole().newMessageStream().println("Environment is not in valid state. Please run 'Validate Environment' utility.");
		}
		
		if (dlg.open() == 0) {
			ILaunchConfigurationType type = DebugPlugin.getDefault().getLaunchManager().getLaunchConfigurationType("gene.toolkit.fullbuild");
			
			ILaunch launch;
			try {
				out = Activator.getDefault().getConsole().newMessageStream();
				Activator.getDefault().getConsole().clearConsole();
				ConsolePlugin.getDefault().getConsoleManager().showConsoleView(Activator.getDefault().getConsole());
				out.println("Performing full rebuild...");
				
				ILaunchConfigurationWorkingCopy wc = type.newInstance(null, "Full Build");
				launch = wc.launch(ILaunchManager.RUN_MODE, new NullProgressMonitor());
				IStreamsProxy sp = launch.getProcesses()[0].getStreamsProxy();
				sp.getOutputStreamMonitor().addListener(this);
				sp.getErrorStreamMonitor().addListener(this);
			} catch (CoreException e) {
				Activator.getDefault().getConsole().newMessageStream().println(e.getMessage());
			}
		} 
		
		return null;
	}
	
	@Override
	public void streamAppended(String line, IStreamMonitor arg1) {
        out.println(line);
	}

}
