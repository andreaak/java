package gene.toolkit.utils;

import gene.toolkit.Activator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.ui.console.MessageConsoleStream;

public class LinkManager {

	public static void createJunction(String linkPath, String target) throws IOException {
		File file = new File(linkPath);
		if (file.exists()) {
			try{
			   file.delete();
			   FilesystemUtils.delete(file);
			} catch (Exception ex) {
			   throw new IOException("Could not create junction!." + ex.getMessage());
			}
		}
		
		File targetFile = new File(target);
		
		if (!targetFile.exists()) {
			throw new IOException("Could not create junction!. Target object " + target + " is not found!");
		}
		
		
		
		Process p = Runtime.getRuntime().exec("cmd.exe /C \"mklink /J " + linkPath + " " + target + "\"");
		
		BufferedReader stdout = new BufferedReader(new InputStreamReader(p.getInputStream()));
		BufferedReader stderr = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		
		MessageConsoleStream output = Activator.getDefault().getConsole().newMessageStream();
		
		String line = "";
		while ((line = stdout.readLine()) != null) {
			output.println(line);
		}
		
		while ((line = stderr.readLine()) != null) {
			output.println(line);
		}
		
		if (p.exitValue() != 0) {
			throw new IOException("Could not create junction " + linkPath + " <==> " + target);
		}
	}
	
}
