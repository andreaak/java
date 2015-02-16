package gene.toolkit.prefs.products;

import gene.toolkit.Activator;
import gene.toolkit.model.Entity;
import gene.toolkit.prefs.ProjectPageControlBuilder;

import org.eclipse.jface.preference.ListEditor;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public abstract class GeneProjectPage extends PreferencePage implements IWorkbenchPreferencePage {

	private StringFieldEditor txtProjectName;
	private StringFieldEditor txtProjectOutput;
	private ListEditor listDepends;
	
	protected abstract Entity getEntity();
	
	@Override
	protected Control createContents(Composite comp) {
		Composite composite  = new Composite(comp, SWT.FILL);
		composite.setSize(comp.getSize());
		
		GridLayout layout = new GridLayout(2, true);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		
		gridData.grabExcessHorizontalSpace = true;
		composite.setLayout(layout);
	
      txtProjectName = ProjectPageControlBuilder.buildTextEditor(getEntity().getProjectName(), "Project Name", composite, getPreferenceStore());
      txtProjectOutput = ProjectPageControlBuilder.buildTextEditor(getEntity().getProjectOut(), "Output Directory Name", composite, getPreferenceStore());
      listDepends = ProjectPageControlBuilder.buildDependencyListEditor(getEntity().getProjectDepends(), "Dependencies", composite, getPreferenceStore());
		
		return comp;
	}

	@Override
	public void init(IWorkbench arg0) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	@Override
	protected void performApply() {
		txtProjectName.store();
		txtProjectOutput.store();
		listDepends.store();
		super.performApply();
	}
	
	@Override
	protected void performDefaults() {
		txtProjectName.loadDefault();
		txtProjectOutput.loadDefault();
		listDepends.loadDefault();
		super.performDefaults();
	}
	
}
