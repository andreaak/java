package gene.toolkit.handlers.ws;

import gene.toolkit.Activator;
import gene.toolkit.model.Entity;
import gene.toolkit.prefs.Options;

import java.io.File;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;

public class WsGenProcessBuilder {

   public static Process createProcess(Entity entity) throws CoreException {
      
      String buildFile = entity.getProjectBuildFile();
      
      String target = Activator.getDefault().getPreferenceStore().getString(Options.WSDL_GEN_TARGET);
      
      Process p = DebugPlugin.exec(new String[] { "cmd", "/C", Options.ANT_RUN, "-f", buildFile, target } , new File(Options.GENE_DIR));
      
      return p;
   }
   
}
