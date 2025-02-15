package com.java._11_Annotations._01_Base;



public class AnotherDog extends Dog {
}

// К классу Dog добавится полная информация об аннотации @Mammal в JavaDoc
@Mammal(color = Color.GREY, sound = "Woof")
class Dog {
    @HasHair
    public void hair() {

    }
}




