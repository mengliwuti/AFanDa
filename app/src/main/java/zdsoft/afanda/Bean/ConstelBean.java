package zdsoft.afanda.Bean;

/**
 * Created by FYF on 2016/11/25.
 */
public class ConstelBean {
    String name;
    String datetime;
    String all;
    String color;
    String health;
    String love;
    String money;
    String number;
    String qfriend;
    String summary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getQfriend() {
        return qfriend;
    }

    public void setQfriend(String qfriend) {
        this.qfriend = qfriend;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public ConstelBean(String name, String datetime, String all, String color, String health, String love, String money, String number, String qfriend, String summary) {
        this.name = name;
        this.datetime = datetime;
        this.all = all;
        this.color = color;
        this.health = health;
        this.love = love;
        this.money = money;
        this.number = number;
        this.qfriend = qfriend;
        this.summary = summary;
    }

    public ConstelBean() {
        super();
    }
}
