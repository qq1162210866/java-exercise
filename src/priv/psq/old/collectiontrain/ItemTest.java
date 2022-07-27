package priv.psq.old.collectiontrain;

import java.util.Objects;

/**
 * ItemTest.java
 * Description:  树集
 *
 * @author Peng Shiquan
 * @date 2020/8/16
 */
public class ItemTest implements Comparable<ItemTest> {

    private String description;
    private int partNumber;

    public ItemTest(String adescription, int apartNumber) {
        description = adescription;
        partNumber = apartNumber;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ItemTest{" +
                "description='" + description + '\'' +
                ", partNumber=" + partNumber +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        /**
         * 比较，需要注意的是对象可能是个null对象，但是仍然要返回true
         */
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ItemTest other = (ItemTest) obj;
        return Objects.equals(description, other.description) && partNumber == other.partNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    @Override
    public int compareTo(ItemTest o) {
        /**
         * 比较int的大小和string的长度
         */
        int diff = Integer.compare(partNumber, o.partNumber);
        return diff != 0 ? diff : description.compareTo(o.description);
    }
}
