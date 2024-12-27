package com.java._07_Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;
import java.util.Map.Entry;

@RunWith(JUnit4.class)
public class _02_ArrayList {
	
	@Test
    public void Test1() {
		// объявление списка
		ArrayList<String> arrayList = new ArrayList<>();

		// добавление элементов в список
		arrayList.add("Hello");
		arrayList.add("student");
		arrayList.add("would you?");

		System.out.println(arrayList);

		// добавление по индексу
		arrayList.add(0, "teacher");

		// удаление элементов по индексу
		arrayList.remove(1);

		// удаление элементов по значению
		arrayList.remove("would you?");

		System.out.println(arrayList);

		/*
		[Hello, student, would you?]
		[teacher, student]
		 */
    }

	@Test
    public void Test2() {
		ArrayList<String> arrayList = new ArrayList<>();

		arrayList.add("name");
		arrayList.add("surname");

		// задаем вместимость листа
		arrayList.ensureCapacity(30);

		// размер листа на текущее время
		System.out.println(arrayList.size());

		// достаем элемент по индексу
		System.out.println(arrayList.get(1));

		// Ошибка IndexOutOfBoundException
		// System.out.println(arrayList.get(2));

		// достаем индекс объекта
		System.out.println(arrayList.indexOf("name"));

		//достаем индекс объекта с конца
		System.out.println(arrayList.lastIndexOf("surname"));

		//достаем индекс объекта с конца
		System.out.println(arrayList.lastIndexOf("---"));
		/*
		2
		surname
		0
		1
		-1
		 */
    }

	@Test
	public void Test3IteratorWithWhile() {
		ArrayList<Integer> arrayList = new ArrayList<>();

		arrayList.add(3);
		arrayList.add(5);
		arrayList.add(7);

		// с помощью итератора можем бегать по нашему списку
		Iterator<Integer> iterator = arrayList.iterator();

		// спрашиваем есть ли следующий элемент в списке, если true, то будет реализовано тело while
		while (iterator.hasNext()) {// it.hasNext() doesn't switch to next position
			// переходим к следующему элементу в списке и его выводим
			Integer integer = iterator.next();// it.next() switch to next position
			System.out.println(integer);
		}
		// то же самое действие, но через оптимизированный итератор под cписки
		ListIterator<Integer> listIterator = arrayList.listIterator();

		while (listIterator.hasNext()) {
			Integer integer = listIterator.next();
			System.out.println(integer);
		}
	}

	@Test
    public void Test1IteratorWithFor() {
		ArrayList<String> list =  new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");

		//Iterator<String> it = list.iterator();
		int i = 0;
		for(Iterator<String> it = list.iterator(); it.hasNext();) {// it.hasNext() doesn't switch to next position
			System.out.println("Index :" + i);
			if(i++ == 1) {
				continue;
			}
			System.out.println(it.next());// it.next() switch to next position
		}
    }

	@Test
    public void Test3RemoveItem() {
		ArrayList<String> list =  new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		
		//Iterator<String> it = list.iterator();
		int i = 0;
		for(Iterator<String> it = list.iterator(); it.hasNext();) {
			System.out.println(it.next());// it.next() switch to next position
			if(i++ == 1) {
				it.remove();//use it.remove() after it.next()
			}
			//System.out.println(it.next());
		}
    }
}
