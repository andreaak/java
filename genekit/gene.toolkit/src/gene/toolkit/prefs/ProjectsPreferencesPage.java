package gene.toolkit.prefs;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class ProjectsPreferencesPage extends PreferencePage implements IWorkbenchPreferencePage{

	@Override
	protected Control createContents(Composite arg0) {
		Label lbl = new Label(arg0, SWT.CENTER);
		lbl.setText("Expand tree to see Soft Gene projects generating preferences.");
		return arg0;
	}

	@Override
	public void init(IWorkbench arg0) {
		noDefaultAndApplyButton();
	}

}
