package gene.toolkit;

import gene.toolkit.prefs.Options;

public enum System {
	GCM(Options.GCM_PROJ_DIR, Options.GCM_PROJ_DESC),
	MOL(Options.MOL_PROJ_DIR, Options.MOL_PROJ_DESC),
	BIO(Options.BIO_PROJ_DIR, Options.BIO_PROJ_DESC),
	CTG(Options.CTG_PROJ_DIR, Options.CTG_PROJ_DESC),
	FLW(Options.FLW_PROJ_DIR, Options.FLW_PROJ_DESC),
	HLA(Options.HLA_PROJ_DIR, Options.HLA_PROJ_DESC),
	DXP(Options.DXP_PROJ_DIR, Options.DXP_PROJ_DESC),
	ACC(Options.ACC_PROJ_DIR, Options.ACC_PROJ_DESC),
	MIC(Options.MIC_PROJ_DIR, Options.MIC_PROJ_DESC),
	LAB5(Options.LAB5_PROJ_DIR, Options.LAB5_PROJ_DESC);
	
	private String dir;
	private String desc;
	System(String dir, String desc){
	   this.dir = dir;
	   this.desc = desc;
	}
	
	public String getDir() {
	   return dir;
	}
	
	public String getDescription() {
      return desc;
   }
}
