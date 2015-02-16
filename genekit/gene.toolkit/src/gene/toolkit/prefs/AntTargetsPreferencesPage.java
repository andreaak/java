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
 * Ant Targets preferences page.
 * @author odem
 */
public class AntTargetsPreferencesPage extends PreferencePage implements IWorkbenchPreferencePage {

	private StringFieldEditor txtHibernateTarget = null;
	private StringFieldEditor txtWsdlTarget = null;
	
	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

	@Override
	protected Control createContents(Composite comp) {
		
		Composite composite  = new Composite(comp, SWT.FILL);
		composite.setSize(comp.getSize());
		
		GridLayout layout = new GridLayout(2, true);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		
		gridData.grabExcessHorizontalSpace = true;
		composite.setLayout(layout);
		
		
		txtHibernateTarget = new StringFieldEditor(Options.HIBERNATE_GEN_TARGET, "Target for generating Hibernate entities", composite);
		txtHibernateTarget.setPreferenceStore(getPreferenceStore());
		txtHibernateTarget.setEmptyStringAllowed(false);
		txtHibernateTarget.setValidateStrategy(StringFieldEditor.VALIDATE_ON_FOCUS_LOST);
		txtHibernateTarget.load();
		
		txtWsdlTarget = new StringFieldEditor(Options.WSDL_GEN_TARGET, "Target for generating stubs from WSDL", composite);
		txtWsdlTarget.setPreferenceStore(getPreferenceStore());
		txtWsdlTarget.setEmptyStringAllowed(false);
		txtWsdlTarget.setValidateStrategy(StringFieldEditor.VALIDATE_ON_FOCUS_LOST);
		txtWsdlTarget.load();
		
		
		
		return comp;
	}
	
	@Override
	protected void performApply() {
		txtHibernateTarget.store();
		txtWsdlTarget.store();
		super.performApply();
	}
	
	@Override
	protected void performDefaults() {
		txtHibernateTarget.loadDefault();
		txtWsdlTarget.loadDefault();
		super.performDefaults();
	}

}
