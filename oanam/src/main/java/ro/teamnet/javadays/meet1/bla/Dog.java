package ro.teamnet.javadays.meet1.bla;

import ro.teamnet.javadays.meet1.Animal;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 4/30/12
 * Time: 10:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class Dog implements Animal {

    @Override
    public void eat() {
        System.out.println("Ham!");
    }
}
