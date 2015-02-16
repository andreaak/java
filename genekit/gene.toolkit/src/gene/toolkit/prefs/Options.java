package gene.toolkit.prefs;

import java.io.File;

/**
 * This class holds the names of the options, used by Gene Toolkit.
 * @author odem
 */
public final class Options {
	
   public static final String NDRIVE = "NDRIVE";
   public static final String NSDIR = "NSDIR";
   public static final String JCLASS_DIR = "JCLASS_DIR";
   public static final String ROOT_DIR = java.lang.System.getenv(NSDIR);
   public static final String GENE_DIR = ROOT_DIR + File.separator + "gene";
   public static final String GENERATE_STUB = "Generate Web Service Stub";
   public static final String GENERATE_HIBERNATE_TEXT = "Generate Hibernate Entities";
   /**
	 * JBoss instance name (configuration)
	 */
	public static final String JBOSS_INSTANCE_NAME = "jboss.instance.name";
   public static final String JBOSS_HOME = "JBOSS_HOME";
   public static final String JBOSS_HOME_DIR = System.getenv(Options.JBOSS_HOME);
   public static final String JBOSS_INSTANCE = "default";
   
	/**
	 * The name of Soft Gene EAR archive.
	 */
	public static final String EAR_ARCHIVE_NAME = "ear.archive.name";
   public static final String EAR_ARCHIVE = "GeneticSuite_3.2.ear";
	/**
	 * Ant target to generate Hibernate entities.
	 */
	public static final String HIBERNATE_GEN_TARGET = "ant.generate.hibernate";
   public static final String HIBERNATE_GEN_TARGET_CMD =  "runHbm2Java";	
	/**
	 * Ant target to generate Web Services stubs.
	 */
	public static final String WSDL_GEN_TARGET = "ant.generate.wsdl";
   public static final String WSDL_GEN_TARGET_CMD = "wsdl2java";
   /**
    * Exploded deployment.
    */
   public static final String EXPLODED_SERVER_PATH = System.getenv(NDRIVE) + File.separator + "Server";
   public static final String SERVER_APP_FILE =  System.getenv(Options.NDRIVE) + File.separator + "Server" + File.separator + EAR_ARCHIVE_NAME + File.separator + "META-INF" + File.separator + "application.xml";
   
   public static final String EAR_DIST_PATH = ROOT_DIR 
            + File.separator + "gene" 
            + File.separator + "dist" 
            + File.separator + "server"
            + File.separator + "jboss4";
   public static final String EAR_SERVER_PATH = JBOSS_HOME_DIR 
         + File.separator + "server"
         + File.separator + JBOSS_INSTANCE 
         + File.separator + "deploy"
         + File.separator + EAR_ARCHIVE;
   
   public static final String ANT_HOME = "ANT_HOME";
   public static final String ANT_RUN = System.getenv(ANT_HOME) + File.separator + "bin" + File.separator + "ant.bat";

   public static final String ACC_PROJ_DIR = "acc";
   public static final String GCM_PROJ_DIR = "gcm";
   public static final String MOL_PROJ_DIR = "mol";
   public static final String BIO_PROJ_DIR = "bio";
   public static final String CTG_PROJ_DIR = "ctg";
   public static final String HLA_PROJ_DIR = "hla";
   public static final String FLW_PROJ_DIR = "flw";
   public static final String DXP_PROJ_DIR = "dxp";
   public static final String MIC_PROJ_DIR = "gmic";
   public static final String LAB5_PROJ_DIR = "glab";
   
   public static final String ACC_PROJ_DESC = "SoftPreAnalytical";
   public static final String GCM_PROJ_DESC = "SoftGcm";
   public static final String MOL_PROJ_DESC = "SoftMolecular";
   public static final String BIO_PROJ_DESC = "SoftBioChemistry";
   public static final String CTG_PROJ_DESC = "SoftCytogenetics";
   public static final String HLA_PROJ_DESC = "SoftHLA";
   public static final String FLW_PROJ_DESC = "SoftFlowCytometry";
   public static final String DXP_PROJ_DESC = "SoftPathDx";
   public static final String MIC_PROJ_DESC = "SoftMicro";
   public static final String LAB5_PROJ_DESC = "SoftLab";
}
