package ro.teamnet.javadays.meet1;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 4/26/12
 * Time: 5:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class HowAboutCollections {

    private final List<String> list;

    public HowAboutCollections(List<String> list) {
        this.list = list;
    }


    public List<String> getTheList() {
        Collections.synchronizedList(Arrays.asList("gogo"));
        return Collections.unmodifiableList(list);
    }
    public static void main(String[] args) {

        final int bitCountFor32 = Integer.numberOfLeadingZeros(32);
        System.out.println(bitCountFor32);
        // printSystemEnvironmentVars();
    }

    private static void printSystemEnvironmentVars() {
        final Map<String,String> envVars =
                new TreeMap(System.getenv());
       final Set<String> keys =  envVars.keySet();

        for(String key : keys) {
            System.out.println(String.format("%s => %s", key, envVars.get(key) ));
        }
    }
}
