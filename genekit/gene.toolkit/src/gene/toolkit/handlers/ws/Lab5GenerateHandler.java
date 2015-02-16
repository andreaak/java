package gene.toolkit.handlers.ws;

import gene.toolkit.model.Entity;
import gene.toolkit.model.EntityFactory;
import org.eclipse.debug.core.IStreamListener;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;


public class Lab5GenerateHandler extends GeneGenerateHandler implements ILaunchConfigurationDelegate, IStreamListener {

   private Entity entity; 
   
   @Override
   protected Entity getEntity() {
      if(entity == null) {
         entity = EntityFactory.getEntity(gene.toolkit.System.LAB5);
      }
      return entity;
   }

}
