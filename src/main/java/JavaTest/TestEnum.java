package JavaTest;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-06-09
 */

public enum TestEnum {

    NOT_AUDIT(0, "未审核", "a"),
    NOT_PASS(1, "审核未通过", "b"),
    HAS_AUDIT(2, "已审核", "c"),
    NOT_SIGN(3, "未签约", "d"),
    HAS_SIGN(4, "已签约", "e");

    private int x;
    private String y;
    private String z;


    public int getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    public String getZ() {
        return z;
    }

    TestEnum(int x, String y, String z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void printValues() {
        System.out.println(this.x+","+this.y+","+this.z);
    }

    public static TestEnum getEnumByKey(int key) {
        for (TestEnum testEnum : TestEnum.values()) {
            if (testEnum.getX() == key) {
                return testEnum;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        for (TestEnum testEnum : TestEnum.values()) {
            System.out.println(testEnum.getX() + "," + testEnum.getY()+","+testEnum.getZ());
        }
        System.out.println(TestEnum.HAS_AUDIT);
        TestEnum.HAS_AUDIT.printValues();

    }
}
