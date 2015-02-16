package state;

import java.io.File;

public class RunPattern{
    public static void main(String [] arguments){
        System.out.println("Example for the State pattern");
        System.out.println();
        
        if (!(new File("appointments.ser").exists())){
            DataCreator.serialize("appointments.ser");
        }
        
        System.out.println("Creating CalendarEditor");
        CalendarEditor appointmentBook = new CalendarEditor();
        System.out.println("");
        
        System.out.println("Created. Appointments:");
        System.out.println(appointmentBook.getAppointments());
        
        System.out.println("Created. Creating GUI:");
        StateGui application = new StateGui(appointmentBook);
        application.createGui();
        System.out.println("");
        
//        A a = new B();
//        if(a instanceof B)
//        {
//        	System.out.println(true);
//        	
//        }
//        
//        if(a.getClass().equals(B.class))
//        {
//        	System.out.println(true);
//        }
//        
//        B b = new B();
//        if(b instanceof A)
//        {
//        	System.out.println(true);
//        	
//        }
//        
//        if(b.getClass().equals(A.class))
//        {
//        	System.out.println(true);
//        	
//        }
//        
//        A c = new A();
//        if(c instanceof B)
//        {
//        	System.out.println(true);
//        	
//        }
//        
//        if(c.getClass() == B.class)
//        {
//        	System.out.println(true);
//        	
//        }
        
    }
    
    public static class A
    {
    	
    	
    }
    public static class B extends A
    {
    	
    	
    }
}