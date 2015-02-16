package gene.toolkit.utils;

import gene.toolkit.Activator;
import gene.toolkit.model.EntityFactory;
import gene.toolkit.prefs.Options;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class ExplodedDeployer {

   public void performFullDeployment() throws Exception {

      MessageConsole console = Activator.getDefault().getConsole();
      ConsolePlugin.getDefault().getConsoleManager().showConsoleView(console);
      console.clearConsole();
      MessageConsoleStream out = console.newMessageStream();

      out.println("Creating exploded deployment...");
      out.println();

      removeExplodedDir(out);
      removeLinksInJBossDirectory(out);
      explodingArchive(out);
      relinkArchives(out);

      out.println("-----------------------------------------------------");
      out.println("Completed.");
   }

   private void relinkArchives(MessageConsoleStream out) throws Exception,
         IOException, InterruptedException {
      String explodedLibPath = Options.EXPLODED_SERVER_PATH + File.separator + Options.EAR_ARCHIVE
            + File.separator + "lib" + File.separator;
      String warDir = Options.EXPLODED_SERVER_PATH + File.separator + Options.EAR_ARCHIVE + File.separator;
      String appsDir = Options.GENE_DIR + File.separator + "apps" + File.separator;

      out.println("Creating links for archives...");
      relink(explodedLibPath + "GcmWebServices.jar", appsDir + File.separator
            + "gcm" + File.separator + "dist" + File.separator + "server"
            + File.separator + "build");
      relink(explodedLibPath + "MolWebService.jar", appsDir + File.separator
            + "mol" + File.separator + "dist" + File.separator + "server"
            + File.separator + "build");
      relink(explodedLibPath + "CtgWebService.jar", appsDir + File.separator
            + "ctg" + File.separator + "dist" + File.separator + "server"
            + File.separator + "build");
      relink(explodedLibPath + "BioWebService.jar", appsDir + File.separator
            + "bio" + File.separator + "dist" + File.separator + "server"
            + File.separator + "build");
      relink(explodedLibPath + "HlaWebService.jar", appsDir + File.separator
            + "hla" + File.separator + "dist" + File.separator + "server"
            + File.separator + "build");
      relink(explodedLibPath + "DxpWebService.jar", appsDir + File.separator
            + "dxp" + File.separator + "dist" + File.separator + "server"
            + File.separator + "build");
      relink(explodedLibPath + "FlwWebService.jar", appsDir + File.separator
            + "flw" + File.separator + "dist" + File.separator + "server"
            + File.separator + "build");
      relink(explodedLibPath + "AccWebService.jar", appsDir + File.separator
            + "acc" + File.separator + "dist" + File.separator + "server"
            + File.separator + "build");

      String apps = Options.GENE_DIR
            + File.separator + "apps" + File.separator;
      String warPathSuffix = File.separator + "dist" + File.separator
            + "server" + File.separator;
      EntityFactory.getEntity(gene.toolkit.System.GCM).getDistFullPath();
      relink(warDir + "GcmWebServices.war", apps + "gcm" + warPathSuffix
            + "GcmWebServices");
      relink(warDir + "SoftAccWebServices.war", apps + "acc" + warPathSuffix
            + "SoftAccWebServices");
      relink(warDir + "SoftMolWebServices.war", apps + "mol" + warPathSuffix
            + "SoftMolWebServices");
      relink(warDir + "SoftBioWebServices.war", apps + "bio" + warPathSuffix
            + "SoftBioWebServices");
      relink(warDir + "SoftCtgWebServices.war", apps + "ctg" + warPathSuffix
            + "SoftCtgWebServices");
      relink(warDir + "SoftHlaWebServices.war", apps + "hla" + warPathSuffix
            + "SoftHlaWebServices");
      relink(warDir + "SoftFlwWebServices.war", apps + "flw" + warPathSuffix
            + "SoftFlwWebServices");
      relink(warDir + "SoftDxpWebServices.war", apps + "dxp" + warPathSuffix
            + "SoftDxpWebServices");

      // 5. Linking jboss to exploded directory
      out.println("Linking JBoss '" + Options.JBOSS_INSTANCE + "' instance to " + Options.EXPLODED_SERVER_PATH
            + File.separator + Options.EAR_ARCHIVE + "...");

      String command = "cmd /C mklink /J " 
      + Options.EAR_SERVER_PATH 
      + " " + Options.EXPLODED_SERVER_PATH + File.separator
            + Options.EAR_ARCHIVE;
      Process p = Runtime.getRuntime().exec(command);
      if (p.waitFor() != 0) {
         out.println("Could not link JBoss to local exploded archive. The command was: '"
               + command + "'");
      }
   }

   private void explodingArchive(MessageConsoleStream out)
         throws IOException, FileNotFoundException {
      File earSandboxArchive = new File(Options.EAR_DIST_PATH + File.separator + Options.EAR_ARCHIVE);
      
      if (!earSandboxArchive.exists()) {
         out.println("Could not find EAR file: "
               + earSandboxArchive.getAbsolutePath());
         return;
      } else {
         out.println("Exploding archive " + earSandboxArchive.getAbsolutePath()
               + " to " + Options.EXPLODED_SERVER_PATH + File.separator + Options.EAR_ARCHIVE);
         JarFile car = new JarFile(earSandboxArchive);
         Enumeration<JarEntry> en = car.entries();

         while (en.hasMoreElements()) {
            JarEntry entry = (JarEntry) en.nextElement();

            File entryFile = new File(Options.EXPLODED_SERVER_PATH + File.separator + Options.EAR_ARCHIVE
                  + File.separator + entry.getName());

            if (entry.isDirectory()) {
               if (!entryFile.exists()) {
                  entryFile.mkdirs();
               }
               continue;
            }

            InputStream is = car.getInputStream(entry);
            FileOutputStream fos = new FileOutputStream(entryFile);

            while (is.available() > 0) {
               byte[] bytes = new byte[512];
               int readed = is.read(bytes);
               fos.write(bytes, 0, readed);
            }

            is.close();
            fos.close();
         }
      }
   }

   private void removeLinksInJBossDirectory(MessageConsoleStream out)
         throws IOException, InterruptedException {

      File serverLinkFile = new File( Options.EAR_SERVER_PATH);

      if (serverLinkFile.exists()) {
         out.println("Removing link " +  Options.EAR_SERVER_PATH);
         String removeOldDirLinkCommand = "cmd /C rmdir /S /Q " +  Options.EAR_SERVER_PATH;
         Process removeOldDir = Runtime.getRuntime().exec(
               removeOldDirLinkCommand);

         if (removeOldDir.waitFor() != 0) {
            out.println("Could not delete link. The command was: '"
                  + removeOldDirLinkCommand + "'");
            return;
         }
      }
   }

   private void removeExplodedDir(MessageConsoleStream out) throws IOException,
         InterruptedException {
      // 1. Removing old exploded directory
      File dirFile = new File(Options.EXPLODED_SERVER_PATH);

      if (dirFile.exists() && dirFile.isDirectory()) {
         out.println("Removing old exploded deployment directory. " + Options.EXPLODED_SERVER_PATH);

         String removeOldDirCommand = "cmd /C rmdir /S /Q " + Options.EXPLODED_SERVER_PATH;
         Process removeOldDir = Runtime.getRuntime().exec(removeOldDirCommand);

         if (removeOldDir.waitFor() != 0) {
            out.println("Could not delete directory. The command was: '"
                  + removeOldDirCommand + "'");
            return;
         }
      }
   }

   private void relink(String file, String target) throws Exception {
      File f = new File(file);
      if (f.exists()) {
         f.delete();
      }

      if (file.endsWith(".war")) {
         // Here we need to copy manifest to exploded folder.
         String warFile = target + ".war";
         JarFile webArchive = new JarFile(new File(warFile));
         Manifest manifest = webArchive.getManifest();
         
         File manifestDir = new File(target + File.separator + "META-INF");
         if (!manifestDir.exists()) {
            manifestDir.mkdirs();
         }
         
         File outputManifest = new File(target + File.separator + "META-INF" + File.separator + "MANIFEST.MF");
         
         if (!outputManifest.exists()) {
            outputManifest.createNewFile();
         }
         manifest.write(new FileOutputStream(outputManifest));
      }

      File targetFile = new File(target);
      if (!targetFile.exists()) {
         return;
      }

      String command = "cmd /C mklink /J " + file + " " + target;
      Process p = Runtime.getRuntime().exec(command);

      if (!(p.waitFor() == 0)) {
         throw new Exception("Could not create link from " + file + " to "
               + target + ". The command was: '" + command + "'");
      }
   }

}
