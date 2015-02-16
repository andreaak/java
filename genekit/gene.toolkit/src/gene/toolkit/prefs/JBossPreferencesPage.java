package gene.toolkit.prefs;

import gene.toolkit.Activator;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * JBoss preferences page.
 * @author odem
 */
public class JBossPreferencesPage extends PreferencePage implements IWorkbenchPreferencePage {

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

	private StringFieldEditor txtInstance = null;
	private StringFieldEditor txtArchive = null;
	
	@Override
	protected Control createContents(Composite comp) {
		Composite composite  = new Composite(comp, SWT.FILL);
		composite.setSize(comp.getSize());
		
		GridLayout layout = new GridLayout(2, true);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		
		gridData.grabExcessHorizontalSpace = true;
		composite.setLayout(layout);
		
	
		txtInstance = new StringFieldEditor(Options.JBOSS_INSTANCE_NAME, "Server instance name", composite);
		txtInstance.setPreferenceStore(getPreferenceStore());
		txtInstance.setEmptyStringAllowed(false);
		txtInstance.setValidateStrategy(StringFieldEditor.VALIDATE_ON_FOCUS_LOST);
		txtInstance.load();
		
		txtArchive = new StringFieldEditor(Options.EAR_ARCHIVE_NAME, "Application archive", composite);
		txtArchive.setPreferenceStore(getPreferenceStore());
		txtArchive.setEmptyStringAllowed(false);
		txtArchive.setValidateStrategy(StringFieldEditor.VALIDATE_ON_FOCUS_LOST);
		txtArchive.load();
	
		return comp;
	}
	
	@Override
	protected void performApply() {
		txtInstance.store();
		txtArchive.store();
		super.performApply();
	}

	@Override
	protected void performDefaults() {
		txtInstance.loadDefault();
		txtArchive.loadDefault();
		super.performDefaults();
	}

}
