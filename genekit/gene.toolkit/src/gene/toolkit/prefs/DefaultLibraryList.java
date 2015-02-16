package gene.toolkit.prefs;

import gene.toolkit.System;

import java.io.File;

public final class DefaultLibraryList {
	
	private System system;
	
	private DefaultLibraryList() {
	}
	
	public DefaultLibraryList(System system) {
		this();
		this.system = system;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
	
		if (system == System.GCM) {
			appendDefaultGeneLibraries(result);
			appendJClassSCCLibraries(result);
			appendIsfLibraries(result);
			appendImgLibraries(result);
		} else {
			appendDefaultGeneLibraries(result);
			appendImgLibraries(result);
		}
		
		if (result.length() > 0) {
		   result.deleteCharAt(result.length() - 1);
		}
		return result.toString();
	}
	
	private void appendDefaultGeneLibraries(StringBuilder sb) {
//		String dir = java.lang.System.getenv("NSDIR") + File.separator + "gene" + File.separator + "lib";
//		appendJarsInDirectory(sb, dir);
		String dir = Options.GENE_DIR + File.separator + "lib";
      appendJarsInDirectory(sb, dir);
      dir = Options.GENE_DIR + File.separator + "genelib3p";
      appendJarsInDirectory(sb, dir);
	}
	
	private void appendJClassSCCLibraries(StringBuilder sb) {
		String dir = java.lang.System.getenv(Options.JCLASS_DIR) + File.separator + "lib";
		appendJarsInDirectory(sb, dir,"orb");
	}
	
	private void appendIsfLibraries(StringBuilder sb) {
		String dir = java.lang.System.getenv("NSDIR") + File.separator + "gene"  + File.separator + "apps"  + File.separator + "isf"  + File.separator + "dist"  + File.separator + "server";
		appendJarsInDirectory(sb, dir);
	}
	
	private void appendImgLibraries(StringBuilder sb) {
		String dir = java.lang.System.getenv("NSDIR") + File.separator + "gene"  + File.separator + "apps"  + File.separator + "img"  + File.separator + "dist"  + File.separator + "server";
		appendJarsInDirectory(sb, dir);
	}
	
	private void appendJarsInDirectory(StringBuilder sb, String directory) {
	   appendJarsInDirectory(sb, directory, "");
   }
	
	private void appendJarsInDirectory(StringBuilder sb, String directory, String pref) {
		
	   final String JAR_SUFFIX = pref + ".jar";
		File lib = new File(directory);
		if (lib.exists()) {
			String[] files = lib.list();
			
			for (String file : files) {
				if (file.endsWith(JAR_SUFFIX)) {
					sb.append(directory + File.separator + file).append("|");
				}
			}
		}
	}

}
