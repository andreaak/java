package com.java._11_Annotations._02_Test;

import com.java._11_Annotations._02_Test.Models.PersonalData;
import com.java._11_Annotations._02_Test.Models.UniversityGroup;
import org.junit.Test;

public class Main {
    @Test
    public void TestAnnotation1() {
        System.out.println(TestHandler.test(UniversityGroup.class, PersonalData.class));
        /*
        UniversityGroupsNumber is = true
        PersonalData is = true
        true
         */
    }
}