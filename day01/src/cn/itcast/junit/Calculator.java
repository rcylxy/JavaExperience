package cn.itcast.junit;

/**
 * @Classname Calculator
 * @Date 2022/6/29 9:44
 * @Created by 李晓阳
 */
public class Calculator {

    private int ability;
    public long maxToCal;
    private String name;

    public int getAbility() {
        return ability;
    }

    public void setAbility(int ability) {
        this.ability = ability;
    }

    public void setMaxToCal(long maxToCal) {
        this.maxToCal = maxToCal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMaxToCal() {
        return maxToCal;
    }

    public String getName() {
        return name;
    }

    public Calculator() {
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "ability=" + ability +
                ", maxToCal=" + maxToCal +
                ", name='" + name + '\'' +
                '}';
    }

    public Calculator(int ability, long maxToCal, String name) {
        this.ability = ability;
        this.maxToCal = maxToCal;
        this.name = name;
    }

    public int add() {
        System.out.println(1);
        return 1;
    }


}
