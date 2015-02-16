package gene.toolkit.prefs;

import java.io.File;
import java.util.Map;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.ListEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;

public class ProjectPageControlBuilder {

		
	public static StringFieldEditor buildTextEditor(String option, String caption, Composite parent, IPreferenceStore store) {
		StringFieldEditor editor = new StringFieldEditor(option, caption, parent);
		editor.setPreferenceStore(store);
		editor.setEmptyStringAllowed(false);
		editor.setValidateStrategy(StringFieldEditor.VALIDATE_ON_FOCUS_LOST);
		editor.load();		
		return editor;
	}
	
	public static ListEditor buildDependencyListEditor(String option, String caption, Composite parent, IPreferenceStore store) {
			ListEditor listDepends = new ListEditor(option, caption, parent) {
			
			@Override
			protected String[] parseString(String str) {
				return str.split("\\|");
			}
			
			@Override
			protected String getNewInputObject() {
				InputDialog input = new InputDialog(null, "New dependency", "Enter path to library", "", 
					new IInputValidator() {
					
					    private Map<String, String> env = java.lang.System.getenv();
					
						@Override
						public String isValid(String arg) {
							
							for (String var : env.keySet()) {
								arg = arg.replaceAll("%" + var + "%", env.get(var));
							}
							
							File file = new File(arg);
							
							if (!file.exists()) {
								return "File " + arg + " does not exists.";
							}
							
							return null;
						}
					});
				
				
				
				if (input.open() == Window.OK) {
					return input.getValue();
				}
				
				return null;
			}
			
			@Override
			protected String createList(String[] strs) {
				StringBuilder sb = new StringBuilder();
				for (String str : strs) {
					sb.append(str);
					sb.append("|");
				}
				sb.deleteCharAt(sb.length() - 1);
				return sb.toString();
			}
		};
		
		listDepends.setPreferenceStore(store);
		listDepends.load();
		return listDepends;
	}
	
}
