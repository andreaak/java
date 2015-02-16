package gene.toolkit.fullbuild;

import gene.toolkit.prefs.Options;

import java.io.File;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

public class FullBuildDelegate implements ILaunchConfigurationDelegate {

	public void launch(ILaunchConfiguration conf, String arg1, ILaunch launch, IProgressMonitor arg3) throws CoreException {
		Process p = DebugPlugin.exec(new String[] { "cmd", "/C", "BuildModulesPackEar.bat" }, new File(Options.GENE_DIR));
		DebugPlugin.newProcess(launch, p, "Full Build");		
	}

}
