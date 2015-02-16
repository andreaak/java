package gene.toolkit.model;

import java.util.HashMap;
import java.util.Map;

import gene.toolkit.System;

public class EntityFactory {

   private static Map<System, Entity> entities =  new HashMap<System, Entity>();
   
   public static Entity getEntity(System sys) {
      
      if(entities.containsKey(sys)) {
         return entities.get(sys);
      }
      Entity entity = new Entity(sys);
      entities.put(sys, entity);
      return entity;
   }
}
