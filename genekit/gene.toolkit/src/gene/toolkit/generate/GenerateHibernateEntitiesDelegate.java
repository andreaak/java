package gene.toolkit.generate;

import gene.toolkit.Activator;
import gene.toolkit.model.EntityFactory;
import gene.toolkit.prefs.Options;

import java.io.File;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

public class GenerateHibernateEntitiesDelegate implements ILaunchConfigurationDelegate {

	@Override
	public void launch(ILaunchConfiguration arg0, String arg1, ILaunch launch, IProgressMonitor arg3) throws CoreException {

	    String buildFile = EntityFactory.getEntity(gene.toolkit.System.GCM).getProjectBuildFile();
    
	    
	    String target = Activator.getDefault().getPreferenceStore().getString(Options.HIBERNATE_GEN_TARGET);
		
	
		Process p = DebugPlugin.exec(new String[] { "cmd", "/C", Options.ANT_RUN, "-f", buildFile, target }, new File(Options.GENE_DIR));
		DebugPlugin.newProcess(launch, p, Options.GENERATE_HIBERNATE_TEXT);
	}
	
	
}
