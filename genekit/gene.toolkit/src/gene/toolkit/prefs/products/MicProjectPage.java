package gene.toolkit.prefs.products;

import gene.toolkit.model.Entity;
import gene.toolkit.model.EntityFactory;

import org.eclipse.ui.IWorkbenchPreferencePage;

public class MicProjectPage extends GeneProjectPage implements IWorkbenchPreferencePage {

   private Entity entity; 
   
   @Override
   protected Entity getEntity() {
      if(entity == null) {
         entity = EntityFactory.getEntity(gene.toolkit.System.MIC);
      }
      return entity;
   }
}
