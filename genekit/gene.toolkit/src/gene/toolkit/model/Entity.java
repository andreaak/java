package gene.toolkit.model;

import java.io.File;

import gene.toolkit.System;
import gene.toolkit.prefs.Options;

public class Entity {
   
   private System system;   
   private String projectDir;
   private String projectBuildFile;
   private String projectFile;  
   private String projectCPFile;   
   
   public Entity(System sys) {
      system = sys;
   }

   public System getSystem() {
      return system;
   }
   
   public String getProjectFullPath() {
      if(projectDir == null) {
         
         projectDir = Options.ROOT_DIR
               + File.separator + "gene"
               + File.separator + "apps"
               + File.separator + getProjectDir()
               + File.separator + "src"
               + File.separator + "ws"
               + File.separator + "wsjava";
      }
      return projectDir;
   }
   
   public String getProjectBuildFile() {
      if(projectBuildFile == null) {
         
         projectBuildFile = Options.ROOT_DIR
               + File.separator + "gene"
               + File.separator + "apps"
               + File.separator + getProjectDir()
               + File.separator + "src"
               + File.separator + "ws"
               + File.separator + "wsjava"
               + File.separator + "build.xml";
      }
      return projectBuildFile;
   }
   
   public String getProjectFile() {
      if(projectFile == null) {
         
         projectFile = Options.ROOT_DIR
               + File.separator + "gene"
               + File.separator + "apps"
               + File.separator + getProjectDir()
               + File.separator + "src"
               + File.separator + "ws"
               + File.separator + "wsjava"
               + File.separator + ".project";
      }
      return projectFile;
   }
   
   public String getProjectClassPathFile() {
      if(projectCPFile == null) {
         
         projectCPFile = Options.ROOT_DIR
               + File.separator + "gene"
               + File.separator + "apps"
               + File.separator + getProjectDir()
               + File.separator + "src"
               + File.separator + "ws"
               + File.separator + "wsjava"
               + File.separator + ".classpath";
      }
      return projectCPFile;
   }  

   public String getDistFullPath() {
      if(projectDir == null) {
         
         projectDir = Options.ROOT_DIR
               + File.separator + "gene"
               + File.separator + "apps" 
               + File.separator + getProjectDir() 
               + File.separator +  "dist" 
               + File.separator + "server" 
               + File.separator + "build";
      }
      return projectDir;
   }
   
   public String getServerLinkFullPath() {
      if(projectDir == null) {
         
         projectDir = Options.ROOT_DIR
               + File.separator + "gene"
               + File.separator + "apps" 
               + File.separator + getProjectDir() 
               + File.separator +  "dist" 
               + File.separator + "server";
      }
      return projectDir;
   }
   
   public String getLaunchConf() {
      return "gene.toolkit.ws." + getProjectDir();
   }
   
   public String getProjectOut() {
      return "gene.projects."+ getProjectDir() +".out";
   }
   
   public String getProjectName() {
      return "gene.projects."+ getProjectDir() +".name";
   }
   
   public String getProjectDepends() {
      return "gene.projects."+ getProjectDir() +".deps";
   }

   public String getProjectDir() {
      return system.getDir();
   }
   
   public String getProjectDesc() {
      return system.getDescription();
   }
}
