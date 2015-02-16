package gene.toolkit.handlers;

import gene.toolkit.Activator;
import gene.toolkit.utils.ExplodedDeployer;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

public class FixDeployHandler  extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent arg0) throws ExecutionException {
		
		Thread thr = new Thread(new Runnable() {
			
			@Override
			public void run() {
				ExplodedDeployer deployer = new ExplodedDeployer();
				try {
					deployer.performFullDeployment();
				} catch (Exception e) {
					Activator.getDefault().getConsole().newMessageStream().println(e.getMessage());
				}
			}
		});
		
		
		thr.start();
		return null;
	}

}
