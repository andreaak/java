package gene.toolkit;

import gene.toolkit.handlers.GenerateProjectsHandler;
import gene.toolkit.model.Entity;
import gene.toolkit.model.EntityFactory;
import gene.toolkit.prefs.DefaultLibraryList;
import gene.toolkit.prefs.Options;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "gene.toolkit"; 

	// The shared instance
	private static Activator plugin;
	
	private MessageConsole console = null;
	
	/**
	 * The constructor
	 */
	public Activator() {
        console = new MessageConsole("Gene Tools", new ImageDescriptor() {
			
			@Override
			public ImageData getImageData() {
				ImageData data = new ImageData(GenerateProjectsHandler.class.getResourceAsStream("/gene/toolkit/icons/testtube.png"));
				return data;
			}
		});
		
		ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[] { console });
	}
	
	public MessageConsole getConsole() {
		return console;
	}

	/*
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		
		
		getPreferenceStore().setDefault(Options.HIBERNATE_GEN_TARGET, Options.HIBERNATE_GEN_TARGET_CMD);
	   getPreferenceStore().setDefault(Options.WSDL_GEN_TARGET, Options.WSDL_GEN_TARGET_CMD);
	   getPreferenceStore().setDefault(Options.EAR_ARCHIVE_NAME, Options.EAR_ARCHIVE);
	   getPreferenceStore().setDefault(Options.JBOSS_INSTANCE_NAME, Options.JBOSS_INSTANCE);

	   for(System sys : System.values()) {
	      Entity entity = EntityFactory.getEntity(sys);
	      getPreferenceStore().setDefault(entity.getProjectName(), entity.getProjectDesc());
	      getPreferenceStore().setDefault(entity.getProjectOut(), "build");
	      getPreferenceStore().setDefault(entity.getProjectDepends(), new DefaultLibraryList(sys).toString());
	   }
	   
		plugin = this;
	}

	/*
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
